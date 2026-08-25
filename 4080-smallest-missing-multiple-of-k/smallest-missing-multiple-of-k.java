class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Long> st=new HashSet<>();
        for(int i:nums){
            st.add((long)i);
        }
        long ans = k;
        long mul = 1;
        while(st.contains(ans*mul)) {
            mul++;
        }
        return (int)(ans*mul);
    }
}