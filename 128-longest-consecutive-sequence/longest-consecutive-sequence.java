class Solution {
    public int longestConsecutive(int[] nums) {
        // if(nums.length==0){
        //     return 0;
        // }
        // if(nums.length==1){
        //     return 1;
        // }
        // int l=1;
        // int ans=1;
        // Arrays.sort(nums);
        // for(int i=1;i<nums.length;i++){
        //     if(nums[i]==nums[i-1]){
        //         continue;
        //     }
        //     else if(nums[i]==nums[i-1]+1){
        //         l++;
        //         ans=Math.max(ans,l);
        //     }
        //     else{
        //         l=1;
        //     }
        // }
        // return ans;


        HashSet<Integer> st=new HashSet<>();
        for(int i:nums){
            st.add(i);
        }
        int ans=0;
        for(int i=0;i<nums.length;i++){

            if(!st.contains(nums[i]-1)){
                int c=0;
                int key=nums[i];
                while(st.contains(key)){
                    st.remove(key);
                    c++;
                    key++;
                }
                ans=Math.max(ans,c);
            }
        }
        return ans;
    }
}