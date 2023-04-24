package com.collect.algorithm;

import org.junit.Test;

import java.sql.SQLOutput;
import java.util.Arrays;

/**
 * ClassName: TestFind
 * Description:
 *  演示如何使用二分查找法在某个数组里面找到目标值
 * @Author wggglggg
 * @Create 2023/4/24 21:26
 * @Version 1.0
 */
public class TestFind {

    @Test
    public void test1(){
        testFindInt();
    }


    public static void  testFindInt() {
        Integer item = 0;                       // 随机数变量
        Integer[] num = new Integer[20];        // 随机数构成的数组

        // 以下生成一个包含随机整数的数组
        loop:for (int i = 0; i < num.length; i ++) {
            item = (int) (Math.random() *  (100 + 1));  // 生成一个小于100的随机整数
            for (int j = 0; j < i; j++) {
                // 数组中已存在该整数，则重做本次循环，以便重新生成随机数
                if (num[j] == item) {
                    i--;                        // 本次循环做了无用功，取消当前的计数
                    continue loop;                      // 直接继续上一级循环
                }
            }
            num[i] = item;
        }

        Arrays.sort(num);                       // 对整数数组排序（默认升序排列）
        System.out.println();
        for (int seq=0; seq<num.length; seq++) { // 打印数组中的所有数字
            System.out.println("序号="+seq+", 数字="+num[seq]);
        }

        Integer aim = item;
        System.out.println("准备查找的目标数字="+aim);
        int position = ArrayFind.binarySearch(num, aim);
        System.out.println("查找到的位置序号="+position);
    }

    @Test
    public void test2(){
        findStr();
    }
    public static void findStr(){
        String item = "";
        String[] arr = new String[20];

        loop:for (int i = 0; i < arr.length; i++) {
            int random = (int) (Math.random() * (26 + 1));
            item = (char)(random + 'A') + "";
            for (int j = 0; j < i; j++) {
                if (arr[j].equals(item)){
                    i--;
                    continue loop;
                }
            }
            arr[i] = item;
        }

        Arrays.sort(arr);               // 对字符串数组排序（默认升序排列）
        System.out.println();
        for (int seq=0; seq<arr.length; seq++) { // 打印数组中的所有数字
            System.out.println("序号="+seq+", 数字="+arr[seq]);
        }

        String aim = item;
        System.out.println("准备查找的目标字符串="+item);
        int position = ArrayFind.binarySearch(arr, aim);
        System.out.println("查找到的位置序号="+position);
    }
}
