class Solution {
public:
    int maxActiveSectionsAfterTrade(string s) {
        int a=0;
        int b=0;
        int sum=0;
        int one=0;
        for(int i=0;i<s.length();i++){
            if(s[i]=='0'){
                a++;
            }
            else{
                one++;
                if(b==0){
                    b=a;
                    a=0;
                }
                else if(a!=0){
                    sum=max(sum,a+b);
                    b=a;
                    a=0;
                }
            }
        }
        if(a!=0 && b!=0){
            sum=max(sum,a+b);
        }
        return sum+one;
    }
};