package com.idregex;

/**
 * ClassName: IdRejax
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/3/23 9:43
 * @Version 1.0
 */
public class IdRegex {

    /**
     * 利用正则校验身份证ID有效性
     * @param icno 身份证ID
     * @return  返回校验后的boolean值
     */
    public static boolean isICNO(String icno) {
        String regex = "(\\d{6})((19|20)\\d{2})(0[1-9]|1[0-2])" +
                "(0[1-9]|[12]\\d|3[01])(\\d{3}([0-9xX]))";
        return icno.matches(regex);
    }
}
