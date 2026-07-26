import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        solve(nums, current, answer);

        return answer;
    }

    void solve(int[] nums, List<Integer> current,
               List<List<Integer>> answer) {

        // One complete permutation is formed
        if (current.size() == nums.length) {
            answer.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            // Do not use the same number again
            if (current.contains(nums[i])) {
                continue;
            }

            // Choose
            current.add(nums[i]);

            // Find remaining numbers
            solve(nums, current, answer);

            // Remove the selected number
            current.remove(current.size() - 1);
        }
    }
}