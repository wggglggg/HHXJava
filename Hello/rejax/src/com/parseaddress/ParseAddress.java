package com.parseaddress;

/**
 * ClassName: ParseAddress
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/3/23 14:01
 * @Version 1.0
 */
public class ParseAddress {




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
            parseReceiverInfo(infoArray[i]);
        }
    }


    /**
     * “张三  15961238696 北京市海淀区双清路30，" 从字符串中校验姓名 电话 地址 分配给name phone address
     * @param info 传一个字符串“张三  15961238696 北京市海淀区双清路30，"
     */
    public static void parseReceiverInfo(String info) {
        String name = "", phone = "", address = "";
        // 正则规则， 看到 空格 与 逗号 就切一刀，拿到字符串数组
        String[] splits = info.split(" |,");

        // 从数组中一个一个取出来检验
        for (String str : splits) {
            // 校验出数字就是电话
            if (isPhone(str)) {
                phone = str;
                // 不是数字并且name还是空时，就先存入到name，下面if再调整
            } else if (name.equals("")) {
                name = str;
                // 如果当前字符串字数比上面name的字长度长，就说明当前拿到的是地址
            } else if (str.length() > name.length()) {
                address = str;
            } else {    // 最后一种情况就是上面name先拿到的是地址，当前拿到的是姓名，所以交换就好。
                address = name;
                name = str;
            }
        }
        // printf(....) 打印格式化，%s 填充字符串，%n 换行 由于使用的printf没有换行，所以搭配 %n。
        System.out.printf("姓名: %s, 电话：%s, 收件地址：%s%n", name, phone, address );

        // 进入提取address地址，将地址以xxx省xxxx市这些关键字来分离开
        // 首先先造一个字符串数组，[0]位置一个空内容,从address里面提取出来会放这里,[1]位置是完整的地址字符串,
        String[] areaArray = new String[] {"", address};

        // 提出出xxx省放areaArray[0],后面一段放[1]
        areaArray = getAreaName(areaArray[1], new String[]{"省", "自治区"});
        String provice = areaArray[0];

        //  拿到xx自治州,xx盟, xx市
        areaArray = getAreaName(areaArray[1], new String[] {"市", "自治州", "盟", "地区"});
        String city = areaArray[0];

        //  拿到xx县,xx区, xx族
        areaArray = getAreaName(areaArray[1], new String[] {"县", "区", "市", "族"});
        String district = areaArray[0];

        //  最后是余下的地址
        String detail = areaArray[1];

        //  有一些直辖市没有省与自治区关键字,结果会是0
        if (provice.length() < city.length()) {
            //  直辖市名称 赋值给 省
            provice = city;
        }
        System.out.printf("省: %s, 地市: %s, 区县: %s, 详细地址: %s%n",
                provice, city, district, detail);
        System.out.println("-------------------------------------------------------");
    }

    public static String[] getAreaName(String address, String[] subfixArea) {
        // 首先先造一个字符串数组，[0]位置一个空内容,从address里面提取出来会放这里,[1]位置是完整的地址字符串
        String[] areaArray = new String[]{"", address};
        int pos = 0;    // 存放xxx省 or xxxx市,  省 or 市 这个字的index索引

        // 开始从地址中检索pos关键字
        for (String subfix : subfixArea) {
            // 定位 省 自治区 市 区等等这些关键字的index索引位置,首位为0
            // 例如安徽省, pos会拿到值为 2
            pos = address.indexOf(subfix);
            // 只要值 大于0,就表示 有拿到值 ,因为有可能 要检索的是"省",但是字符串是 "xxx自治区",那结果就是0
            if (pos > 0) {
                // 然后用substring(A,B)将地址按从A到B截取出来放入areaArray[0]中,剩余放到[1]中
                areaArray[0] = address.substring(0, pos + subfix.length());
                areaArray[1] = address.substring(pos +subfix.length());
                break;
            }
        }
        // 将数组返回去 例如   {"安徽省", "芜湖市经济技术开发区鞍山路8号"}
        return areaArray;

    }
    /**
     * 正则校验字符串，只要是数字就当作电话 返回true
     * @param phone 字符串
     * @return 数字就返回true
     */
    public static boolean isPhone (String phone) {
        // 只要是数字，就校验为true  电话
        String regex = "\\d+";

        return phone.matches(regex);
    }
}
