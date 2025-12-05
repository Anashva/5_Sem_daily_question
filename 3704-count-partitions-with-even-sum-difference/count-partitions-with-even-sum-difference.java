class Solution {
    public int countPartitions(int[] nums) {
        int ans=0;
        int m=0;
        int s=0;
        for(int i=0;i<nums.length;i++){
            m+=nums[i];
        }
        for(int i=0;i<nums.length-1;i++){
            s+=nums[i];
            for(int j=i;j<nums.length;j++){
                m-=nums[j];
                int k=Math.abs(m-s);
                if(k%2==0){
                    ans++;
                }
                break;
            }
        }
        return ans;
    }
}