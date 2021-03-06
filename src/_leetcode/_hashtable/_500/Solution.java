package _leetcode._hashtable._500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。
 * @Author: matreeix
 * @Date: 2020/5/5
 */
public class Solution {
    public String[] findWords(String[] words) {
        if (words == null)
            return null;

        List<String> ans = new ArrayList<>();

        // 字典行
        String lines[] = new String[]{
                "qwertyuiop",
                "asdfghjkl",
                "zxcvbnm"
        };

        for (String word : words) {
            if (judge(word.toLowerCase(), lines)) {
                ans.add(word);
            }
        }

        return ans.toArray(new String[ans.size()]);
    }

    private boolean judge(String word, String[] lines) {
        boolean ok = true;
        String find = null;

        // 先用word首字符确定属于哪一行
        for (String line : lines) {
            if (line.indexOf(word.charAt(0)) > -1) {
                find = line;
                break;
            }
        }

        if (find == null) {
            ok = false;
            return ok;
        }

        // 判断word字符串所有字符是否都属于同一行
        for (int i = 1; i < word.length(); i++) {
            if (find.indexOf(word.charAt(i)) < 0) {
                ok = false;
                break;
            }
        }

        return ok;
    }

    public String[] findWords2(String[] words) {
        int[] rows = {2, 3, 3, 2, 1, 2, 2, 2, 1, 2, 2, 2, 3, 3, 1, 1, 1, 1, 2, 1, 1, 3, 1, 3, 1, 3};
        List<String> list = new ArrayList<>();
        for (String a : words) {
            String s = a.toLowerCase();
            boolean isValid = true;
            int row = rows[s.charAt(0) - 'a'];
            for (int i = 1; i < s.length(); i++) {
                if (rows[s.charAt(i) - 'a'] != row) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                list.add(a);
            }

        }
        return list.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        System.out.println(Arrays.toString((new Solution()).findWords(words)));
    }
}
