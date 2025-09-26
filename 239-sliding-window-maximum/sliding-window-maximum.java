class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len=nums.length;
        int n=len-k+1;
        int [] arr=new int[n];
        // int idx=0;
        // for(int i=0;i<=len-k;i++){
        //     PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        //     for(int j=i;j<i+k;j++){
        //         pq.add(nums[j]);
        //     }
        //     arr[idx++]=pq.poll();
        //     pq.clear();
        // }
        // return arr;


        Deque<Integer> pq=new ArrayDeque<>();//decreasing order me value ko store karega
        for (int i = 0; i < k; i++) {
             while (!pq.isEmpty() && nums[i] >= nums[pq.peekLast()]) 
             {
                pq.pollLast();
             }
             pq.offerLast(i);
        }
        arr[0] = nums[pq.peekFirst()];
        for(int i=k;i<nums.length;i++){
            if(!pq.isEmpty() && pq.peekFirst()<=i-k){
                pq.removeFirst();//condition for index out of window true then remove from starting of queue
            }
            while(!pq.isEmpty() && nums[i]>nums[pq.peekLast()]){
                pq.removeLast();//agr hamra last element chota h current se to remove kr denge
            }
            pq.addLast(i);
            arr[i-k+1]=nums[pq.peekFirst()];
        }
        return arr;

    }

}