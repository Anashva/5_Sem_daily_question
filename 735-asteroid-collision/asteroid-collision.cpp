class Solution {
public:
    vector<int> asteroidCollision(vector<int>& asteroids) {
        vector<int> ans;
        stack<int> st;
        for(int i=0;i<asteroids.size();i++){
            bool flag=false;
            int val=asteroids[i];
            while(!st.empty() && st.top()>0 && val<0){
                int k=abs(val);
                if(k==st.top()){
                    st.pop();
                    flag=true;
                    break;
                }
                else if(k>st.top()){
                    st.pop();
                }
                else{
                    flag=true;
                    break;
                }
            }
            if(!flag){
                st.push(val);
            }
        }
        while (!st.empty()) {
            ans.push_back(st.top());
            st.pop();
        }

        reverse(ans.begin(), ans.end());
        return ans;
    }
};