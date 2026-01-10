class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if((long)m*k>bloomDay.length){
            return -1;
        }
        int l=Integer.MAX_VALUE;
        int h=Integer.MIN_VALUE;
        for(int v:bloomDay){
            l=Math.min(l,v);
            h=Math.max(h,v);
        }
        int ans=h;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(possible(mid,bloomDay,m,k)){
                ans=mid;
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
    public boolean possible(int mid,int[] bloomDay,int m ,int k){
        int count=0;
        int total=0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=mid){
                count++;
            }
            else{
                count=0;
            }
            if(count==k){
                total++;
                count=0;
            }
            if(total>=m){
                return true;
            }
        }
        return false;
    }
}