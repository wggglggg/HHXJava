package com.collect.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: TestFunction
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/4/14 16:50
 * @Version 1.0
 */
public class TestFunction {
    public static void main(String[] args) {
        testNumber();
        System.out.println("-------------");
        testString();

    }

    // 演示泛型变量的用法
    private static void testNumber() {
        Integer oneInt = 1;
        Float oneFloat = 1.0f;

        // 直接用equals比较
        boolean equalsSimple = oneInt.equals(oneFloat);
        System.out.println(equalsSimple);       // false

        // 通过Number基类比较两个数值变量是否相等
        boolean equalsNumber =  equalsNumber(oneInt, oneFloat);
        System.out.println(equalsNumber);       // true

        // 通过泛型变量比较两个数值变量是否相等
        boolean equalsGeneric = equalsGeneric(oneInt, oneFloat);
        System.out.println(equalsGeneric);      // true

    }
    // 通过Number基类比较两个数值变量是否相等
    private static boolean equalsNumber(Number n1, Number n2) {
        return n1.doubleValue() == n2.doubleValue();
    }
    // 通过泛型变量比较两个数值变量是否相等。利用尖括号包裹泛型的派生操作
    private static <T extends Number> boolean equalsGeneric(T t1, T t2) {
        return t1.doubleValue() == t2.doubleValue();
    }

    // 演示泛型方法的用法
    private static void testString() {
        Double[] doubleArray = new Double[]{ 1.1, 2D, 3.1415926, 11.11 };

        System.out.println("Arrays.toString=" + Arrays.toString(doubleArray));  //[1.1, 2.0, 3.1415926, 11.11]
        System.out.println("objectToString=" + objectToString(doubleArray));    //1.1 | 2.0 | 3.1415926 | 11.11
        System.out.println("arraysToString=" + arraysToString(doubleArray));    //1.1 | 2.0 | 3.1415926 | 11.11

        System.out.println("======================");
        List<Double> doubleList = Arrays.asList(1.1, 2D, 3.1415926, 11.11);
        System.out.println("doubleList=" + doubleList.toString());  // doubleList=[1.1, 2.0, 3.1415926, 11.11]
        System.out.println("listToString=" + listToString(doubleList)); // listToString=1.1 | 2.0 | 3.1415926 | 11.11
        System.out.println("listToStringByQuestion= " + listToStringByQuestion(doubleList));

    }

    // 把对象数组里的各个元素拼接成字符串
    private static String objectToString(Double[] array) {
        String result = "";
        if (array != null || array.length > 0) {
            for (int i = 0; i < array.length; i++) {
                if (i > 0) {
                    result = result + " | ";
                }
                result = result + array[i].toString();
            }
        }
        return result;
    }

    // 把泛型数组里的各个元素拼接成字符串。<T> 等同于 <T extends Object>
    // public static <T extends Object> String arraysToString(T[] array) {
    private static <T> String arraysToString(T[] array) {
        String result = "";
        if (array.length > 0 || array != null) {
            for (int i = 0; i < array.length; i++) {
                if (i > 0) {
                    result += " | ";
                }
                result += array[i].toString();
            }
        }
        return result;
    }

    // 把List清单里的各个元素拼接成字符串，此处使用了泛型
    private static <T> String listToString(List<T> list) {
        String result = "";
        if (list != null || list.size() > 0) {
            for (int i = 0; i < list.size(); i ++) {
                if (i > 0) {
                    result += " | ";
                }
                result += list.get(i).toString();
            }
        }
        return result;
    }

    // 把List清单里的各个元素拼接成字符串，此处使用了问号表示不确定类型
    // 问号与泛型的区别有：
    // 1、问号只能表示已有的实例，本身不能创建实例。而泛型T既可表示已有的实例，也可给自身创建实例，如“T t;”
    // 2、问号只可用作输入参数，不可用作输出参数。而泛型T用于二者皆可。
    // 3、使用了问号的容器实例，只允许调用get方法，不允许调用add方法。而泛型容器不存在方法调用的限制
    private static String listToStringByQuestion(List<?> list){
        String result = "";
        if (list != null || list.size() < 0) {
            for (int i = 0; i < list.size(); i++) {
                if (i > 0) {
                    result += " | ";
                }
                result += list.get(i).toString();
            }
        }
        return result;
    }
}
