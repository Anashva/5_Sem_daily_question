class Solution {
public:
    int si=0;
    int ei=0;
    void expand(string &s,int i,int j){
        while(i>=0 && j<s.length() && s[i]==s[j]){
            if(j-i+1>ei){
                ei=j-i+1;
                si=i;
            }
            i--;
            j++;
        }
    }
    string longestPalindrome(string s) {
        // int n=s.length();
        // bool dp[n][n];
        // for(int i=n-1;i>=0;i--){
        //     for(int j=i;j<n;j++){
        //         if(s[i]==s[j]){
        //             if(j-i<=2){
        //                 dp[i][j]=true;
        //             }
        //             else{
        //                 dp[i][j]=dp[i+1][j-1];
        //             }
        //         }
        //         else{
        //             dp[i][j]=false;
        //         }
        //     }
        // }
        // int ans=0;
        // string res="";
        // for(int i=0;i<n;i++){
        //     for(int j=i;j<n;j++){
        //         if(dp[i][j] && ans<j-i+1){
        //             ans=j-i+1;
        //             res=s.substr(i,j-i+1);
        //         }
        //     }
        // }
        // return res;

        for(int i=0;i<s.length();i++){
            expand(s,i,i);
            expand(s,i,i+1);
        }
        return s.substr(si,ei);
    }
};