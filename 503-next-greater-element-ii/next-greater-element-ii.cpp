class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        stack<int> st;
        vector<int> ans(nums.size(),-1);
        int n=nums.size();
        for(int i=2*n-1;i>=0;i--){
            while(!st.empty() && st.top()<=nums[i%n]){
                st.pop();
            }
            if(i<n && !st.empty()){
                ans[i%n]=st.top();
            }
            st.push(nums[i%n]);
        }
        return ans;
    }
};

// using monotonic decreasing stack
// we will pop element from stack until we get grreater element that 