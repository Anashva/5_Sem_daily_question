class Solution {
public:
    int ans=1;
    vector<vector<int>> ll;
    int longestPath(vector<int>& parent, string s) {
        int n=s.length();
        ll.resize(n);
        for(int i=1;i<n;i++){
            ll[parent[i]].push_back(i);
        }
        path(s,0);
        return ans;
    }
    int path(string &s,int u){
        int max1=0;
        int max2=0;
        for(int nbr:ll[u]){
            int len=path(s,nbr);
            if(s[u]==s[nbr]){
                continue;
            }
            if(len>max1){
                max2=max1;
                max1=len;
            }
            else if(len>max2){
                max2=len;
            }
        }
        ans=max(ans,max1+1+max2);
        return max1+1;
    }
};