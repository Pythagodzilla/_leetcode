package _leetcode._Cracking_the_Coding_Interview._05._01;


/**
 * @Description: 面试题 05.01. 插入
 * 插入。给定两个32位的整数(二进制形式)N与M，以及表示比特位置的i与j。编写一种方法，将M插入N，使得M从N的第j位开始，到第i位结束。
 * 假定从j位到i位足以容纳M，也即若M = 10 011，那么j和i之间至少可容纳5个位。例如，不可能出现j = 3和i = 2的情况，因为第3位和第2位之间放不下M。
 * 注意：计数是从右往左计数，把从i到j替换为M，长度不足的高位补0。
 * @Author: matreeix
 * @Date: 2020/6/29
 */

public class Solution {
    public int insertBits(int N, int M, int i, int j) {
        if(j + 1 == 32) return (N >> j << j) | (((N >> i << i)) ^ N) | (M << i);
        return (N >> (j + 1) << (j + 1)) | (((N >> i << i)) ^ N) | (M << i);
    }

}
