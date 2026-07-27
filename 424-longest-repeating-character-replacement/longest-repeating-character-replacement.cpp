class Solution {
public:
    int characterReplacement(string s, int k) {
        int ans=0;
        for(char ch='A';ch<='Z';ch++){
            ans=max(ans,solve(s,ch,k));
        }
        return ans;
    }
    int solve(string s,char ch,int k){
        int end=0;
        int start=0;
        int ans=0;
        int flip=0;
        while(end<s.length()){
            if(s[end]!=ch){
                flip++;
            }
            while(flip>k){
                if(s[start]!=ch){
                    flip--;
                }
                start++;
            }
            ans=max(ans,end-start+1);
            end++;
        }
        return ans;
    }
};