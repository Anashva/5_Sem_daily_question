class Solution {
    public int characterReplacement(String s, int k) {
        int ans=0;
        for(char ch='A';ch<='Z';ch++){
            ans=Math.max(ans,maxlen(s,ch,k));
        }
        return ans;
    }
    public static int maxlen(String s,char ch,int k){
        int start=0;
        int end=0;
        int flip=0;
        int ans=0;
        while(end<s.length()){
            if(s.charAt(end)!=ch){
                flip++;
            }
            while(flip>k){
                if(s.charAt(start)!=ch){
                    flip--;
                }
                start++;
            }
            ans=Math.max(ans,end-start+1);
            end++;
        }
        return ans;
    }
}