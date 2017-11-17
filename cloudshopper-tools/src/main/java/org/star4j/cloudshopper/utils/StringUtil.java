package org.star4j.cloudshopper.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: WuYL
 * @Description: 字符串工具类
 * @Date: Create in 2017/11/10 16:26
 * @Modified By:
 */
public class StringUtil {

    /**
     * 字符串分割符
     */
    public static final String SEPARATOR = String.valueOf((char) 29);

    /**
     * 判断字符串是否为空
     */
    public static boolean isEmpty(String str){
        if(str != null){
            str = str.trim();
        }
        return StringUtils.isEmpty(str);
    }

    /**
     * 判断字符串是否是非空
     */
    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }

    /**
     * 若字符串为空，则取默认值
     */
    public static String defaultEmpty(String str,String defaultValue) {
        return StringUtils.defaultIfEmpty(str, defaultValue);
    }

    /**
     * 替换固定格式的
     */
    public static String replaceAll(String str, String regex, String replacement) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        if (matcher.find()) {
            matcher.appendReplacement(sb, replacement);
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    /**
     * 判断是否为数字
     * @param str
     * @return
     */
    public static boolean isNumber(String str) {
        return NumberUtils.isNumber(str);
    }

    /**
     * 判断是否为十进制整数
     */
    public static boolean isDigits(String str) {
        return NumberUtils.isDigits(str);
    }

    /**
     * 将驼峰风格替换为下划线风格
     */
    public static String camelhumpToUnerline(String str) {
        Matcher matcher = Pattern.compile("[A-Z]").matcher(str);
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; matcher.find() ; i++) {
            sb.replace(matcher.start() + i, matcher.end() + i, "_" + matcher.group().toLowerCase());
        }
        if ('_' == sb.charAt(0)) {
            sb.deleteCharAt(0);
        }
        return sb.toString();

    }

    /**
     * 下划线替换为驼峰
     * @param str
     * @return
     */
    public static String unerlineToCamelhump(String str) {
        Matcher matcher = Pattern.compile("_[a-z]").matcher(str);
        StringBuilder builder = new StringBuilder(str);
        for (int i = 0; matcher.find(); i++) {
            builder.replace(matcher.start() - i, matcher.end() - i, matcher.group().substring(1).toUpperCase());
        }
        return builder.toString();
    }

    /**
     * 分割固定的字符串
     * @return
     */
    public static String[] splitString(String str,String separator) {
        return StringUtils.splitByWholeSeparator(str, separator);
    }

    /**
     * 将字符串首字母大写
     */
    public static String firstToUpper(String str) {
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }

    /**
     * 将首字母小写
     */
    public static String firstToLower(String str) {
        return Character.toLowerCase(str.charAt(0)) + str.substring(1);
    }

    /**
     * 转为帕斯卡命名方式（如：FooBar）
     */
    public static String toPascalStyle(String str ,String seperator) {
        return StringUtil.firstToUpper(toCamelhumpStyle(str, seperator));
    }

    /**
     * 转为驼峰命令方式（如：fooBar）
     */
    public static String toCamelhumpStyle(String str,String seperator) {
        return StringUtil.unerlineToCamelhump(toUnderlineStyle(str, seperator));
    }


    /**
     * 转为下划线命名方式（如：foo_bar）
     */
    public static String toUnderlineStyle(String str,String seperator) {
        str = str.trim().toLowerCase();
        if (str.contains(seperator)) {
            str = str.replace(seperator , "_");
        }
        return str;
    }

    /**
     * 转为现实命名方式
     */
    public static String toDisplayStyle(String str, String seperator) {
        String displayName = "";
        str = str.trim().toLowerCase();
        if (str.contains(seperator)) {
            String[] words = StringUtil.splitString(str, seperator);
            for (String word : words) {
                displayName += StringUtil.firstToUpper(word)+"";
            }
        }else {
            displayName = StringUtil.firstToUpper(str);
        }
        return displayName;
    }

    /**
     * 用于获取上传到 FastDFS 下的文件路径（不包括后缀）
     * @param filePath
     * @return
     */
    public static String fileName(String filePath) {
        if(StringUtils.isNotBlank(filePath)) {
            return filePath.substring(0, filePath.lastIndexOf("."));
        }
        return null;
    }

    /**
     * 用于获取上传到 FastDFS 下的文件后缀名
     * @param filePath
     * @return
     */
    public static String extName(String filePath) {
        if(StringUtils.isNotBlank(filePath)) {
            return filePath.substring(filePath.lastIndexOf(".") + 1);
        }
        return null;
    }
}
