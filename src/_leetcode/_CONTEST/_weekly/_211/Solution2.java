package _leetcode._CONTEST._weekly._211;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 5544. 执行操作后字典序最小的字符串
 * 给你一个字符串 s 以及两个整数 a 和 b 。其中，字符串 s 的长度为偶数，且仅由数字 0 到 9 组成。
 * 你可以在 s 上按任意顺序多次执行下面两个操作之一：
 * 1.累加：将  a 加到 s 中所有下标为奇数的元素上（下标从 0 开始）。数字一旦超过 9 就会变成 0，如此循环往复。例如，如果 s = "3456" 且 a = 5，则执行此操作后 s 变成 "3951"。
 * 2.轮转：将 s 向右轮转 b 位。例如，如果 s = "3456" 且 b = 1，则执行此操作后 s 变成 "6345"。
 * 请你返回在 s 上执行上述操作任意次后可以得到的 字典序最小 的字符串。
 * <p>
 * 如果两个字符串长度相同，那么字符串 a 字典序比字符串 b 小可以这样定义：在 a 和 b 出现不同的第一个位置上，字符串 a 中的字符出现在字母表中的时间早于 b 中的对应字符。例如，"0158” 字典序比 "0190" 小，因为不同的第一个位置是在第三个字符，显然 '5' 出现在 '9' 之前。
 * @Author: matreeix
 * @Date: 2020/10/18
 */

public class Solution2 {
    private String ans;
    private Set<String> set = new HashSet<>();
    private int a, b;

    private void dfs(String str) {
        if (set.contains(str)) return;
        if (ans.compareTo(str) > 0) ans = str;
        set.add(str);
        dfs(add(str));
        dfs(rotate(str));
    }

    private String add(String str) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (i % 2 == 0)
                s.append(str.charAt(i));
            else
                s.append((str.charAt(i) - '0' + a) % 10);
        }
        return s.toString();
    }

    private String rotate(String s) {
        int n = s.length();
        return s.substring(n - b, n) + s.substring(0, n - b);
    }

    public String findLexSmallestString(String s, int a, int b) {
        ans = s;
        this.a = a;
        this.b = b;
        dfs(s);
        return ans;
    }
}
