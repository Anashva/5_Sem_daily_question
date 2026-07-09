class Solution {
public:
    const int INT_MIN_VAL = -2147483648;
    const int INT_MAX_VAL = 2147483647;
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
            sign=(s[i]=='-') ? -1:1;
            i++;
        }
        return solve(s,i,0,sign);
    }
    int solve(string &s,int idx,long long num,int sign){
        if(idx>=s.length() || !isdigit(s[idx])){
            return (int)(sign*num);
        }
        num=num*10+(s[idx]-'0');
        if(sign*num>=INT_MAX_VAL){
            return INT_MAX_VAL;
        }
        if(sign*num<=INT_MIN_VAL){
            return INT_MIN_VAL;
        }
        return solve(s,idx+1,num,sign);
    }
};