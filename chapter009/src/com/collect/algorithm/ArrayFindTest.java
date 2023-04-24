package com.collect.algorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * ClassName: ArrayFindTest
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/4/24 21:05
 * @Version 1.0
 */
public class ArrayFindTest {
    @Test
    public void test1(){
        String[] arr = {"生命周期", "APP", "页面", "活动", "方法如下", "启停活动页面", "结束"};
        Arrays.sort(arr);
        String aim = "页面";
        System.out.println(Arrays.toString(arr));
        ArrayFind.binarySearch(arr, aim);
//        Integer[] arrInt = {1,3,4,5,65,2,6,32};
//        Integer aim2 = 5;
//        System.out.println(ArrayFind.binarySearch(arrInt, aim2));
    }
}
