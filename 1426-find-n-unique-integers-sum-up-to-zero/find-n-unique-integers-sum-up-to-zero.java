class Solution {
    public int[] sumZero(int n) {
        int[] arr=new int[n];
        if(n%2==1){
            int i=0;
            int j=n-1;
            int k=n;
            while(i<j){
                arr[i]=k;
                arr[j]=-k;
                k--;
                i++;
                j--;
            }
        }
        else{
            int i=0;
            int j=n-1;
            int k=n;
            while(i<j){
                arr[i]=k;
                arr[j]=-k;
                k--;
                i++;
                j--;
            }
        }
        return arr;
    }
}