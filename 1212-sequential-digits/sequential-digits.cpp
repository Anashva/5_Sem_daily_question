class Solution {
public:
    vector<int> ll;
    vector<int> sequentialDigits(int low, int high) {
        // string r=to_string(high);
        // string ans = "";
        // count(r,0,1,1,-1,ans);
        // vector<int> res;
        // for(int x : ll) {
        //     if(x >= low && x <= high){
        //         res.push_back(x);
        //     }
        // }
        // sort(res.begin(), res.end());
        // return res;

        for(int val=1;val<=9;val++){
            int num=val;
            for(int digit=val+1;digit<=9;digit++){
                num=num*10+digit;
                if(num>=low && num<=high){
                    ll.push_back(num);
                }
            }
        }
        sort(ll.begin(),ll.end());
        return ll;
    }
//     void count(string &s,int idx,int tight,int lz,int prev,string &ans){
//         if(idx==s.length()){
//            if(lz==0 && !ans.empty()){
//             ll.push_back(stoi(ans));
// }
//             return ;
//         }
//         int ub=tight==1 ? s[idx]-'0' :9;
//         for(int digit=0;digit<=ub;digit++){
//             int ntight=(tight==1 && digit==ub) ? 1:0;
//             int nlz=(lz==1 && digit==0) ? 1:0;
//             if(lz==1 && digit==0){
//                 count(s,idx+1,ntight,nlz,prev,ans);
//             }
//             else{
//                 if(prev==-1 || digit==prev+1){
//                     ans.push_back(digit + '0');
//                     count(s,idx+1,ntight,nlz,digit,ans);
//                     ans.pop_back();
//                 }
//             }
//         }
//     }
};