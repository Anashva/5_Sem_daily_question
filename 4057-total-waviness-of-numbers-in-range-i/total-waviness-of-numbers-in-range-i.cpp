class Solution {
public:
    int totalWaviness(int num1, int num2) {
        int ans=0;
        for(int i=num1;i<=num2;i++){
            ans+=wave(i);
        }
        return ans;
    }
    int wave(int n){
        string s=to_string(n);
        if(s.length()<3){
            return 0;
        }
        int c=0;
        for(int i=1;i<s.length()-1;i++){
            int curr=s[i]-'0';
            int prev=s[i-1]-'0';
            int next=s[i+1]-'0';
            if(curr>prev && curr>next){
                c++;
            }
            if(curr<prev && curr<next){
                c++;
            }
        }
        return c;
    }
};