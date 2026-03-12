class Solution {
    unordered_map<string, int> dp;
public:
    int countSequences(vector<int>& nums, long long k) {
        return solve(nums, k, 1, 1, 0);
    }

    int solve(vector<int>& nums, long long k, long long num, long long den, int idx) {
        if (idx == nums.size()) { 
            if (num<k || num<den){
                return 0;
            } 
            return (num == k * den);
        }
        long long g = std::gcd(num, den);
        num /= g; den /= g;

        string key = to_string(num) + "," + to_string(den) + "," + to_string(idx);
        if (dp.count(key)) {
            return dp[key];
        }

        int count = solve(nums, k, num * nums[idx], den, idx + 1);
        count += solve(nums, k, num, den * nums[idx], idx + 1);
        count += solve(nums, k, num, den, idx + 1);

        return dp[key] = count;
    }
};