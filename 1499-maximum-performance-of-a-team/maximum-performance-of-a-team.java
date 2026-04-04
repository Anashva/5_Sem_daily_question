class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        long  ans=0;
        int mod=1000000007;
        int[][] arr=new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=speed[i];
            arr[i][1]=efficiency[i];
        }

        Arrays.sort(arr,(a,b)->{
            if(a[1]!=b[1]){
                return b[1]-a[1];
            }
            return b[0]-a[0];
        });
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        long total=0;
        for(int i=0;i<n;i++){
            int s=arr[i][0];
            int eff=arr[i][1];
            pq.add(s);
            total+=s;
            if(pq.size()>k){
                total-=pq.poll();
            }
            ans=Math.max(ans,total*eff);
        }
        return (int)(ans % mod);
    }
}