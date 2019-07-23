package com.dzd.utils;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DNAStringUtil {

    /**
     * 判断字符串中是否为中文
     * param str 需要验证的字符串
     * return
     */
    public static boolean isChinese(String str) {
        String regex = "[\u4E00-\u9FA5]+";
        if(str.matches(regex)){
            return true;
        }
        return false;
    }

    /**
     * 验证账号不只是字母和数字组成
     * param userNo 需要验证的用户账号
     * return
     */
    public static boolean checkUserNo(String userNo){
        char[] no = userNo.toCharArray();
        for(int i=0;i<no.length;++i){
            if(no[i]>= '0' && no[i] <= '9' ||
                    no[i] >= 'a' && no[i] <= 'z' ||
                    no[i] >= 'A' && no[i] <= 'Z'	) {
                continue;
            } else {
                return true;
            }
        }

        return false;
    }

    /**
     * 判断字符串中是否为数字(0~9)，不带- 例如：-1 return false
     * param str 需要验证的字符串
     * return
     */
    public static boolean isNumeric(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断字符串中是否为数字(0~9,-1~-9)，带- 例如：-1 return true
     * param str 需要验证的字符串
     * return
     */
    public static boolean isNumericContainMinus(String str){
        /*"[0-9]*"验证数字，
         * 改正则表达式实现校验负数,将正则表达式修改为“^-?[0-9]+”即可,
         * 修改为“-?[0-9]+.?[0-9]+”即可匹配所有数字。*/
        Pattern p = Pattern.compile("^-?[0-9]+");
        Matcher m = p.matcher(str);
        return m.matches();
    }

    /**
     * 判断字符串是否是大于等于0的正数 例如：-1 return false
     * param str 需要验证的字符串
     * return boolean 返类型
     */
    public static boolean isNumbericBigThanZero(String str){
        String regex="^([0-9]\\d*(\\.\\d*[0-9])?)$";
        if (str.matches(regex)) {
            return true;
        }
        return false;
    }

    /**
     * 判断字符串是否为自然数 例如：2.0 return false
     * param str 需要验证的字符串
     * return boolean 返回类型
     */
    public static boolean isNaturalNumber(String str){
        String regex="^\\d+$";
        if (str.matches(regex)) {
            return true;
        }
        return false;
    }
    /**
     * 判断字符串是否为空的方法
     * param str 需要验证的字符串
     * return
     */
    public static boolean isEmptyString(String str){
        return str == null || str.trim().length() == 0;
    }

    /**
     * 判断输入的字节数组是否为空
     * param bytes
     * return 空则返回true,非空则flase
     */
    public static boolean isEmptyByte(byte[] bytes){
        return !(null==bytes || 0==bytes.length);
    }

    /**
     * 验证手机号码
     * param mobiles 需要验证的手机号
     * return
     */
    public static boolean isMobileNO(String mobiles) {
        boolean flag = false;
        try{
            String check = "^(((13[0-9])|(14[0-9])|(15([0-9]))|(16[0-9])|(17[0-9])|(18[0-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(mobiles);
            flag = matcher.matches();
        }catch(Exception e){
            flag = false;
        }
        return flag;
    }

    /**
     * 验证邮箱
     * param email
     * return
     */
    public static boolean checkEmail(String email){
        boolean flag = false;
        try{
            String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(email);
            flag = matcher.matches();
        }catch(Exception e){
            flag = false;
        }
        return flag;
    }

    /**
     * 字符串右补空格
     * see 该方法默认采用空格(其ASCII码为32)来右补字符
     * see 若想自己指定所补字符,可以使用<code>rightPadForByte(String str, int size, int padStrByASCII)</code>方法
     */
    public static String rightPadForByte(String str, int size){
        return rightPadForByte(str, size, 32);
    }

    /**
     * 字符串右补字符
     * see 若str对应的byte[]长度不小于size,则按照size截取str对应的byte[],而非原样返回str
     * see 所以size参数很关键..事实上之所以这么处理,是由于支付处理系统接口文档规定了字段的最大长度
     * see 若对普通字符串进行右补字符,建议org.apache.commons.lang.StringUtils.rightPad(...)
     * param size          该参数指的不是字符串长度,而是字符串所对应的byte[]长度
     * param padStrByASCII 该值为所补字符的ASCII码,如32表示空格,48表示0,64表示@等
     */
    public static String rightPadForByte(String str, int size, int padStrByASCII){
        byte[] srcByte = str.getBytes();
        byte[] destByte = null;
        if(srcByte.length >= size){
            //由于size不大于原数组长度,故该方法此时会按照size自动截取,它会在数组右侧填充'(byte)0'以使其具有指定的长度
            destByte = Arrays.copyOf(srcByte, size);
        }else{
            destByte = Arrays.copyOf(srcByte, size);
            Arrays.fill(destByte, srcByte.length, size, (byte)padStrByASCII);
        }
        return new String(destByte);
    }


    /**
     * 字符串左补空格
     * see 该方法默认采用空格(其ASCII码为32)来左补字符
     * see 若想自己指定所补字符,可以使用<code>leftPadForByte(String str, int size, int padStrByASCII)</code>方法
     */
    public static String leftPadForByte(String str, int size){
        return leftPadForByte(str, size, 32);
    }


    /**
     * 字符串左补字符
     * see 若str对应的byte[]长度不小于size,则按照size截取str对应的byte[],而非原样返回str
     * see 所以size参数很关键..事实上之所以这么处理,是由于支付处理系统接口文档规定了字段的最大长度
     * param padStrByASCII 该值为所补字符的ASCII码,如32表示空格,48表示0,64表示@等
     */
    public static String leftPadForByte(String str, int size, int padStrByASCII){
        byte[] srcByte = str.getBytes();
        byte[] destByte = new byte[size];
        Arrays.fill(destByte, (byte)padStrByASCII);
        if(srcByte.length >= size){
            System.arraycopy(srcByte, 0, destByte, 0, size);
        }else{
            System.arraycopy(srcByte, 0, destByte, size-srcByte.length, srcByte.length);
        }
        return new String(destByte);
    }

    /**
     * 首字母转小写
     * param s
     * return
     */
    public static String toLowerCaseFirstOne(String s){
        if(Character.isLowerCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    }

    /**
     * 首字母转大写
     * param s
     * return
     */
    public static String toUpperCaseFirstOne(String s){
        if(Character.isUpperCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
    }

    /**
     * 下划线转驼峰法(默认小驼峰)
     *
     * param line
     *            源字符串
     * param smallCamel
     *            大小驼峰,是否为小驼峰(驼峰，第一个字符是大写还是小写)
     * return 转换后的字符串
     */
    public static String underline2Camel(String line, boolean ... smallCamel) {
        if (line == null || "".equals(line)) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        Pattern pattern = Pattern.compile("([A-Za-z\\d]+)(_)?");
        Matcher matcher = pattern.matcher(line);
        //匹配正则表达式
        while (matcher.find()) {
            String word = matcher.group();
            //当是true 或则是空的情况
            if((smallCamel.length ==0 || smallCamel[0] ) && matcher.start()==0){
                sb.append(Character.toLowerCase(word.charAt(0)));
            }else{
                sb.append(Character.toUpperCase(word.charAt(0)));
            }

            int index = word.lastIndexOf('_');
            if (index > 0) {
                sb.append(word.substring(1, index).toLowerCase());
            } else {
                sb.append(word.substring(1).toLowerCase());
            }
        }
        return sb.toString();
    }

    /**
     * 驼峰法转下划线
     *
     * param line
     *            源字符串
     * return 转换后的字符串
     */
    public static String camel2Underline(String line) {
        if (line == null || "".equals(line)) {
            return "";
        }
        line = String.valueOf(line.charAt(0)).toUpperCase()
                .concat(line.substring(1));
        StringBuffer sb = new StringBuffer();
        Pattern pattern = Pattern.compile("[A-Z]([a-z\\d]+)?");
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            String word = matcher.group();
            sb.append(word.toUpperCase());
            sb.append(matcher.end() == line.length() ? "" : "_");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(DNAStringUtil.isNumeric("-1"));
        System.out.println(DNAStringUtil.isNumericContainMinus(""));
        System.out.println(DNAStringUtil.isEmptyString(null));
        System.out.println(DNAStringUtil.isNumbericBigThanZero("-1"));
        System.out.println(DNAStringUtil.isNumbericBigThanZero("0.0"));
        System.out.println(DNAStringUtil.isMobileNO("13764424089"));
        System.out.println(DNAStringUtil.leftPadForByte("11",100));

    }
}
