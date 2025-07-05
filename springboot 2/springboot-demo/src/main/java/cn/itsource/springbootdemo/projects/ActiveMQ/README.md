# activemq

## installation

win10, [apache-activemq-6.1.6](https://dlcdn.apache.org//activemq/6.1.6/apache-activemq-6.1.6-bin.zip)

## introduction

- 点对点消息
- 发布订阅消息

## ERROR

### ERROR | Failed to start Apache ActiveMQ due to: java.net.BindException: Address already in use: bind

```shell
# 查看端口占用
netstat -ano | findstr :5672
# 查看进程
taskkill /PID 5672 /F
# 确保没有重复启动 ActiveMQ
./activemq stop
# 重启activemq，and visit: http://127.0.0.1:8161/admin/
bin/activemq start
```

