class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> pq=new PriorityQueue<>((a, b) -> {
            if (a.length() != b.length()) return b.length() - a.length();
            return b.compareTo(a);
        });
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }
        String ans="";
        while(k-->0){
            ans=pq.poll();
        }
        return ans;
    }
}