class Solution {
    public int longestSubstring(String s, int k) {
        if(s.length()<0){
            return 0;
        }
        int ans=0;
        for(int i=0;i<s.length();i++){
            int[] freq=new int[26];
            for(int j=i;j<s.length();j++){
                freq[s.charAt(j)-'a']++;
                if(check(freq,k) ){
                    ans=Math.max(ans,j-i+1);
                }
            }
        }
        return ans;
    }
    public boolean check(int[] freq,int k){
        for(int i:freq){
            if(i!=0 && i<k){
                return false;
            }
        }
        return true;
    }
}