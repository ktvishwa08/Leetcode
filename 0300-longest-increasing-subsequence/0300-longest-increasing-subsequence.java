class Solution {
    public int lower_bound(List<Integer> arr, int target) {
        int low = 0;
        int high = arr.size() - 1;
        int ans = arr.size();
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr.get(mid) >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    public int lengthOfLIS(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int pos = lower_bound(arr, nums[i]);
            if (pos == arr.size()) {
                arr.add(nums[i]);
            } else {
                arr.set(pos, nums[i]);
            }
        }
        return arr.size();
    }
}