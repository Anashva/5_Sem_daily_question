class Solution {
    public String largestMerge(String word1, String word2) {
        StringBuilder sb=new StringBuilder();
        int i=0;
        int j=0;
        int n=word1.length();
        int m=word2.length();
        while(i<n && j<m){
            if(word1.charAt(i)>word2.charAt(j)){
                sb.append(word1.charAt(i));
                i++;
            }
            else if(word2.charAt(j)>word1.charAt(i)){
                sb.append(word2.charAt(j));
                j++;
            }
            else{
                if(word1.substring(i).compareTo(word2.substring(j))>=0){
                    sb.append(word1.charAt(i));
                    i++;
                }
                else{
                    sb.append(word2.charAt(j));
                    j++;
                }
            }
        }
        while(i<n){
            sb.append(word1.charAt(i));
            i++;
        }
         while(j<m){
            sb.append(word2.charAt(j));
            j++;
        }
        return sb.toString();
    }
}