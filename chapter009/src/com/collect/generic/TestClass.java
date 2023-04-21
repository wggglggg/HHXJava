package com.collect.generic;

import java.util.Arrays;
import java.util.List;

/**
 * ClassName: TestClass
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/4/14 16:37
 * @Version 1.0
 */
public class TestClass {
    public static void main(String[] args) {
        List<Double> doubleList = Arrays.asList(1.1, 2D, 3.1415, 1.11111);

        SimpleList<Double> simpleList = new SimpleList<>(doubleList);

        System.out.println(simpleList.getMaxLengthItem());
        System.out.println(simpleList.getMinLengthItem());
        System.out.println(simpleList.getMinLengthItem().toString().length());
    }
}
