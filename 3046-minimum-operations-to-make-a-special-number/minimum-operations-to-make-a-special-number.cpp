class Solution {
public:
    int minimumOperations(string num) {
        string arr[]={"00","25","50","75"};
        int ans=num.length();
        for(string str:arr){
            ans=min(ans,count(num,str));
        }
        for(int i=0;i<num.length();i++){
            if(num[i]=='0'){
                ans=min(ans,(int)num.length()-1);
                break;
            }
        }
        return ans;
    }
    int count(string s,string t){
        int n=s.length()-1;
        int ans=0;
        while(n>=0 && s[n]!=t[1]){
            n--;
            ans++;
        }
        if(n<0){
            return 100;
        }
        n--;
        while(n>=0 && s[n]!=t[0]){
            n--;
            ans++;
        }
        if(n<0){
            return 100;
        }
        return ans;
    }
};