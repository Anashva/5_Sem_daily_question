class Solution {
    public void duplicateZeros(int[] arr) {
        int[] num=new int[arr.length];
        int j=0;
        for(int i=0;i<arr.length && j<arr.length;i++){
            if(arr[i]==0){
                j=j+2;
            }
            else{
                num[j]=arr[i];
                j++;
            }
        }
        for(int i=0;i<arr.length;i++){
            arr[i]=num[i];
        }
    }
}