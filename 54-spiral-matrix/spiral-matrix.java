class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m=matrix[0].length;
        int n=matrix.length;
        int minr=0;
        int minc=0;
        int maxr=n-1;
        int maxc=m-1;
        int c=0;
        int t=m*n;
        while(c<t){
            for(int i=minc;i<=maxc && c<t;i++){
                ans.add(matrix[minr][i]);
                c++;
            }
            minr++;
            for(int i=minr;i<=maxr && c<t;i++){
                ans.add(matrix[i][maxc]);
                c++;
            }
            maxc--;
            for(int i=maxc;i>=minc && c<t;i--){
                ans.add(matrix[maxr][i]);    
                c++;
            }
            maxr--;
            for(int i=maxr;i>=minr && c<t;i--){
                ans.add(matrix[i][minc]);
                c++;
            }
            minc++;
        }
        return ans;
    }
}