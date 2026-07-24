class Solution {
public:
    int myAtoi(string s) {
        int i=0;
        while(i<s.length() && s[i]==' '){
            i++;
        }
        if(i==s.length()){
            return 0;
        }
        int sign=1;
        if(i<s.length() && (s[i]=='+' || s[i]=='-')){
            sign=(s[i]=='+') ? +1 : -1;
            i++;
        }
        return solve(s,i,0,sign);
    }
    int solve(string &s,int idx,long long num,int sign){
        if(idx>=s.length() || !isdigit(s[idx])){
            return (int)(sign*num);
        }
        num=num*10+(s[idx]-'0');
        if(sign*num>=INT_MAX){
            return INT_MAX;
        }
        if(sign*num<=INT_MIN){
            return INT_MIN;
        }
        return solve(s,idx+1,num,sign);
    }
};