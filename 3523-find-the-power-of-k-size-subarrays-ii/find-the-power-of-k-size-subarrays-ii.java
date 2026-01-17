class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n=nums.length;
        int[] ans=new int[n-k+1];
        int end=0;
        int start=0;
        int c=-1;
        while(end<n){
            if(end>0 && nums[end]!=nums[end-1]+1){
                c=end;
            }
            if(end-start+1==k){
                if(c>start){
                    ans[start]=-1;
                }
                else{
                    ans[start]=nums[end];
                }
                start++;
            }
            end++;
        }
        return ans;
    }
}