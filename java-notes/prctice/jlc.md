### 【后端、前端】 #884660 电子标签绑定新增打印状态以及打印次数 ✔

背景：固定资产电子标签打印没有打印次数导致工厂重复打印飞达标签

需求：新增字段：打印状态、打印次数

a. 打印状态，默认为未打印，通过“电子标签打印”、“电子小标签打印”、“电子标签批量打印”、功能打印标签后，状态更新为已打印；历史数据处理：默认为已打印

b. 打印次数，默认为0，通过“电子标签打印”、“电子小标签打印”、“电子标签批量打印”、功能打印标签后，次数+1；历史数据处理：默认为空

实现：

1. 新增字段：项目用的 spingboot3 + mybatis(generator) + mysql，本地新增 sql 字段后，修改 mybatis 的配置 `generatorConfig.properties` 和 `generatorConfig.xml` 如生成的表、类名和产物路径后，点击项目 MAVEN 插件【mybatis-generator】即可生成 mapper、model 文件。

2. 字段赋值：新建 mapper extend 文件接口。

    ```sql
    -- 已执行 DEV FAT UAT
    -- 1 新增字段的语句
    ALTER TABLE `ims_equipment`.`tag_bind` 
    ADD COLUMN print_status INT DEFAULT 0 COMMENT '打印状态', 
    ADD COLUMN print_count INT DEFAULT NULL COMMENT '打印次数';

    -- 2 功能语句，通过查表的 id 批量更新字段值
    UPDATE ims_equipment.tag_bind SET print_count = IFNULL(print_count, 0) + 1, print_status = 1 WHERE tag_bind_key_id IN (1, 2, 3, 4); 

    -- 其他测试语句
    UPDATE `ims_equipment`.`tag_bind` SET print_count = null;
    ALTER TABLE `ims_equipment`.`tag_bind` MODIFY `print_status` INT DEFAULT 0 COMMENT '打印状态';
    ALTER TABLE `ims_equipment`.`tag_bind` MODIFY `print_count` INT DEFAULT null COMMENT '打印次数';
    ```

### 【后端、前端】 #928778 填写主轴维修单，使用数量填写支持小数点后两位 ✔

mybatis-generator 更新类型

```sh
# sql
ALTER TABLE ims_equipment.spindle_repair_item MODIFY used_number DECIMAL(15,2) DEFAULT NULL COMMENT '使用数量';
```

### 【后端、前端】 #918083 修改品质扣款时，嘉立创采购单限制不能选择品质扣款类型 ✔

```java
// 最终处理方式为品质扣款时，采购单不能是嘉立创的
Boolean isDisposalTypeKK = DisposalTypeEnum.KK.getValue().equals(qualityDeductionVO.getDisposalType());
if (isDisposalTypeKK) {
    String systemSystem = AccountsLegalEnum.getAccountsLegalSourceSystem(materialQualityDeduction.getCompanyCode());
    Boolean isJlc = SourceSystemEnum.JLC.getSystemCode().equals(systemSystem);

    if (isJlc) {
        throw new BusinessException("嘉立创采购单的品质扣款单，最终处理方式不能为品质扣款");
    }
}

// 详情接口新增字段
@Schema(description = "组织来源")
private String sourceSystem;

// 根据组织号查来源
if (materialQualityDeduction.getCompanyCode() != null) {
    String sourceSystem = AccountsLegalEnum.getAccountsLegalSourceSystem(materialQualityDeduction.getCompanyCode());
    if (!sourceSystem.isEmpty()) {
        qualityDeductionBO.setSourceSystem(sourceSystem);
    }
}
```

问题：
1. 只有嘉立创的才需要屏蔽？品质扣款单根据哪个来判断是否嘉立创的采购单？

    是的，sourceSystem === 'JLC'

2. 新增时是否需要屏蔽？

    不需要，不过后端校验是通用的，新增编辑提交时都加了校验

3. 旧历史数据怎么处理？

    脏数据有组织号为空的，但不多，后面校验的时候，会根据采购单号查组织号

## 查看日志

### 日志 elastic 定位报错问题

- 确认后端项目有无上报日志，确认报错接口和关键字

- (新建一个 Discover 页面) pattern: fat.ims-equipment-tomcat-access

  搜索栏直接搜接口名："/tagBind/page" 找到报错 id

- (新建一个 Discover 页面) pattern: fat.ims-equipment-business

  搜索栏直接搜异常字段："电子标签绑定分页查询异常"

  根据第二步的报错 id 匹配到对应的数据
