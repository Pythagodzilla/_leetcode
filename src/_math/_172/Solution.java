package _math._172;

/**
 * @Description: 172. 阶乘后的零
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 * <p>
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 * @Date: 2021/4/1
 */

public class Solution {

    /**
     * 原理：
     * 10是2和5的乘积。在n！中，我们需要知道2和5的个数，零的数目是2和5的数目最小值。
     * 由于2的倍数大于5的倍数，所以零的数目由5的数目决定。
     *
     * 注意：5的倍数提供一个5，25的倍数提供两个5，依此类推。
     * 同时，25的倍数也是5的倍数，因此25的倍数仅提供一个额外的5。
     *
     * 这是基本的解决方案：
     * return n/5 + n/25 + n/125 + n/625 + n/3125+...;
     * 可以轻松地将其重写为循环。
     *
     * */
    public int trailingZeroes(int n) {
        return n < 5 ? 0 : (n / 5 + trailingZeroes(n / 5));
    }
}