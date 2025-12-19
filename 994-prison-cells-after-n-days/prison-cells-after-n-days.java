class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        for(n=(n-1)%14+1;n>0;n--){
            int[] ans=new int[8];
            for(int i=1;i<7;i++){
                ans[i]= cells[i-1]==cells[i+1] ? 1:0;
            }
            cells=ans;
        }
        return cells;
    }
}