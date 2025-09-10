class Solution {
    public boolean canReach(int[] arr, int start) {
        if(arr[start]==0){
            return true;
        }
        boolean [] visit=new boolean[arr.length];
        return reach(arr,start,visit);
    }
    public boolean reach(int[] arr,int i,boolean[] visit){
        if(i<0 || i>=arr.length || visit[i]){
            return false;
        }

        if(arr[i]==0){
            return true;
        }
        visit[i]=true;
        boolean l=reach(arr,i-arr[i],visit);
        boolean r=reach(arr,i+arr[i],visit);
        return l || r;

    }
}