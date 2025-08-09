class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long l=Long.MAX_VALUE;
        long h=0;
        for(int i:time){
            l=Math.min(l,i);
        }
        h=l*totalTrips;
        while(l<=h){
            long mid=l+(h-l)/2;
            if(possible(time,mid,totalTrips)){
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }
    public boolean possible(int[] nums,long mid,int total){
        long sum=0;
        for(int i:nums){
            sum+=mid/i;
        }
        if(sum>=total){
            return true;
        }
        return false;
    }
}