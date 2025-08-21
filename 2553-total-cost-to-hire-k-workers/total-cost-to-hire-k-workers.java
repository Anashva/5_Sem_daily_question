class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> left=new PriorityQueue<>();
        PriorityQueue<Integer> right=new PriorityQueue<>();
        int si=0;
        int ei=costs.length-1;
        for(int i=0;i<candidates && si<=ei;i++){
            left.add(costs[si++]);
        }

        for(int i=0;i<candidates && si<=ei;i++){
            right.add(costs[ei--]);
        }
        long ans=0;
        while(k-->0){
            if(!left.isEmpty() && (right.isEmpty() || left.peek() <= right.peek())){
                ans+=left.poll();
                if (si <= ei) {
                    left.add(costs[si++]);
                }
            }
            else{
                ans+=right.poll();
                if (si <= ei) {
                    right.add(costs[ei--]);
                }
            }
        }
        return ans;

    }
}