package com.account;

/**
 * ClassName: TestAccount
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/3/26 10:50
 * @Version 1.0
 */
public class TestAccount {
    public static void main(String[] args) {
        BankAccount b1 = new BankAccount();

        b1.saveCurrent(5000);
        b1.saveDeposit(6, 1000);
        System.out.println("第一次存款后: " + b1.toString());

        b1.takeCurrent(2000);
        b1.takeDeposit(6);
        b1.saveDeposit(12, 2000);
        System.out.println("每二次存款操作后: " + b1.toString());
    }
}
