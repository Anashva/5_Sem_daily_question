class Solution {
    int mod=1000000007;
    HashMap<String,Integer> mp;
    Integer[][] dp;
    public int countSpecialSubsequences(int[] nums) {
        if(nums.length<3){
            return 0;
        }
        // mp=new HashMap<>();
        dp=new Integer[nums.length][4];
        return count(nums,0,-1);
    }
    public int count(int[] nums,int idx,int prev){
        if(idx==nums.length){
            return prev==2 ? 1:0;
        }
        if(dp[idx][prev+1]!=null){
            return dp[idx][prev+1];
        }
        int take=0;
        if(prev==-1){
            if(nums[idx]==0){
                take=(take+count(nums,idx+1,0))%mod;
            }
        }
        else if(prev==0){
            if(nums[idx]==0 || nums[idx]==1){
                take=(take+count(nums,idx+1,nums[idx]))%mod;
            }
        }
        else if(prev==1){
            if(nums[idx]==1 || nums[idx]==2){
                take=(take+count(nums,idx+1,nums[idx]))%mod;
            }
        }
        else if(prev==2){
            if(nums[idx]==2){
                take=(take+count(nums,idx+1,2))%mod;
            }
        }
        int skip=count(nums,idx+1,prev)%mod;

        
        return dp[idx][prev+1]=(skip+take)%mod;

    }
}