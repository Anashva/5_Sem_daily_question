class Solution {
    public int minTaps(int n, int[] ranges) {
        int[][] arr=new int[ranges.length][2];
        for(int i=0;i<ranges.length;i++){
            arr[i][0]=Math.max(0,i-ranges[i]);
            arr[i][1]=Math.min(n,i+ranges[i]);
        }
        Arrays.sort(arr,(a,b)->Integer.compare(a[0],b[0]));
        int start=0;
        int end=0;
        int ans=0;
        int max=0;
        while(end<n){
            while(start<arr.length && arr[start][0]<=end){
                max=Math.max(max,arr[start][1]);
                start++;
            }
            if(max==end){
                return -1;
            }
            ans++;
            end=max;
        }
        return ans;
    }
}