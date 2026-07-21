class Solution {

    public int solve(int[] nums, int start, int end) {

        if (start == end)
            return nums[start];

        int[] ans = new int[end - start + 1];

        ans[0] = nums[start];
        ans[1] = Math.max(nums[start], nums[start + 1]);

        for (int i = 2; i < ans.length; i++) {
            ans[i] = Math.max(ans[i - 1], nums[start + i] + ans[i - 2]);
        }

        return ans[ans.length - 1];
    }

    public int rob(int[] nums) {

        if (nums.length == 1)
            return nums[0];

        int a = solve(nums, 0, nums.length - 2); // exclude last
        int b = solve(nums, 1, nums.length - 1); // exclude first

        return Math.max(a, b);
    }
}