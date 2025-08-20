class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq=new PriorityQueue<>();
        for(int i:nums){
            pq.add((long)i);
        }
        int ans=0;
        while(pq.peek()<k){
            long x=pq.poll();
            long y=pq.poll();
            pq.add(Math.min(x,y)*2+Math.max(x,y));
            ans++;
        }
        return ans;
    }
}