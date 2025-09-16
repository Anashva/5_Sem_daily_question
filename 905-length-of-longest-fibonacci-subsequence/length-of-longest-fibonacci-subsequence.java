class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int ans=0;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                int count=2;
                int a=arr[i];
                int b=arr[j];
                while(true){
                    int c=a+b;
                    int k=bs(arr,j+1,arr.length-1,c);
                    if(k==-1){
                        break;
                    }
                    count++;
                    ans=Math.max(count,ans);
                    a=b;
                    b=arr[k];
                }
            }
        }
        return ans;
    }
    public int bs(int[] arr,int l,int h,int target){
        while (l <= h) {
            int mid = (l + h) / 2;
            if (arr[mid] == target) 
            {
                return mid;
            }
            else if(arr[mid] < target) {
                l = mid + 1;
            }
            else 
            {
                h = mid - 1;
            }
        }
        return -1;
    }
}