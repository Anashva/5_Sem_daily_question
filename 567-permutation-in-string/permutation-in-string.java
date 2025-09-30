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
        if(s1.length() > s2.length()) {
            return false;
        }
        int k = s1.length();
        int[] freq = new int[26];
        for(char c: s1.toCharArray()) {
            freq[c-'a']++;
        }
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < 26; i++) {
            str.append(freq[i]).append('/');
        }
        s1 = str.toString();
        str.setLength(0);
        Arrays.fill(freq, 0);
        for(int i = 0; i < k; i++) {
            freq[s2.charAt(i)-'a']++;
        }
        for(int i = 0; i < 26; i++) {
            str.append(freq[i]).append('/');
        }
        String s = str.toString();
        if(s.equals(s1)) {
            return true;
        }
        str.setLength(0);
        for(int i = k; i < s2.length(); i++) {
            freq[s2.charAt(i)-'a']++;
            freq[s2.charAt(i-k)-'a']--;
            for(int j = 0; j < 26; j++) {
                str.append(freq[j]).append('/');
            }
            s = str.toString();
            if(s.equals(s1)) {
                return true;
            }
            str.setLength(0);
        }
        return false;
    }
}