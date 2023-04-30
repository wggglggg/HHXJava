package com.addition.exception;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * ClassName: TestOptional
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/4/30 20:13
 * @Version 1.0
 */
public class TestOptional {

    @Test
    public void test1(){
        ArrayList<Apple> applesList = getAppleList();

        getRedAppleWithFor(applesList);
    }

    @Test
    public void test2(){
        ArrayList<Apple> applesList = getAppleList();
        getRedAppleWithStream(applesList);
    }

    @Test
    public void test3(){
        ArrayList<Apple> applesList = getAppleList();

        getRadAppleWithOptionalOne(applesList);
    }

    @Test
    public void test4(){
        ArrayList<Apple> applesList = getAppleList();

        getRedAppleWithOptionalThree(applesList);
    }

    // 获取默认的苹果清单
    private static ArrayList<Apple> getAppleList() {
        ArrayList<Apple> appleList = new ArrayList<Apple>();
        appleList.add(new Apple("红苹果", "RED", 150d, 10d));
        appleList.add(new Apple("大苹果", "green", 250d, 10d));
        appleList.add(new Apple("红苹果", "red", 300d, 10d));
        appleList.add(new Apple("大苹果", "yellow", 200d, 10d));
        appleList.add(new Apple("红苹果", "green", 100d, 10d));
        appleList.add(new Apple("大苹果", "Red", 250d, 10d));
        return appleList;
    }

    // 方式一
    // 通过简单的for循环挑出红苹果清单
    private static void getRedAppleWithFor(List<Apple> list){
        List<Apple> redAppleList =  new ArrayList<>();

        for (Apple apple : list) {      // 遍历现有的苹果清单
            if (apple.isRedApple()){     // 判断是否为红苹果
                redAppleList.add(apple); // 加入红苹果列表
            }
        }

        System.out.println("For循环 红苹果清单=" + redAppleList.toString());
    }

    //方式二
    // 通过流式处理挑出红苹果清单
    private static void getRedAppleWithStream(List<Apple> list) {
        // 挑出红苹果清单
        List<Apple> redAppleList = list.stream()        // 串行处理
                .filter(Apple::isRedApple)              // 过滤条件。专门挑选红苹果
                .collect(Collectors.toList());          // 返回一串清单

        System.out.println("Stream流处理 红苹果清单=" + redAppleList.toString());
    }

    // 方式三
    // 把清单的非空判断代码改写为Optional校验方式
    private static void getRadAppleWithOptionalOne(List<Apple> list){
        List<Apple> redAppleList = new ArrayList<>();

        for (Apple apple : list){
            if (Optional.ofNullable(apple)
                    .map(Apple::isRedApple)
                    .orElse(false)) {
                redAppleList.add(apple);
            }
        }

        System.out.println("Optional1判断 红苹果清单=" + redAppleList.toString());
    }

    // 方式四
    // 把清单的非空判断代码改写为Optional校验方式
    private static void getRedAppleWithOptionalThree(List<Apple> list){
        ArrayList<Apple> redAppleList = new ArrayList<>();

        Optional.ofNullable(list)           // 构造一个可空对象
                .ifPresent(apples -> {      // ifPresent指定了list非空时候的处理

                    redAppleList.addAll(apples.stream() // 从原始清单中筛选出红苹果清单
                            .filter(apple -> apple != null)     // 只挑选非空元素
                            .filter(Apple::isRedApple)          // 只挑选红苹果
                            .collect(Collectors.toList()));     // 返回结果清单
                });

        System.out.println("Optional3判断 红苹果清单=" + redAppleList.toString());
    }
}
