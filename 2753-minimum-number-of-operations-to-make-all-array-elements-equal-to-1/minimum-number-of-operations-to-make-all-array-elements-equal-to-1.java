class Solution {
    public int minOperations(int[] nums) {
        int one=0;
        for(int i:nums){
            if(i==1){
                one++;
            }
        }
        if(one>0){
            return nums.length-one;
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            int a=nums[i];
            for(int j=i+1;j<nums.length;j++){
                a=gcd(a,nums[j]);
                if(a==1){
                    ans=Math.min(ans,j-i);
                    break;
                }
            }
        }
        if(ans==Integer.MAX_VALUE){
            return -1;
        }
        return ans+nums.length-1;
    }
    public int gcd(int a,int b){
        while(b!=0){
            int t=b;
            b=a%b;
            a=t;
        }
        return a;
    }
}