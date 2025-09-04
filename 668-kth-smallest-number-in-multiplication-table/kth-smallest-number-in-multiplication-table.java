class Solution {
    public int findKthNumber(int m, int n, int k) {
        int l=1;
        int h=m*n;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(count(mid,n,m)>=k){
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }
    public int count(int mid,int n,int m){
        int count=0;
        for(int i=1;i<=m;i++){
            count+= n< mid/i ? n :mid/i;
        }
        return count;
    }
}