class Solution {
    int MAX = 200000;
    boolean[] prime;
    public int minOperations(int[] nums) {
        int ans = 0;
        seive();

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];

            if (i % 2 == 0) {
                while (!prime[x]) {
                    x++;
                    ans++;
                }
            } else {
                while (prime[x]) {
                    x++;
                    ans++;
                }
            }
        }
        return ans;
    }

    public void seive() {
        prime = new boolean[MAX + 1];
        Arrays.fill(prime, true);

        prime[0] = false;
        prime[1] = false;

        for (int i = 2; i * i <= MAX; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    prime[j] = false;
                }
            }
        }
    }
}