class Solution {
public:
    bool find132pattern(vector<int>& nums) {
        stack<int> st;
        int c=INT_MIN;
        int n=nums.size();
        for(int i=n-1;i>=0;i--){
            while(!st.empty() && nums[i]>st.top()){
                c=st.top();
                st.pop();
            }
            if(nums[i]<c){
                return true;
            }
            st.push(nums[i]);
        }
        return false;
    }
};