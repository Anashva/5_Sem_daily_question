class Solution {
    public int[][] rangeAddQueries(int n, int[][] q) {
        int[][] arr=new int[n][n];
        for(int i=0;i<q.length;i++){
            int r1=q[i][0];
            int c1=q[i][1];
            int r2=q[i][2];
            int c2=q[i][3];
            arr[r1][c1]+=1;
            if(c2+1<n){
                arr[r1][c2+1]-=1;
            }
            if(r2+1<n){
                arr[r2+1][c1]-=1;
            }
            if(r2+1<n && c2+1<n){
                arr[r2+1][c2+1]+=1;
            }
           
        }
        for(int i=0;i<n;i++){
            for(int j=1;j<n;j++){
                arr[i][j]+=arr[i][j-1];
            }
        }
        for(int j=0;j<n;j++){
            for(int i=1;i<n;i++){
                arr[i][j]+=arr[i-1][j];
            }
        }
        return arr;
    }
}