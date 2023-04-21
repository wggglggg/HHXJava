package com.account;

/**
 * ClassName: Account
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/3/26 9:31
 * @Version 1.0
 */
public class Account {

    private String name;
    private double balance;
    private String unit;        // 余额单位

    // 生成账户的构造方法, 默认设置余额为0
    public Account (String name) {
        this.name = name;
        this.balance = 0;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getUnit(){
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }

    public boolean saveIn(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        } else {
            return false;
        }
    }

    public boolean takeOut(double amount) {
        if (balance >= amount && amount > 0) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        String desc = String.format("名称为： %s, 余额为: %.2f, 单位是: %s",
                this.name, this.balance, this.unit );

        return desc;
    }
}
