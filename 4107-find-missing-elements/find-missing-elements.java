class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min=100;
        int max=1;
        List<Integer> ll=new ArrayList<>();
        HashSet<Integer> st=new HashSet<>();
        for(int i:nums){
            st.add(i);
            max=Math.max(max,i);
            min=Math.min(min,i);
        }
        for(int i=min;i<=max;i++){
            if(!st.contains(i)){
                ll.add(i);
            }
        }
        return ll;
    }
}