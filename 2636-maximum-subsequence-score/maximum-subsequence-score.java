class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        long ans=0;
        int[][] arr=new int[nums1.length][2];
        for(int i=0;i<nums1.length;i++){
            arr[i][0]=nums1[i];
            arr[i][1]=nums2[i];
        }
        Arrays.sort(arr,(a,b)->b[1]-a[1]);
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        long sum=0;
        for(int i=0;i<k;i++){
            sum+=arr[i][0];
            pq.add(arr[i][0]);
        }
        ans=sum*arr[k-1][1];
        for(int i=k;i<nums1.length;i++){
           pq.add(arr[i][0]);
           if(pq.size()>k){
            sum+=arr[i][0]-pq.poll();
           } 
           ans=Math.max(ans,sum*arr[i][1]);
        }
        return ans;
    }
}