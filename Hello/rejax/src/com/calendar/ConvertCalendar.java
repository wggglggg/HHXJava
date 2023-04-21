package com.calendar;

import java.util.Calendar;
import java.util.concurrent.CancellationException;

/**
 * ClassName: ConvertCalendar
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/3/24 10:03
 * @Version 1.0
 */
public class ConvertCalendar {

    public static void main(String[] args) {
//        Calendar calendar = Calendar.getInstance();
//
//        // 将日期手动设置为 1号,因为打印日期从1号开始,并且下面还要判断1号为星期几
//        calendar.set(Calendar.DATE, 1);
//        // 星期天是1, 星期一2, 星期二3, .....星期六7,所以要-1
//        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
////        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
//        // 判断一下是否为星期天,如果星期天就改为7,其它都-1,这样才是正确的星期几
//        dayOfWeek = (dayOfWeek == 7) ? 1 : dayOfWeek - 1;
//
//        // 获取最后一天为几号
////        System.out.println(Calendar.DAY_OF_MONTH);  // DAY_OF_MONTH与DATE 最后一天为周几
//        int lastDay = calendar.getActualMaximum(Calendar.DATE);
//
//        // 准备打印日历
//        // 先在日历上访显示 xxxx年xx月
//        // %21s ,""   表示21个替换为空格字符串
//        String yearAndMonth = String.format("%21s%d年%d月", "", calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1);
//        System.out.println(yearAndMonth);
//        System.out.println("   星期一  星期二  星期三   星期四  星期五   星期六  星期日");
//
//        // 打印1号前面的空格, %7s , ""  空7个, 它的任务就是打印出1号前空格
//        for (int i = 1; i < dayOfWeek; i++) {
//            System.out.printf("%7s", "");
//        }
//
//        // 打印日历日期
//        for (int i = 1; i <= lastDay; i++) {
//            String today = String.format("%7s", i);
//            System.out.print(today);
//
//            // 如果1号 星期几  除7余 0,那么说明1号就是星期日,直接换行
//            // 如果不是周日,就不换行,但是+1
//            if (dayOfWeek++ % 7 == 0) {
//
//                System.out.println();
//
//            }
//            ;
//        }

        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.DATE, 1);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        dayOfWeek = (dayOfWeek == 1)? 7 : (dayOfWeek - 1);

        int lastDay = calendar.getActualMaximum(Calendar.DATE);

        String yearAndMonth = String.format("%d年%d月", calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH) + 1);
        System.out.println(yearAndMonth);

        System.out.println("   星期一  星期二  星期三   星期四  星期五   星期六  星期日");

        // 打印,先打印1号前面的空格
        for (int i = 1; i < dayOfWeek; i++) {
            System.out.print(String.format("%7s", ""));
        }
        // 打印开始
        for (int i = 1; i <= lastDay; i++) {
            System.out.print(String.format("%7s", i));

            // 换行判断,判断是否周日
//            if ((dayOfWeek + i - 1) % 7 == 0) {
            if (dayOfWeek++ % 7 == 0) {
                System.out.println();
            }
        }
    }
}
