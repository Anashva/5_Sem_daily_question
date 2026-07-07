class Solution {
public:
    long long sumAndMultiply(int n) {
        if(n==0){
            return 0;
        }
        string s=to_string(n);
        string t="";
        long long sum=0;
        for(char ch:s){
            if(ch!='0'){
                t.push_back(ch);
                sum+=ch-'0';
            }
        }
        long long val=stoi(t);
        long long ans=val*sum;
        return ans;

    }
};