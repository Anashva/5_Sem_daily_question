class Solution {
    public int maximumScore(int a, int b, int c) {
        int ans=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        pq.add(a);
        pq.add(b);
        pq.add(c);
        while(pq.size()>1){
            int p1=pq.poll();
            p1--;
            int p2=pq.poll();
            p2--;
            ans++;
            if(p1>0){
                pq.add(p1);

            }
            if(p2>0){
                pq.add(p2);
            }
        }
        return ans;
    }
}