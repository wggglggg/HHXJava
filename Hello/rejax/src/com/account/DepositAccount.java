package com.account;

/**
 * ClassName: DepositAccount
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/3/26 9:31
 * @Version 1.0
 */
public class DepositAccount extends Account{

    private int depositTerm;

    public DepositAccount (int depositTerm, String depositName) {
        super(depositName);
        this.depositTerm = depositTerm;
        this.setUnit("元");
    }

    public int getDepositTerm() {
        return depositTerm;
    }
    public void setDepositTerm( int depositTerm) {
        this.depositTerm = depositTerm;
    }

    public boolean takeOut(double amount) {
        if (super.getBalance() == amount) {
            return super.takeOut(amount);
        } else {
            return false;
        }
    }

    public String toString () {
        String desc = String.format("存款期限为: %s, %s", this.depositTerm, super.toString());

        return desc;
    }

}
