class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int max = 0;
        for (int i : weights)
            max = Math.max(max, i);
        int l = max, h = Integer.MAX_VALUE, ans = Integer.MAX_VALUE;
        while (l <= h) {
            int capacity = l + (h - l) / 2;
            int totalDays = 1;
            int cur = capacity;
            for (int i = 0; i < n; i++) {
                if (cur < weights[i]) {
                    totalDays++;
                    cur = capacity;
                }
                cur -= weights[i];
            }
            if (totalDays <= days) {
                ans = capacity;
                h = capacity - 1;
            } else
                l = capacity + 1;
        }
        return ans;
    }
}