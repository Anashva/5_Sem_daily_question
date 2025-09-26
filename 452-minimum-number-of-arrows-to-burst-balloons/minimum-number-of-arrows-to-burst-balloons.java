class Solution {
    public int findMinArrowShots(int[][] arr) {
        Arrays.sort(arr,(a, b) -> Integer.compare(a[1], b[1]));
        int arrow = 1;
        int pos = arr[0][1];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i][0] > pos) {
                arrow++;
                pos = arr[i][1];
            }
        }
        return arrow;
    }
}