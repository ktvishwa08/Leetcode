import java.lang.*;
class Solution {
    boolean isValid(int mid,int[] piles,int h){
        long hours=0;
        for(int i=0;i<piles.length;i++){
            hours+=(piles[i]/mid);
            if((piles[i]%mid)!=0)
            hours=hours+1;
        }
    if(hours>h)
    return false;
    else
    return true;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int maximum=piles[0];
        for(int i=1;i<piles.length;i++){
            maximum=Math.max(maximum,piles[i]);
        }
        int low=1;
        int high=maximum;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isValid(mid,piles,h)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
}