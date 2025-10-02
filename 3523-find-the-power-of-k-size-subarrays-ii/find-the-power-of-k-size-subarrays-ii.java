class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n=nums.length;
        int[] ans=new int[n-k+1];
        int start=0;
        int end=0;
        int count=-1;
        while(end<n){
            if(end>0 && nums[end]!=nums[end-1]+1){
                count=end;
            }
            if(end-start+1==k){
                if(count>start){
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