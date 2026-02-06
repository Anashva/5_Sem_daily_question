class Solution {
    public int totalSteps(int[] nums) {
        Stack<int[]> st=new Stack<>();
        int ans=0;
        for(int i=0;i<nums.length;i++){
            int c=0;
            while(!st.isEmpty() && nums[st.peek()[0]]<=nums[i]){
                c=Math.max(c,st.pop()[1]);
            }
            if(!st.isEmpty()){
                c++;
            }
            ans=Math.max(ans,c);
            st.push(new int[]{i,c});
        }
        return ans;
    }
}