class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // Arrays.sort(nums1);
        // Arrays.sort(nums2);
        // ArrayList<Integer> ans=new ArrayList<>();
        // int i=0;
        // int j=0;
        // while(i<nums1.length && j<nums2.length){
        //     if(nums1[i]==nums2[j]){
        //         ans.add(nums1[i]);
        //         i++;
        //         j++;
        //     }
        //     else if(nums1[i]<nums2[j]){
        //         i++;
        //     }
        //     else if(nums1[i]>nums2[j]){
        //         j++;
        //     }
        // }
        // HashSet<Integer> ll=new HashSet<>(ans);
        // int[] arr=new int[ll.size()];
        // int k=0;
        // for(int n:ll){
        //     arr[k++]=n;
        // }
        // return arr;
        HashSet<Integer> st = new HashSet<>();
        for (int x : nums1) {
            st.add(x);
        }
        HashSet<Integer> ll = new HashSet<>();
        for (int x : nums2) {
            if (st.contains(x)) {
                ll.add(x);
            }
        }
        int[] res = new int[ll.size()];
        int i=0;
        for (int x:ll) {
            res[i++] = x;
        }
        return res;
    }
}