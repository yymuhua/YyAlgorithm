package com.learn.algorithm.math;

/**
 * 利用Random7()函数构造Random10()函数
 * Random7()产生1-7的均匀分布随机数
 * Random10()产生1-10的均匀分布随机数
 * @author yymuhua
 * @create 2020-04-13 14:48
 */
public class Random7toRandom10 {
    public int Random7() {
        return (int) (Math.random() * 7 + 1);
    }
    public int Random10() {
        int num = (Random7() * 7) + Random7() - 1; // 构造0-48的均匀分布随机数
        while(num >= 40) {
            num = (Random7() * 7) + Random7() - 1;
        }
        return num / 4 + 1;
    }
}
