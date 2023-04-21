package com.calendar;

import java.util.Calendar;

/**
 * ClassName: TestCalendar
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/3/24 9:46
 * @Version 1.0
 */
public class TestCalendar {
    public static void main(String[] args) {
        // 先生成一个实例
        Calendar calendar = Calendar.getInstance();

        int dayResult = calendar.get(Calendar.HOUR_OF_DAY) + 1;
        System.out.println(dayResult);


        calendar.set(Calendar.HOUR_OF_DAY, dayResult);
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
    }

}
