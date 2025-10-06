class Solution {
    int ans=0;
    public int countArrangement(int n) {
        int[] visit=new int[n+1];
        ans=0;
        count(visit,n,1);
        return ans;
    }
    public void count(int[]visit,int n,int per){
        if(per>n){
            ans++;
            return;
        }
        for(int i=1;i<=n;i++){
            if(visit[i]==0 && ( i%per==0 || per%i==0)){
                visit[i]=1;
                count(visit,n,per+1);
                visit[i]=0;
            }
        }
    }
}