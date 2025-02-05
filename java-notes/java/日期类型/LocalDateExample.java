package com.sise.lession93;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class LocalDateExample {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now(); // 获取当前日期
        String birthdayStr = "2000-05-20";
        LocalDate birthday = LocalDate.parse(birthdayStr, DateTimeFormatter.ISO_LOCAL_DATE); // 解析生日字符串为LocalDate对象

        Period period = Period.between(birthday, now); // 计算生日到当前日期相差的年、月、日
        int years = period.getYears();
        int months = period.getMonths();
        int days = period.getDays();

        System.out.printf("你已经活了 %d 年 %d 月 %d 天%n", years, months, days); // 输出相差的天数
    }
}
