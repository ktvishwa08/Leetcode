class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        String ans="";
        int maximum=0;
        int [][] dp = new int[n][n];
        for(int diff=0;diff<n;diff++){
            for(int i=0,j=i+diff;j<n;i++,j++){
                if(i==j)
                dp[i][j]=1;
                else if(diff==1&&s.charAt(i)==s.charAt(j)){
                    dp[i][j]=2;
                }
                else{
                    if(s.charAt(i)==s.charAt(j)&&dp[i+1][j-1]!=0){
                        dp[i][j]=2+dp[i+1][j-1];
                    }
                }
                if(dp[i][j]!=0){
                 if(j-i+1>maximum){
                    maximum=j-i+1;
                    ans=s.substring(i,maximum+i);
                 }
                }
            }
        }
        return ans;
         
    }
}