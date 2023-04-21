package com.collect.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * ClassName: TestInterface
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/4/14 19:45
 * @Version 1.0
 */
public class TestInterface {
    public static void main(String[] args) {

        testPredicated();
        testConsumer();
        testPredicateAndConsumer();
        tsetFunction();

    }

    // 获取默认的苹果清单
    private static List<Apple> getAppleList() {
        List<Apple> appleList = Arrays.asList(
                new Apple("红苹果", "RED", 150d, 10d),
                new Apple("大苹果", "green", 250d, 10d),
                new Apple("红苹果", "red", 300d, 10d),
                new Apple("大苹果", "yellow", 200d, 10d),
                new Apple("红苹果", "green", 100d, 10d),
                new Apple("大苹果", "Red", 250d, 10d)
        );

        return appleList;
    }

    private static void testPredicated() {
        List<Apple> appleList = getAppleList();
        List<Apple> redAppleList;

        redAppleList = filterByPredicate(appleList, new Predicate<Apple>() {
            @Override
            public boolean test(Apple t) {
                return t.isRedApple();
            }
        });
        System.out.println("红苹果清单：" + redAppleList);
    }

    // 测试系统自带的消费接口Consumer
    private static void testConsumer() {
        List<Apple> appleList = getAppleList();
        modifyByConsumer(appleList, new Consumer<Apple>() {
            @Override
            public void accept(Apple t) {

                t.setName(t.getName() + "好吃");
            }
        });
        System.out.println("好吃的苹果清单" + appleList);
    }

    private static <T> void testPredicateAndConsumer() {
        List<Apple> appleList = getAppleList();

        selectAndModify(appleList, t -> t.isRedApple(), t -> t.setPrice(t.getPrice() * 1.5));

        selectAndModify(appleList, t -> t.getWeight() >= 250, t -> t.setPrice(t.getPrice()* 1.5));
        System.out.println("涨价后的苹果清单：" + appleList);
    }

    private static <T> void tsetFunction() {
        List<Apple> appleList = getAppleList();
        List<Apple> appleRecently;

        appleRecently = recycleByFunction(appleList, new Function<Apple, Apple>() {
            @Override
            public Apple apply(Apple t) {
                Apple apple = new Apple(t.getName(), t.getColor(), t.getWeight(), t.getPrice());
                if (t.isRedApple()) {
                    apple.setPrice(apple.getPrice() * 1.5);
                }
                if (t.getWeight() >= 250) {
                    apple.setPrice(apple.getPrice() * 1.5);
                }
                return apple;
            }
        });
        System.out.println("涨价后的新苹果清单：" + appleRecently);

        List<String> applesColor;
//        applesColor = recycleByFunction(appleList, t -> t.getName() + "(" + t.getColor() + ")");
//        System.out.println("带颜色的苹果名称清单：" + applesColor);
        applesColor = recycleByFunction(appleList, new Function<Apple, String>() {
            @Override
            public String apply(Apple t) {
                return t.getName() + t.getColor();
            }
        });
        System.out.println("带颜色的苹果名称清单：" + applesColor);
    }
    private static <T> List<T> filterByPredicate(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<T>();

        for (T t : list) {
            if (p.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

    private static <T> void modifyByConsumer(List<T> list, Consumer<T> c) {
        for (T t : list) {
            c.accept(t);
        }
    }

    private static <T> void selectAndModify(List<T> list, Predicate<T> p, Consumer<T> c) {
        for (T t : list) {
            if (p.test(t)) {
                c.accept(t);
            }
        }
    }

    private static <T, R> List<R> recycleByFunction(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<R>();
        for (T t : list) {
            R r = f.apply(t);
            result.add(r);
        }
        return result;
    }
}
