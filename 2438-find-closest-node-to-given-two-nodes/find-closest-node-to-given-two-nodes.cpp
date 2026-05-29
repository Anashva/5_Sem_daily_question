class Solution {
public:
    int closestMeetingNode(vector<int>& edges, int node1, int node2) {
        unordered_map<int,int> mp1;
        stack<int> st;
        set<int> s;
        st.push(node1);
        mp1[node1]=0;
        while(!st.empty()){
            int r=st.top();
            st.pop();
            if(s.count(r) || edges[r]==-1){
                continue;
            }
            s.insert(r);
            if(!mp1.count(edges[r])){
                mp1[edges[r]]=mp1[r]+1;
                st.push(edges[r]);
            }
        }
        st=stack<int>();
        s.clear();
        unordered_map<int,int> mp2;
        mp2[node2]=0;
        st.push(node2);
        int ans=INT_MAX;
        int ele=-1;
        while(!st.empty()){
            int r=st.top();
            st.pop();
            if(mp1.count(r)){
                int res=max(mp1[r],mp2[r]);
                if(res<ans || (ans==res && r<ele)){
                    ans=res;
                    ele=r;
                }
            }
            if(s.count(r) || edges[r]==-1){
                continue;
            }
            s.insert(r);
            if(!mp2.count(edges[r])){
                mp2[edges[r]]=mp2[r]+1;
                st.push(edges[r]);
            }
        }
        return ele;
    }
};