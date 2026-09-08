class Solution {
public:
    int countCommas(int n) {
        long long ans = 0;

        vector<long long> arr = {
            1000LL,
            1000000LL,
            1000000000LL
        };

        for (int i = 0; i < arr.size(); i++) {
            if (n >= arr[i]) {
                long long range = min((long long)n, arr[i] * 1000 - 1);

                ans += (range - arr[i] + 1) * (i + 1);
            }
        }

        return (int)ans;
    }
};