package _leetcode.backtracking._47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 47. 全排列 II
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * @Date: 2021/3/30
 */

public class Solution {

    boolean[] visited;

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> perm = new ArrayList<Integer>();
        visited = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, ans, 0, perm);
        return ans;
    }

    public void backtrack(int[] nums, List<List<Integer>> ans, int idx, List<Integer> perm) {
        if (idx == nums.length) {
            ans.add(new ArrayList<Integer>(perm));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            perm.add(nums[i]);
            visited[i] = true;
            backtrack(nums, ans, idx + 1, perm);
            visited[i] = false;
            perm.remove(idx);
        }
    }
}
