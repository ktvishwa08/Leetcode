class Solution {
    public int removeDuplicates(int[] nums) {
        int k=0;
        int low=0;
        int high=0;
        while(high<nums.length){
            if(nums[high]!=nums[k]){
                nums[++k]=nums[high];
            }
            high++;
        }
        return k+1;
    }
}