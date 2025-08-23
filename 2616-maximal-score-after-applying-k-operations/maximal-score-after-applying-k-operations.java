class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        long ans=0;
        for(int i:nums){
            pq.add(i);
        }
        while(k-->0){
            int val=pq.poll();
            ans+=val;
            pq.add((int)(Math.ceil((double)val/3)));
        }
        return ans;
    }
}