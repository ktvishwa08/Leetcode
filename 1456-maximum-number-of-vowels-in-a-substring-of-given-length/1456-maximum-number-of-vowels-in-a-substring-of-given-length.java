class Solution {
    public int maxVowels(String s, int k) {
        int maximum=0;
        int count=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                count++;
            }
            if(i>=k){
                char oldCh=s.charAt(i-k);
                if(oldCh=='a'||oldCh=='e'||oldCh=='i'||oldCh=='o'||oldCh=='u'){
                    count--;
                }
            }
            if(i>=k-1){
                maximum=Math.max(maximum,count);
            }
        }
        return maximum;
    }
} 