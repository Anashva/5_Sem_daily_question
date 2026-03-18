class Solution {
    public boolean isIsomorphic(String s, String t) {
        // HashMap<Character,Character> ll=new HashMap<>();
        // HashMap<Character,Character> st=new HashMap<>();
        // for(int i=0;i<s.length();i++){
        //     char ch1=s.charAt(i);
        //     char ch2=t.charAt(i);
        //     if(ll.containsKey(ch1)){
        //         if(ll.get(ch1)!=ch2){
        //             return false;
        //         }
        //     }
        //     if(st.containsKey(ch2)){
        //         if(st.get(ch2)!=ch1){
        //             return false;
        //         }
        //     }
        //     ll.put(ch1,ch2);
        //     st.put(ch2,ch1);
        // }
        int[] arr=new int[512];
        for(int i=0;i<s.length();i++){
            if(arr[s.charAt(i)]!=arr[t.charAt(i)+256]){
                return false;
            }
            arr[s.charAt(i)]=arr[t.charAt(i)+256]=i+1;
        }
        return true;
    }
}