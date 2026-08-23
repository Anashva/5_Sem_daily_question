class Solution {
public:
    bool sumGame(string num) {
        int c1=0;
        int c2=0;
        int left=0;
        int right=0;
        int n=num.size();
        for(int i=0;i<n/2;i++){
            if(num[i]=='?'){
                c1++;
            }
            else{
                left+=num[i]-'0';
            }
        }
        for(int i=n/2;i<n;i++){
            if(num[i]=='?'){
                c2++;
            }
            else{
                right+=num[i]-'0';
            }
        }
        int diff=left-right;
        int cnt=c1-c2;
        if(cnt%2!=0){
            return true;
        }
        return diff!= -9*cnt/2;
    }
};