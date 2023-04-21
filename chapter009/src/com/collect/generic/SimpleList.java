package com.collect.generic;

import java.util.List;

/**
 * ClassName: SimpleList
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/4/14 16:00
 * @Version 1.0
 */

//定义简单的泛型清单。
public class SimpleList<T> {
    private List<T> list;



    public SimpleList(List<T> list){
        this.list = list;
    }

    public List<T> getList() {
        return list;
    }

    // 获取长度最大的清单元素。注意这里的返回数据为泛型T
    public T getMaxLengthItem() {
        if (list == null || list.size() <= 0) {
            return null;
        }
        T t = list.get(0);      // 利用T声明了一个泛型变量t
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).toString().length() > t.toString().length()) {
                // 把较长的元素保存到变量t
                t = list.get(i);
            }
        }
        return t;
    }

    // 获取长度最小的清单元素。注意这里的返回数据为泛型T

    public T getMinLengthItem(){
        if (list == null || list.size() <= 0) {
            return null;
        }

        T t = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).toString().length() < t.toString().length()) {
                t = list.get(i);
            }
        }
        return t;
    }

}
