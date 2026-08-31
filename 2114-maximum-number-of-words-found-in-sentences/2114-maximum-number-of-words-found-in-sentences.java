import java.util.*;
class Solution {
    public int mostWordsFound(String[] sentences) {
        int max=0;
        for(int i=0;i<sentences.length;i++){
            String curr=sentences[i];
            StringTokenizer st=new StringTokenizer(curr," ");
            max=Math.max(max,st.countTokens());
        }
        return max;
    }
}