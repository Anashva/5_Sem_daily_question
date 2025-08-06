class Solution {
    public int splitArray(int[] nums, int k) {
        int l=0;
        int h=0;
        for(int i:nums){
            l=Math.max(l,i);
            h+=i;
        }
        while(l<=h){
            int mid=l+(h-l)/2;
            if(possible(nums,k,mid)){
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }
    public boolean possible(int[] nums,int k,int mid){
        int c=1;
        int sum=0;
        for(int i:nums){
            // sum=sum+i;
            if(sum+i>mid){
                c++;
                sum=i;
                if(c>k){
                    return false;
                }
            }
            else{
                sum+=i;
            }

        }
        return true;
    }
}