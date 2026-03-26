class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        HashSet<Integer> res=new  HashSet<>();
        // for(int i=0;i<arr.length;i++){
        //     int xor=0;
        //     // st.add(arr[i]);
        //     for(int j=i;j<arr.length;j++){
        //         xor|=arr[j];
        //         st.add(xor);
        //     }
            
        // }
        HashSet<Integer> sub=new HashSet<>();
        for(int x:arr){
            HashSet<Integer> curr=new HashSet<>();
            curr.add(x);
            for(int v:sub){
                curr.add(v|x);
            }
            res.addAll(curr);
            sub=curr;
        }
        return res.size();
    }
}