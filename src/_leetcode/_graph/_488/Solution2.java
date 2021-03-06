package _leetcode._graph._488;

/**
 * @Description:
 * @Author: matreeix
 * @Date: 2020/2/17
 */
public class Solution2 {
    int MAXCOUNT = 6;// the max balls you need will not exceed 6 since "The number of balls in your hand won't exceed 5"

    public int findMinStep(String board, String hand) {
        int[] handCount = new int[26];
        for (int i = 0; i < hand.length(); ++i) ++handCount[hand.charAt(i) - 'A'];
        int rs = helper(board + "#", handCount);//append a "#" to avoid special process while j==board.length, make the code shorter.
        return rs == MAXCOUNT ? -1 : rs;
    }

    private int helper(String s, int[] h) {
        s = removeConsecutive(s);
        if (s.equals("#")) return 0;
        int rs = MAXCOUNT, need = 0;
        for (int i = 0, j = 0; j < s.length(); ++j) {
            if (s.charAt(j) == s.charAt(i)) continue;
            need = 3 - (j - i);//balls need to remove current consecutive balls.
            if (h[s.charAt(i) - 'A'] >= need) {
                h[s.charAt(i) - 'A'] -= need;
                rs = Math.min(rs, need + helper(s.substring(0, i) + s.substring(j), h));
                h[s.charAt(i) - 'A'] += need;
            }
            i = j;
        }
        return rs;
    }

    //remove consecutive balls longer than 3
    private String removeConsecutive(String board) {
        for (int i = 0, j = 0; j < board.length(); ++j) {
            if (board.charAt(j) == board.charAt(i))
                continue;
            else if (j - i < 3)
                i = j;
            else
                return removeConsecutive(board.substring(0, i) + board.substring(j));
        }
        return board;

        /*int startSize = board.length();
        int i = 0, j = 1;
        while (i < board.length() && j < board.length()) {
            if (board.charAt(j) == board.charAt(i)) {
                j++;
            } else if (j - i < 3) {
                i = j;
                j++;
            } else {//需要消除
                board = board.substring(0, i) + board.substring(j);
                j = i + 1;
            }
        }
        int endSize = board.length();
        if (startSize == endSize)
            return board;
            return removeConsecutive(board);*/
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        String board = "aabbbbbbaaaaccc";
        System.out.println(solution2.removeConsecutive(board));
    }
}
