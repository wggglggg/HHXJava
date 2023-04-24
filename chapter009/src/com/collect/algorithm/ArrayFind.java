package com.collect.algorithm;

/**
 * ClassName: ArrayFind
 * Description:
 *      //二分查找算法的工具类。使用了泛型方法
 * @Author wggglggg
 * @Create 2023/4/24 20:40
 * @Version 1.0
 */

//二分查找算法的工具类。使用了泛型方法
public class ArrayFind {
    private static int count;
    public static <T extends Comparable<T>> int binarySearch(T[] array,  T aim){
        count = 0;      // 开始查找前先把查找次数清零
        return binarySearch(array, 0, array.length - 1, aim);
    }

    public static <T extends Comparable<T>> int binarySearch(T[] array, int head, int tail, T aim){
        count++;
        if (head >= tail && aim.compareTo(array[head]) != 0) {   // 起点和终点都重合了还没找到
            return -1; // 返回-1表示没找到
        }

        int middle = (head + tail) / 2;// 计算中间的位置
        if (aim.compareTo(array[middle]) < 0) {
            System.out.println("<0");
            tail = middle - 1;
        } else if (aim.compareTo(array[middle]) > 0) {
            System.out.println(">0");
            head = middle + 1;
        } else {        // 找到目标值，返回目标值所处的位置
            System.out.println("查找次数="+count);
            return middle;
        }
        return binarySearch(array, head, tail, aim);    // 目标值在前半段或后半段，继续查找
    }
}
