class Solution {
public:
    string reverseWords(string s) {
        stringstream ss(s);//rempve extra spaces
        string w,ans;
        while(ss>>w){//one word at time
            if(ans.empty()){
                ans=w;
            }
            else{
                ans=w+" "+ans;
            }
        }
        return ans;
    }
};