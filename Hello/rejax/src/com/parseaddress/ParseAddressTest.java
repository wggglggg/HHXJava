package com.parseaddress;

/**
 * ClassName: ParseAddressTest
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/3/25 20:12
 * @Version 1.0
 */

public class ParseAddressTest {

    public static void main(String[] args) {
        /**
         * 一个存有快递用户信息的String数组
         */
        String[] infoArray = new String[] {
                "张三 15961238696 北京市海淀区双清路30",
                "62019944, 北京市海淀区花园北路46号, 西四",
                "6549815645 艾某某 江西省南昌市青山湖区罗家镇高新南大道鑫和园小区",
                "四川省成都市武侯区人民南路四段11号附15号2楼,赵六,430111651"
        };

        for (int i = 0; i < infoArray.length; i++) {
            String info = infoArray[i];
            parseReceiverInfo(info);
        }
    }


    /**
     * “张三  15961238696 北京市海淀区双清路30，" 从字符串中校验姓名 电话 地址 分配给name phone address
     * @param info 传一个字符串“张三  15961238696 北京市海淀区双清路30，"
     */
    public static void parseReceiverInfo(String info) {
        String [] strs = info.split(" |,");
        String phone = "", name = "", address = "";

        for (String str : strs) {
            if (isPhone(str)) {
                phone = str;
            } else if (name.equals("")) {
                name = str;
            } else if (str.length() > name.length()) {
                address = str;
            } else {
                address = name;
                name = str;
            }
        }

        System.out.printf("姓名: %s, 电话: %s, 收件地址: %s%n", name, phone, address);

        String[] areaArray = new String[] {"", address};

        areaArray = getAreaName(areaArray[1], new String[] {"省", "自治区"});
        String province = areaArray[0];

        areaArray = getAreaName(areaArray[1], new String[]{"自治州", "地区", "盟", "市"} );
        String city = areaArray[0];

        areaArray = getAreaName(areaArray[1], new String[] {"县", "市", "区", "旗"});
        String district = areaArray[0];

        String detail = areaArray[1];

        if (province.length() == 0) {
            province = city;
        }



        System.out.printf("省: %s, 地市: %s, 区县: %s, 详细地址: %s%n", province, city, district, detail);

    }

    public static String[] getAreaName(String address, String[] subfixArea) {
        int pos = 0;
        String[] areaArray = new String[] {"", address};
        for (String subfix : subfixArea) {

            pos = address.indexOf(subfix);
            if (pos > 0) {
                areaArray[0] = address.substring(0, pos + subfix.length());
                areaArray[1] = address.substring(pos + subfix.length());
                break;
            }
        }
        return areaArray;
    }
    /**
     * 正则校验字符串，只要是数字就当作电话 返回true
     * @param phone 字符串
     * @return 数字就返回true
     */
    public static boolean isPhone (String phone) {
        String regex = "\\d+";
        return phone.matches(regex);
    }
}
