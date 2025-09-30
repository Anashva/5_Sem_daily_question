// class Solution {
//     public boolean checkInclusion(String s1, String s2) {
//         // TC = O(n+m)
//         // SC=O(1)
//         if(s2.length()<s1.length()){
//             return false;
//         }
//         int[]  freq1=new int[26];
//         for(int i=0;i<s1.length();i++){
//             freq1[s1.charAt(i)-'a']++;
//         }
//         for(int i=0;i<=s2.length()-s1.length();i++){
//             String s=s2.substring(i,i+s1.length());
//             int[] freq2=new int[26];
//             for(int j=0;j<s.length();j++){
//                 freq2[s.charAt(j)-'a']++;
//             }
//             if(permute(freq1,freq2)){
//                 return true;
//             }
//         }
//         return false;
//     }
//     public boolean permute(int[] freq1,int[] freq2){
//         for(int i=0;i<26;i++){
//             if(freq1[i]<freq2[i]){
//                 return false;
//             }
//         }
//         return true;
//     }
// }


class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // TC = O(n+m)
        // SC=O(1)
        if(s2.length()<s1.length()){
            return false;
        }
        int[]  freq1=new int[26];
        for(int i=0;i<s1.length();i++){
            freq1[s1.charAt(i)-'a']++;
        }
        for(int i=0;i<=s2.length()-s1.length();i++){
            String s=s2.substring(i,i+s1.length());
            int[] freq2=new int[26];
            for(int j=0;j<s.length();j++){
                freq2[s.charAt(j)-'a']++;
            }
            if(permute(freq1,freq2)){
                return true;
            }
        }
        return false;
    }
    public boolean permute(int[] freq1,int[] freq2){
        for(int i=0;i<26;i++){
            if(freq1[i]<freq2[i]){
                return false;
            }
        }
        return true;
    }
}