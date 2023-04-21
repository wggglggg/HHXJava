package com.account;

/**
 * ClassName: CashAccount
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/3/26 9:31
 * @Version 1.0
 */
public class CashAccount extends Account{
    private int cashType;

    public final static int RMB = 0;        // 人民币
    public final static int SGD = 1;        // 新加坡元
    public final static int USD = 2;        // 美元
    public final static int EUR = 3;        // 欧元
    public final static int GBP = 4;        // 英镑
    public final static int JPY = 5;        // 日元
    private final String[] typeName = {"人民币", "新加坡元", "美元", "欧元", "英镑", "日元"};

    public CashAccount (int cashType, String cashName) {
        super(cashName);
        this.cashType = cashType;
        this.setUnit(cashType == USD ? "刀" : "元");
    }

    public int getCashType() {
        return cashType;
    }
    public void setCashType(int cashType) {
        this.cashType = cashType;
    }

    public String toString() {
        String desc = String.format("金额类型为: %s , %s", typeName[this.cashType],
                super.toString());

        return desc;
    }


}
