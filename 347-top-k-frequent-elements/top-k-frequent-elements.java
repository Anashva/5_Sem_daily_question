class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length==k){
            return nums;
        }
        // Arrays.sort(nums);
        int[] ans=new int[k];
        HashMap<Integer,Integer>  mp=new HashMap<>();
        for(int n:nums){
            mp.put(n,mp.getOrDefault(n,0)+1);
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)-> mp.get(b)-mp.get(a));
        for (Integer key : mp.keySet()){
            pq.add(key);
        }
        for(int i=0;i<k && (!pq.isEmpty());i++){
            ans[i]=pq.poll();
        }
        return ans;
    }
    
}