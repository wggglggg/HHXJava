package com.collect.handle;

import com.collect.generic.Apple;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * ClassName: TestCollections
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/4/21 20:33
 * @Version 1.0
 */
public class TestCollections {

    @Test
    public void test1(){
        testMaxAndMin();
    }


    // 获取默认的苹果清单
    private static ArrayList<Apple> getAppleList() {
        ArrayList<Apple> appleList = new ArrayList<>();
        appleList.add(new Apple("红苹果", "RED", 150d, 10d));
        appleList.add(new Apple("大苹果", "green", 250d, 10d));
        appleList.add(new Apple("红苹果", "red", 300d, 10d));
        appleList.add(new Apple("大苹果", "yellow", 200d, 10d));
        appleList.add(new Apple("红苹果", "green", 100d, 10d));
        appleList.add(new Apple("大苹果", "Red", 250d, 10d));
        return appleList;
    }

    // 演示如何获取最大值和最小值
    private static void testMaxAndMin(){
        ArrayList<Apple> appleList = getAppleList();
        // 匿名内部类方式获取容器的最大值
        Apple heavestApple = Collections.max(appleList, new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
//                return o1.getWeight() - o2.getWeight();       // 错误写法,因为不是Int
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });
        System.out.println("最重的苹果="+heavestApple.toString());

        // Lambda表达式获取容器的最大值。求最重的苹果
        Apple heavestApple2 = Collections.max(appleList, (o1, o2) -> o1.getWeight().compareTo(o2.getWeight()));
        System.out.println("最重的苹果="+heavestApple2.toString());

        // Lambda表达式获取容器的最小值。求最轻的苹果
        Apple appleMin = Collections.min(appleList, (o1, o2) -> o1.getWeight().compareTo(o2.getWeight()));
        System.out.println("最轻的苹果="+appleMin.toString());
    }
}
