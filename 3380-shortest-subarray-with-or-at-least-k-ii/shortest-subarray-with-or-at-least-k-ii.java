class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int ans=Integer.MAX_VALUE;
        int start=0;
        int end=0;
        int [] bit=new int[32];
        while(end<nums.length){
            addbit(bit,nums[end],1);
            while(start<=end && count(bit)>=k){
                ans=Math.min(ans,end-start+1);
                addbit(bit,nums[start],-1);
                start++;
                
            }
            end++;
        }
        return ans==Integer.MAX_VALUE ? -1 : ans;
    }
    public void addbit(int[] bit,int end,int n){
        for(int i=0;i<32;i++){
            if(((end>> i) &1)!=0){
                bit[i]+=n;
            }
        }
    }
    public int count(int[]bit){
        int ans=0;
        for(int i=0;i<32;i++){
            if(bit[i]!=0){
                ans|=1<<i;
            }
        }
        return ans;
    }
}