class Solution {
    public int minOperations(int[] nums) {
        Stack<Integer> st=new Stack<>();
        int ans=0;
        st.push(0);
        for(int i=0;i<nums.length;i++){
            while(!st.isEmpty() && st.peek()>nums[i]){
                st.pop();
            }
            if(st.isEmpty() || st.peek()<nums[i]){
                st.push(nums[i]);
                ans++;
            }
        }
        return ans;
    }
}