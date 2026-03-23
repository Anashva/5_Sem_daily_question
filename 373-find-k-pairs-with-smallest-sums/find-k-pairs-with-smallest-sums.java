class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ll=new ArrayList<>();
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(nums1[a[0]]+nums2[a[1]])-(nums1[b[0]]+nums2[b[1]]));
        int n=k;
        for(int i=0;i<nums1.length && n-->0;i++){
            pq.add(new int[]{i,0});
        }
        while(!pq.isEmpty() && k-->0){
            int[] rp=pq.poll();
            int i=rp[0];
            int j=rp[1];
            ll.add(Arrays.asList(nums1[i],nums2[j]));
            if(j+1<nums2.length){
                pq.add(new int[]{i,j+1});
            }
        }
        return ll;
    }
}