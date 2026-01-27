class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q=new LinkedList<>();
        for(int i=1;i<=n;i++){
            q.add(i);
        }
        int c=0;
        while(q.size()>1){
            c++;
            int r=q.poll();
            if(c==k){
                // q.poll();
                c=0;
            }
            else{
                q.add(r);
            }
        }
        return q.peek();
    }
}