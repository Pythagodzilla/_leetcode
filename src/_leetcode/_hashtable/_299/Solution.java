package _leetcode._hashtable._299;

import java.util.Arrays;

/**
 * @Description: 299. 猜数字游戏
 * 你在和朋友一起玩 猜数字（Bulls and Cows）游戏，该游戏规则如下：
 * <p>
 * 你写出一个秘密数字，并请朋友猜这个数字是多少。
 * 朋友每猜测一次，你就会给他一个提示，告诉他的猜测数字中有多少位属于数字和确切位置都猜对了（称为“Bulls”, 公牛），有多少位属于数字猜对了但是位置不对（称为“Cows”, 奶牛）。
 * 朋友根据提示继续猜，直到猜出秘密数字。
 * 请写出一个根据秘密数字和朋友的猜测数返回提示的函数，返回字符串的格式为 xAyB ，x 和 y 都是数字，A 表示公牛，用 B 表示奶牛。
 * <p>
 * xA 表示有 x 位数字出现在秘密数字中，且位置都与秘密数字一致。
 * yB 表示有 y 位数字出现在秘密数字中，但位置与秘密数字不一致。
 * 请注意秘密数字和朋友的猜测数都可能含有重复数字，每位数字只能统计一次。
 * <p>
 * 说明: 你可以假设秘密数字和朋友的猜测数都只包含数字，并且它们的长度永远相等。
 * @Author: matreeix
 * @Date: 2020/10/28
 */

public class Solution {
    public static String getHint(String secret, String guess) {
        int A = 0, B = 0;
        int[] cnt = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {//Bulls
                A++;
            } else {
                cnt[secret.charAt(i) - '0']++;
            }
        }
        System.out.println(Arrays.toString(cnt));
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) != guess.charAt(i) && cnt[guess.charAt(i) - '0'] > 0) {
                B++;
                cnt[guess.charAt(i) - '0']--;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(A).append("A").append(B).append("B");
        return sb.toString();
//        return A + "A" + B + "B";
    }

    public String getHint2(String secret, String guess) {
        int[] countsSecret = new int[10], countsGuess = new int[10];
        int n = secret.length(), bulls = 0, cows = 0;
        for (int i = 0; i < n; i++) {
            if (secret.charAt(i) == guess.charAt(i)) bulls++;
            else {
                countsSecret[secret.charAt(i) - '0']++;
                countsGuess[guess.charAt(i) - '0']++;
            }
        }
        for (int i = 0; i < 10; i++) {//妙啊！
            if (countsSecret[i] > 0) cows += Math.min(countsSecret[i], countsGuess[i]);
        }
        StringBuilder hint = new StringBuilder();
        return hint.append(bulls).append('A').append(cows).append('B').toString();
    }

    public static void main(String[] args) {
        System.out.println(getHint("1123", "0111"));
    }
}
