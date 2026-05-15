class Solution {
public:
    int minFlips(string s) {
        int n=s.length();
        int one=0;
        int zero=0;
        for(int i=0;i<n;i++){
            if(s[i]=='0'){
                zero++;
            }
            else{
                one++;
            }
        }
        int ans=n;
        ans=min(ans,min(one,zero));//convert all to 1 or 0
        if(s[0]=='1' && s[n-1]=='1'){
            ans=min(ans,abs(one-2));
        }
        else if(s[0]=='1' || s[n-1]=='1'){
            ans=min(ans,abs(one-1));
        }
        else{
            ans=min(ans,abs(one-1));
        }
        return ans;
    }
};