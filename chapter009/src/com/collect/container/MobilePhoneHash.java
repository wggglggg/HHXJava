package com.collect.container;

/**
 * ClassName: MobilePhoneHash
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/4/6 21:08
 * @Version 1.0
 */
public class MobilePhoneHash {
    private String brand;
    private Integer price;

    public MobilePhoneHash() {

    }
    public MobilePhoneHash(String brand, Integer price) {
        this.brand = brand;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public Integer getPrice() {
        return price;
    }

    @Override
    public int hashCode() {
        return brand.hashCode() + price.hashCode();
    }

    // 同一个存储位置上可能有多个对象（哈希值恰好相等），
    // 此时系统自动调用equals方法判断是否存在相同的对象。
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof MobilePhoneHash)) {
            return false;
        }

        // 如果 obj 属于 MobilePhoneHash子类，那么将obj强转
        MobilePhoneHash other = (MobilePhoneHash) obj;
        // 再次验证当前实例对象的brand price与other.bran price是否相同
        boolean equals = this.getBrand().equals(other.getBrand()) &&
                this.getPrice().equals(other.getPrice());
        return equals;
    }
}
