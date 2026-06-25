class Solution {
public:
    int ladderLength(string begin, string end, vector<string>& words) {
        unordered_set<string> st;
        for(string s:words){
            st.insert(s);
        }
        if(!st.count(end)){
            return 0;
        }
        queue<pair<string,int>> q;
        q.push({begin,1});
        while(!q.empty()){
            auto [start,step]=q.front();
            q.pop();
            if(start==end){
                return step;
            }
            for(int i=0;i<start.length();i++){
                char ch=start[i];
                for(char d='a';d<='z';d++){
                    start[i]=d;
                    if(st.count(start)){
                        st.erase(start);
                        q.push({start,step+1});
                    }
                }
                start[i]=ch;
            }

        }
        return 0;
    }
};