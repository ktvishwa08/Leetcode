class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        int startingpos=-1,endingpos=-1;
        int n=nums.size();
        for(int i=0;i<n;i++){
            if(nums[i]==target)
            {
                startingpos=i;
                break;
            }
        }

        for(int i=n-1;i>=0;i--)
        {
            if(nums[i]==target)
            {
                endingpos=i;
                break;
            }
        }
        return {startingpos,endingpos};
    }
};