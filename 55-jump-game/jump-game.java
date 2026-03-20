class Solution {
    public boolean canJump(int[] nums) {
        Boolean[] dp = new Boolean[nums.length];
        return jump(0, nums, dp);
    }

    public boolean jump(int idx, int[] arr, Boolean[] dp) {
        if (idx >= arr.length - 1) {
            return true;
        }

        if (dp[idx] != null){
             return dp[idx];
        }
        int mn = arr[idx];
        for (int i = 1; i <= mn; i++) {
            if (idx + i < arr.length && jump(idx + i, arr, dp)) {
                return dp[idx] = true;
            }
        }

        return dp[idx] = false;
    }
}