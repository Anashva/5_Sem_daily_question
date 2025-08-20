class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq=new PriorityQueue<>(
    (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        for(int i=0;i<nums.length;i++){
            pq.add(new int[]{nums[i],i});
        }
        while(k-->0){
            int[] arr=pq.poll();
            int idx=arr[1];
            nums[idx]=multiplier*nums[idx];
            pq.add(new int[]{nums[idx],idx});
        }
        return nums;
        
    }
}