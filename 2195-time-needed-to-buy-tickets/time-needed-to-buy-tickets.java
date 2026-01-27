class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<tickets.length;i++){
            q.add(new int[]{i,tickets[i]});
        }
        int c=0;
        int ans=0;
        while(!q.isEmpty()){
            int[] r=q.poll();
            ans++;
            r[1]--;
            if(r[1]==0){
                if(r[0]==k){
                    return ans;
                }
            }
            else{
                q.add(r);
            }
        }
        return ans;
    }
}