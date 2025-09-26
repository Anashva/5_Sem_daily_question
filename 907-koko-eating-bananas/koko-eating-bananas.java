class Solution {
    public int minEatingSpeed(int[] arr, int h) {
        int l=1;
        int hi=0;
        for(int i:arr){
            hi=Math.max(hi,i);
        }
        int ans=hi;
        while(l<=hi){
            int mid=l+(hi-l)/2;
            if(possible(arr,mid,h)){
                ans=mid;
                hi=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
    public boolean possible(int[] arr,int item,int h){
        long sum=0;
        for(int i:arr){
            sum+=(long)(i+item-1)/(long)item;
        }
        if(sum<=h){
            return true;
        }
        return false;
    }

} 
