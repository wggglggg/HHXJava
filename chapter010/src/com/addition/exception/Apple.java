package com.addition.exception;

/**
 * ClassName: Apple
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/4/30 20:12
 * @Version 1.0
 */
public class Apple {
    private String name; // 名称
    private String color; // 颜色
    private Double weight; // 重量
    private Double price; // 价格

    public Apple() {
    }

    public Apple(String name, String color, Double weight, Double price) {
        this.name = name;
        this.color = color;
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }

    public boolean isRedApple() {

//        return this.color.toLowerCase().equals("red"); // 不严谨的写法，会出现null point
        return (this.color == null) ? false : this.color.toLowerCase().equals("red");
    }
}
