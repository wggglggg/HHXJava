package com.collect.container;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * ClassName: TestSet
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/4/6 20:28
 * @Version 1.0
 */
public class TestSet {

    @Test
    public void test1(){
        // 创建一个 字符串哈希集合
        HashSet<String> set = new HashSet<String>();

        set.add("hello");
        set.add("world");
        set.add("how");
        set.add("are");
        set.add("you");
        set.add("guys");

        // 方式一   for循环从集合取出 , 无序性
        for (String hash_item : set) {
            System.out.println("Hash Item: " + hash_item);
        }
    }

    @Test
    public void test2(){
        HashSet<String> set = new HashSet<String>();

        set.add("hello");
        set.add("world");
        set.add("how");
        set.add("are");
        set.add("you");
        set.add("guys");

        // 方式二 迭代器遍历
        Iterator<String> iterator = set.iterator(); // 生成一个迭代器

        while (iterator.hasNext()) {    // 用hasNext()判断是否还有下一个元素
            String hash_iterator = iterator.next();     // 用next(）取出
            System.out.println("Hash iterator: " + hash_iterator);
        }
    }

    @Test
    public void test3(){
        HashSet<String> set = new HashSet<String>();
        set.add("hello");
        set.add("world");
        set.add("how");
        set.add("are");
        set.add("you");
        set.add("guys");

        // 方式三 用forEach循环取出

        set.forEach(hash_each -> System.out.println("Hash Each: " + hash_each));
    }

    @Test
    public void test4(){
        // 使用二叉集合 TreeSet<>

        TreeSet<String> set = new TreeSet<String>();
        set.add("hello");
        set.add("world");
        set.add("how");
        set.add("are");
        set.add("you");
        set.add("guys");

        for (String tree_item : set) {
            System.out.println(tree_item);
        }

    }


    // 演示哈希集合HashSet如何存取程序员自定义的数据类型
    @Test
    public void test5(){  // HashSet是无序集合
        HashSet<MobilePhoneHash> set = new HashSet<MobilePhoneHash>();
        set.add(new MobilePhoneHash("Haier", 1800));
        set.add(new MobilePhoneHash("Hisenses", 1500));
        set.add(new MobilePhoneHash("TCL", 1700));
        set.add(new MobilePhoneHash("Midea", 1600));

        // 简化的for循环同样适用于数组和容器
        for (MobilePhoneHash hash_item : set) {
            System.out.println("hash_item brand=" + hash_item.getBrand()
                    + ", price=" + hash_item.getPrice());
        }
    }

    @Test
    public void test6(){
        TreeSet<MobilePhoneTree> set = new TreeSet<MobilePhoneTree>();
        set.add(new MobilePhoneTree("Haier", 1800));
        set.add(new MobilePhoneTree("Hisenses", 1500));
        set.add(new MobilePhoneTree("TCL", 1700));
        set.add(new MobilePhoneTree("Midea", 1600));

        for (MobilePhoneTree tree_item : set) {     // 用compareTo()使得价格排序
            System.out.println("tree_item brand=" + tree_item.getBrand()
                    + ", price=" + tree_item.getPrice());
        }


    }
}
