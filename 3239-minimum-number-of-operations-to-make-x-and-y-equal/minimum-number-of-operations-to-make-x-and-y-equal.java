class Solution {
    public int minimumOperationsToMakeEqual(int x, int y) {
        if(x==y){
            return 0;
        }
        return operation(x,y);
    }
    public int operation(int x,int y){
        if(x<=y){
            return y-x;
        }
        int ans=x-y;
        ans=Math.min(ans,operation(x/5,y)+1+x%5);
        ans=Math.min(ans,operation(x/5+1,y)+1+5-x%5);
        ans=Math.min(ans,operation(x/11,y)+1+x%11);
        ans=Math.min(ans,operation(x/11+1,y)+1+11-x%11);
        return ans;
    }
}