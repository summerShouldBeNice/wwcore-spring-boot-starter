package com.warmwind.wwcore.core.utils;

import com.warmwind.wwcore.core.enums.CreateMode;

import java.util.Random;
import java.util.function.Supplier;

/**
 * 随机工具类
 *
 * @author warmwind
 * @createTime 2024-03-03 15:11
 */
public class RandomUtils {

    /**
     * 单例random
     */
    private static final Random random = new Random();

    /**
     * 默认范围
     */
    private static final Integer DEFAULT_BOUND = 10;

    /**
     * 字母表，默认大写
     */
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * 数字表
     */
    private static final String DIGITAL = "0123456789";

    /**
     * 根据模式生成指定长度的随机字符串
     * @param length
     * @param mode
     * @return
     */
    public static String generateRandomStr(int length, CreateMode mode) {
        String str = null;
        switch (mode) {
            case NUMBER -> str = generateNumberStr(length);
            case LETTER -> str = generateLetterStr(length);
            case LOWER_LETTER -> str = generateLowerLetterStr(length);
            case NUMBER_AND_LETTER -> str = generateNumberAndLetterStr(length);
            case NUMBER_AND_LOWER_LETTER -> str = generateNumberAndLowerLetterStr(length);
            case ALL_LETTER -> str = generateAllLetterStr(length);
            case ALL -> str = generateAllStr(length);
        }
        return str;
    }


    /**
     * 根据资源生成指定长度的随机字符串
     * @param length
     * @param supplier
     * @return
     */
    public static String generateRandomStr(int length, Supplier<Character> supplier) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < length; i++) {
            str.append(supplier.get());
        }
        return str.toString();
    }

    /**
     * 生成指定长度的随机数字的字符串
     * @param length
     * @return
     */
    public static String generateNumberStr(int length) {
        return generateRandomStr(length, () -> getRandomNumber());
    }

    /**
     * 生成指定长度的随机字母字符串
     * @param length
     * @return
     */
    public static String generateLetterStr(int length) {
        return generateRandomStr(length, () -> getRandomLetter());
    }

    /**
     * 生成指定长度的随机小写字母字符串
     * @param length
     * @return
     */
    public static String generateLowerLetterStr(int length) {
        return generateRandomStr(length, () -> getRandomLowerLetter());
    }

    /**
     * 生成指定长度的随机大写加小写字母的字符串
     */
    public static String generateAllLetterStr(int length) {
        return generateRandomStr(length, () -> getRandomAllLetter());
    }

    /**
     * 生成指定长度的随机大写字母加数字的字符串
     */
    public static String generateNumberAndLetterStr(int length) {
        return generateRandomStr(length, () -> getRandomNumberAndLetter());
    }

    /**
     * 生成指定长度的随机小写字母加数字的字符串
     */
    public static String generateNumberAndLowerLetterStr(int length) {
        return generateRandomStr(length, () -> getRandomNumberAndLowerLetter());
    }

    /**
     * 生成指定长度的随机大写加小写字母加数字的字符串
     */
    public static String generateAllStr(int length) {
        return generateRandomStr(length, () -> getAllNumberAndLetter());
    }

    /**
     * 获取数字表中的随机字符
     * 默认大写
     * @return
     */
    public static char getRandomNumber() {
        return DIGITAL.toCharArray()[random.nextInt(DIGITAL.length())];
    }

    /**
     * 获取字母表中的随机字母
     * 默认大写
     * @return
     */
    public static char getRandomLetter() {
        return ALPHABET.toCharArray()[random.nextInt(ALPHABET.length())];
    }

    /**
     * 获取字母表中的随机小写字母
     * @return
     */
    public static char getRandomLowerLetter() {
        return ALPHABET.toLowerCase().toCharArray()[random.nextInt(ALPHABET.length())];
    }

    /**
     * 获取大写加上小写字母中的随机字母
     * @return
     */
    public static char getRandomAllLetter() {
        String allALPHABET = ALPHABET + ALPHABET.toLowerCase();
        return allALPHABET.toCharArray()[random.nextInt(allALPHABET.length())];
    }

    /**
     * 获取大写字母加上数字中的随机字符
     * @return
     */
    public static char getRandomNumberAndLetter() {
        String str = ALPHABET + DIGITAL;
        return str.toCharArray()[random.nextInt(str.length())];
    }

    /**
     * 获取小写字母加上数字中的随机字符
     * @return
     */
    public static char getRandomNumberAndLowerLetter() {
        String str = ALPHABET.toLowerCase() + DIGITAL;
        return str.toCharArray()[random.nextInt(str.length())];
    }

    /**
     * 获取大小写加上数字中的随机字符
     * @return
     */
    public static char getAllNumberAndLetter() {
        String str = ALPHABET + DIGITAL + ALPHABET.toLowerCase();
        return str.toCharArray()[random.nextInt(str.length())];
    }
}
