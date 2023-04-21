package com.account;

import java.util.Arrays;

/**
 * ClassName: BankAccount
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/3/26 10:15
 * @Version 1.0
 */
public class BankAccount {

    CashAccount current;
    DepositAccount[] deposits;

    public BankAccount () {
        current = new CashAccount(CashAccount.RMB, "活期存款");
        deposits = new DepositAccount[0];
    }

    public boolean saveCurrent (double amount) {
        return current.saveIn(amount);
    }

    public boolean takeCurrent (double amount) {
        return current.takeOut(amount);
    }

    public boolean saveDeposit ( int depositTerm, double amount) {
        int pos = getDepositPos(depositTerm);
        boolean result = false;
        if (pos >= 0) {
            DepositAccount depositAccount = deposits[pos];

            result = depositAccount.saveIn(amount);
        } else {
            DepositAccount depositAccount = new DepositAccount(depositTerm, depositTerm + "个月定期存款");
            result = depositAccount.saveIn(amount);
            deposits = Arrays.copyOf(deposits, deposits.length + 1);
            deposits[deposits.length - 1] = depositAccount;
        }
        return result;
    }

    public boolean takeDeposit(int depositTerm) {
        boolean result = false;
        int pos = getDepositPos(depositTerm);
        if (pos >= 0) {
            DepositAccount depositAccount = deposits[pos];
            result = depositAccount.takeOut(depositAccount.getBalance());
            deposits[pos] = depositAccount;
        }
        return result;
    }

    public int getDepositPos(int depositTerm) {
        int pos = -1;
        for (int i = 0; i < deposits.length; i++) {
            if (deposits[i].getDepositTerm() == depositTerm) {
                pos = i;
                break;
            }
        }
        return pos;
    }

    public String toString(){
        for (int i = 0; i < deposits.length; i++) {
            System.out.println("deposits" + i + ": " + deposits[i]);
        }
        String desc = "银行账户信息如下: \n";
        desc = String.format("%s\t%s%n", desc, current.toString());
        for (DepositAccount deposit : deposits) {
            desc = String.format("%s\t%s%n", desc, deposit.toString());
        }
        return desc;
    }
}
