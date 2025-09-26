class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int start = 0, end = 0, ans = 0;

        while (end < fruits.length) {
            mp.put(fruits[end], mp.getOrDefault(fruits[end], 0) + 1);
            while (mp.size() > 2) {
                mp.put(fruits[start], mp.get(fruits[start]) - 1);
                if (mp.get(fruits[start]) == 0) {
                    mp.remove(fruits[start]);
                }
                start++;
            }

            ans = Math.max(ans, end - start + 1);
            end++;
        }

        return ans;
    }
}