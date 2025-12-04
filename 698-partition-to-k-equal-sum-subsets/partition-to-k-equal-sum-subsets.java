class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total=0;
        for(int i=0;i<nums.length;i++){
            total+=nums[i];
        }
        if(total%k!=0){
            return false;
        }
        int sum=total/k;
        boolean[] visit=new boolean[nums.length];
        return partition(nums,0,sum,0,visit,k);
    }
    public boolean partition(int [] nums,int idx,int total,int sum,boolean[] visit,int k){
        if(k==1){
            return true;
        }
        if(sum==total){
            return partition(nums,0,total,0,visit,k-1);
        }
        for(int i=idx;i<nums.length;i++){
            if(visit[i]){
                continue;
            }
            if(sum+nums[i]<=total){
                visit[i]=true;
                if(partition(nums,i+1,total,sum+nums[i],visit,k)){
                    return true;
                }
                visit[i]=false;
            }
        }
        return false;
    }
}