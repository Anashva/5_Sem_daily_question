class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int ans=0;
        for(int i:nums){
            pq.add(i);
        }
        while(k-->0){
            pq.add(-pq.poll());
        }
        for(int i=0;i<nums.length;i++){
            ans+=pq.poll();
        }
        return ans;
    }
}