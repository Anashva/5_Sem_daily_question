class Solution {
    public int distinctPrimeFactors(int[] nums) {
        HashSet<Integer> st=new HashSet<>();
        for(int j:nums){
            int n=j;
            while (n % 2 == 0) {
                st.add(2);
                n /= 2;
            }
            for (int i = 3; i * i <= n; i += 2) {
                while (n % i == 0) {
                st.add(i);
                n /= i;
                }
            }
            if(n>2){
                st.add(n);
            }
        }
        return st.size();
    }
}