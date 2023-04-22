package com.collect.handle;

import com.collect.generic.Apple;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * ClassName: TestStream
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/4/21 21:14
 * @Version 1.0
 */

//演示如何使用Stream流对容器进行更高级的处理操作
public class TestStream {
    @Test
    public void test1(){
        System.out.println("原始的苹果清单=" + getAppleList().toString());
        // stream、parallelStream这两个是开始指令，
        // collect、forEach、count这三个是结束指令，
        // 除了开始指令和结束指令以外，其它都是中间指令。

        // 挑出红苹果清单  串行方式 与 并行方式
        // 按照名称统计红苹果的分组个数
        Long redCount = getAppleList().stream()                 // 串行处理
                .filter(Apple::isRedApple)                      // 过滤条件。专门挑选红苹果
                .count();                                       // 统计记录个数

        // 按照名称统计红苹果的分组个数
        Long redCount2 = getAppleList().parallelStream()        // 并行方式
                        .filter(Apple::isRedApple)
                                .count();

        // 挑出红苹果清单
        List<Apple> redAppleList = getAppleList().stream()
                        .filter(Apple::isRedApple)
                                .sorted(Comparator.comparing(Apple::getWeight))
                .limit(3)       // 只取前几条数据
                .distinct()             // 去掉重复记录
                .collect(Collectors.toList());  // 返回一串清单

        System.out.println("红苹果总数=" + redCount);            //红苹果总数=3
        System.out.println("红苹果总数=" + redCount2);            //红苹果总数=3
        System.out.println(redAppleList);
    }

    @Test
    public void test2(){
        ArrayList<Apple> appleList = getAppleList();
        // 挑出去重后的苹果名称清单
        List<String> allNameList = appleList.stream()
                .map(Apple::getName)            // 只看苹果名称那一列清单
                .distinct()                     // 去掉苹果名称重复记录
                .collect(Collectors.toList());

        System.out.println(allNameList);
    }

    @Test
    public void test3(){
        List<Apple> appleList = getAppleList();
        // 按照名称统计红苹果的分组个数
        Map<String, Long> redStatisticCount = appleList.stream()
                .filter(Apple::isRedApple)
                .collect(Collectors.groupingBy(Apple::getName, Collectors.counting()));

        System.out.println(redStatisticCount);
    }

    // 按照名称统计红苹果的分组总价
    @Test
    public void test4(){
        List<Apple> appleList = getAppleList();

        Map<String, Double> redPriceSum = appleList.stream()
                .filter(Apple::isRedApple)  // 过滤条件。专门挑选红苹果
                // 返回分组并对某字段求和
                .collect(Collectors.groupingBy(Apple::getName, Collectors.summingDouble(Apple::getPrice)));

        System.out.println(redPriceSum);
    }

    // 对每个红苹果依次处理
    @Test
    public void test5(){
        List<Apple> appleList = getAppleList();

        appleList.stream()
                .filter(Apple::isRedApple)      // 过滤条件。专门挑选红苹果
                .forEach(t -> System.out.println(t.getColor())); // 逐条操作
        ;
    }

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
}
