package com.collect.handle;

import org.junit.Test;

import java.util.*;

/**
 * ClassName: TestConvert
 * Description:
 *      List -> array            array -> List
 * @Author wggglggg
 * @Create 2023/4/21 19:41
 * @Version 1.0
 */

// 演示容器与数组的互相转换
public class TestConvert {

    @Test
    public void test1(){
        setToArray();
    }

    @Test
    public void test2(){
        listToArray();
    }

    @Test
    public void test3(){
        arrayToList();
    }

    @Test
    public void test4(){
        createFixedList();
    }

    @Test
    public void test5(){
        createFixedSet();
    }

    @Test
    public void test6(){
        createFixedMap();
    }

    // 将集合对象转换成数组对象
    private static void setToArray() {
        Set<String> fruitSet = new HashSet<>();

        fruitSet.add("苹果");
        fruitSet.add("香蕉");
        fruitSet.add("西瓜");

        String[] fruitArray = new String[fruitSet.size()];

        fruitArray = fruitSet.toArray(fruitArray);
        for (String fruit: fruitArray) {
            System.out.println("集合转换，来自数组的水果=" + fruit);
        }
    }

    // 将清单对象转换为数组类型
    private static void listToArray() {
        List<String> list = new ArrayList<>();

        list.add("苹果");
        list.add("香蕉");
        list.add("西瓜");

        String[] fruitArray = new String[list.size()];

        fruitArray = list.toArray(fruitArray);

        for (String fruit: fruitArray) {
            System.out.println("集合转换，来自数组的水果=" + fruit);
        }
    }

    // 将数组变量转换为清单类型
    private static void arrayToList() {
        // 方式一：先初始化数组变量，再调用Arrays工具的asList方法将数组变量转换为清单类型, 不能做添加和删除操作
        String[] fruitArray = new String[]{"苹果", "香蕉", "西瓜"};
        List<String> fruitList = Arrays.asList(fruitArray);     // 将数组变量转换为清单类型

        // 方式二：直接在asList方法的输入参数中填写数组元素的列表, 不能做添加和删除操作
        List<String> fruitList2 = Arrays.asList("苹果", "香蕉", "西瓜");
        // Arrays.asList得到的清单不能做添加和删除操作，否则会报错UnsupportedOperationException
        // 因为asList方法返回的对象类型是Arrays里面的嵌套类ArrayList，并非java.util.ArrayList
//        fruitList.add("梨"); // Arrays.ArrayList这个嵌套类没有实现add方法
        //fruitList.remove(0); // Arrays.ArrayList这个嵌套类没有实现remove方法

        // 方式三: 先建一个List,然后用add 的方式来添加,这样的List是可以再添加与修改的.
        String[] fruitArray3 = new String[]{"苹果", "香蕉", "西瓜"};
        List<String> fruitList3 = new ArrayList<>();
        for (String fruit: fruitArray3) {
            fruitList3.add(fruit);

        }
        System.out.println(fruitList3);
    }

    // 创建固定不变的清单
    private static void createFixedList() {
        // 通过List.of创建的固定清单，既不能添加和删除，也不能修改
        List<String> fruitList = List.of("苹果", "香蕉", "西瓜");
//        fruitList.add("梨"); // 固定清单调用add方法在运行时会报错 java.lang.UnsupportedOperationException
        //fruitList.set(0, "梨"); // 固定清单调用set方法在运行时也会报错
        //fruitList.remove(0); // 固定清单调用remove方法在运行时也会报错
        System.out.println(fruitList);
    }

    // 创建固定不变的集合
    private static void createFixedSet() {
        // 通过Set.of创建的固定集合，不能添加和删除
        Set<String> fruitSet = Set.of("苹果", "香蕉", "西瓜");
        //fruitSet.add("梨"); // 固定集合调用add方法在运行时会报错java.lang.UnsupportedOperationException
        //fruitSet.remove("苹果"); // 固定集合调用remove方法在运行时也会报错

        System.out.println(fruitSet);
    }

    // 创建固定不变的映射
    private static void createFixedMap() {
        // 通过Map.of创建的固定映射，不能增删改
        Map<String, String> fruitMap = Map.of("苹果", "apple", "香蕉", "banana", "西瓜", "watermelon");
        //fruitMap.put("梨", "pear"); // 固定映射调用put方法在运行时会报错
        //fruitMap.remove("苹果"); // 固定映射调用remove方法在运行时也会报错

        for (Map.Entry<String,String> fruit : fruitMap.entrySet()) {
            System.out.println(fruit.getKey() + " : " + fruit.getValue());
        }
    }
}
