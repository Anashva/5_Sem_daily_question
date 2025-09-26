class Solution {
    public int maxSubarraySumCircular(int[] arr) {
        // return Maxmum(nums);
        int totalsum=0;
        for(int i=0;i<arr.length;i++){
            totalsum+=arr[i];
        }
        int min=minimum(arr);
        int max=maximum(arr);
        if(totalsum==min){
            return max;
        }
        return Math.max(max,totalsum-min);
    }
    public int maximum(int[] arr){
        int min=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            min=Math.max(sum,min);
            if(sum<0){
                sum=0;
            }
        }
        return min;
    }
    public int minimum(int[] arr){
        int min=Integer.MAX_VALUE;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            min=Math.min(sum,min);
            if(sum>0){
                sum=0;
            }
        }
        return min;
    }




















    // public static int Maxmum(int[] arr){
    //     int linear=kedense(arr);
    //     int sum=0;
    //     for(int i=0;i<arr.length;i++){
    //         sum+=arr[i];
    //         arr[i]=arr[i]* -1;
    //     }
    //     int mid=kedense(arr);
    //     int cs=sum+mid;//circular sum
    //     if(cs==0){
    //         return linear;
    //     }
    //     return Math.max(cs,linear);

    // }
    // public static int kedense(int[] arr){
    //     int s=0;
    //     int ans=Integer.MIN_VALUE;
    //     for(int i=0;i<arr.length;i++){
    //         s=s+arr[i];
    //         ans=Math.max(ans,s);
    //         if(s<0){
    //             s=0;
    //         }
    //     }
    //     return ans;
    // }
}