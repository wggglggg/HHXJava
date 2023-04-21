package com.collect.generic;

/**
 * ClassName: Apple
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/4/14 15:45
 * @Version 1.0
 */
public class Apple {
    private String name;    // 名称
    private String color;   // 颜色
    private Double weight;  // 重量
    private Double price;   // 价格

    public Apple(String name, String color, Double weight, Double price){
        this.name = name;
        this.color = color;
        this.price = price;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return this.color.toLowerCase().equals("red");
    }
}
