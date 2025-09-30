class Solution {
    public int lengthOfLongestSubstring(String s) {
       int ans=0;
       int start=0;
       int end=0;
       int[] freq=new int[256];
       while(end<s.length()){
        freq[s.charAt(end)]++;
        while(freq[s.charAt(end)]>1){
            freq[s.charAt(start)]--;
            start++;
        }
        ans=Math.max(ans,end-start+1);
        end++;
       }
       return ans;
    }
   
}