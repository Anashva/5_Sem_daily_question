class Solution {
    public long maxSum(int[][] grid, int[] limits, int k) {
        long ans=0;
        PriorityQueue<Integer> p=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<grid.length;i++){
            PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
            for(int j=0;j<grid[0].length;j++){
                pq.add(grid[i][j]);
            }
            int c=limits[i];
            while(!pq.isEmpty() && c-->0){
                p.add(pq.poll());
            }
        }
        while(!p.isEmpty() && k-->0){
            ans+=p.poll();
        }
        return ans;

    }
}