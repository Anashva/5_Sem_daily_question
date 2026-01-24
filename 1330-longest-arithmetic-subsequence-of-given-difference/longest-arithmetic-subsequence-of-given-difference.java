// class Solution {
//     public int longestSubsequence(int[] arr, int difference) {
//         int n = arr.length;
//         int[][] dp = new int[n][n + 1];
//         for (int[] row : dp) {
//             Arrays.fill(row, -1);
//         }
//         return subs(arr, 0, -1, difference, dp);
//     }

//     public int subs(int[] arr, int idx, int prevIdx, int diff, int[][] dp) {
//         if (idx == arr.length) {
//             return 0;
//         }

//         if (dp[idx][prevIdx + 1] != -1) {
//             return dp[idx][prevIdx + 1];
//         }

//         int take = 0;
//         int skip;

//         if (prevIdx == -1 || arr[idx] - arr[prevIdx] == diff) {
//             take = 1 + subs(arr, idx + 1, idx, diff, dp);
//         }

//         skip = subs(arr, idx + 1, prevIdx, diff, dp);

//         return dp[idx][prevIdx + 1] = Math.max(take, skip);
//     }
// }



class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        mp.put(arr[0],1);
        int ans=1;
        for(int i=1;i<arr.length;i++){
            int val=arr[i]-difference;
            if(mp.containsKey(val)){
                mp.put(arr[i],mp.get(val)+1);
            }
            else{
                mp.put(arr[i],1);
            }
        }
        for(int k:mp.keySet()){
            ans=Math.max(ans,mp.get(k));
        }
        return ans;
    }
}
