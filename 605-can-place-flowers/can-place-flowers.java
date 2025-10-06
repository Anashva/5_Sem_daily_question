class Solution {
    public boolean canPlaceFlowers(int[] arr, int n) {
        int c=0;
        for(int i=0;i<arr.length;i++){     
            if (arr[i] == 0) {
                if ((i == 0 || arr[i - 1] == 0) && (i == arr.length - 1 || arr[i + 1] == 0)) {
                    arr[i] = 1; 
                    c++;
                }
            }
        }
        return c>=n;
    }
}