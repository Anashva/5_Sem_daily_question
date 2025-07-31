class Solution {
    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        long ans[] =new long[nums1.length];
        int[][] arr=new int[nums1.length][3];
        for(int i=0;i<nums1.length;i++){
            arr[i][0]=nums1[i];
            arr[i][1]=nums2[i];
            arr[i][2]=i;
        }
        Arrays.sort(arr,(a,b)->(a[0]-b[0]));
        long sum=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<nums1.length;i++){
            if(i>0 && arr[i][0]==arr[i-1][0]){
                ans[arr[i][2]]=ans[arr[i-1][2]];
            }
            else{
                ans[arr[i][2]]=sum;
            }
            pq.add(arr[i][1]);
            sum+=arr[i][1];
            if(pq.size()>k){
                sum-=pq.poll();
            }
        }
        return ans;
    }
}