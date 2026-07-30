import java.util.*;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> answer = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        backtrack(nums, used, new ArrayList<>(), answer);

        return answer;
    }

    private void backtrack(
        int[] nums,
        boolean[] used,
        List<Integer> current,
        List<List<Integer>> answer
    ) {
        if (current.size() == nums.length) {
            answer.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            // Number is already used
            if (used[i]) {
                continue;
            }

            // Skip duplicate number
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            used[i] = true;
            current.add(nums[i]);

            backtrack(nums, used, current, answer);

            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}