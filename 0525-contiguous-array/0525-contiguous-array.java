import java.util.*;
class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                sum--;
            } else {
                sum++;
            }
            if (sum == 0) {
                maxLen = i + 1;
            }
            if (map.containsKey(sum)) {
                int length = i - map.get(sum);
                maxLen = Math.max(maxLen, length);
            } 
            else {
              map.put(sum, i);
            }
        }
        return maxLen;
    }
}