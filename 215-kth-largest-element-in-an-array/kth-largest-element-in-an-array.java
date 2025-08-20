class Solution {
    public int findKthLargest(int[] arr, int k) {
        // Arrays.sort(nums);
        // int i=0;
        // int j=nums.length-1;
        // while(i<j){
        //     int t=nums[i];
        //     nums[i]=nums[j];
        //     nums[j]=t;
        //     i++;
        //     j--;
        // }
        // return nums[k-1]; 
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<k;i++){
            pq.add(arr[i]);
        }  
        for(int i=k;i<arr.length;i++){
            if(arr[i]>pq.peek()){
                pq.poll();
                pq.add(arr[i]);
            }
        }
        return pq.peek();
    }
}