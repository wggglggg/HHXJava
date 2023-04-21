package com.idregex;

/**
 * ClassName: IdRegexTest
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/3/23 9:55
 * @Version 1.0
 */
public class IdRegexTest {

    public static void main(String[] args) {
        IdRegex idRegex = new IdRegex();

        String ID = "42052119821002569X";
        boolean result = IdRegex.isICNO(ID);

        System.out.println(result);
    }
}
