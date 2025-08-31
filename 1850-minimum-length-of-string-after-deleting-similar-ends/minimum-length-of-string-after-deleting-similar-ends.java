class Solution {
    public int minimumLength(String s) {
        if(s.length()==1){
            return 1;
        }
        if(s.charAt(0)!=s.charAt(s.length()-1)){
            return s.length();
        }

        StringBuilder sb=new StringBuilder(s);
        int i=0;
        int j=sb.length()-1;
        while(i<j && sb.charAt(i)==sb.charAt(j)){
            char ch=sb.charAt(i);
           while(i<=j && sb.charAt(i)==ch){
            sb.deleteCharAt(i);
            j--;
           }

           while(j>=i && sb.charAt(j)==ch){
            sb.deleteCharAt(j);
            j--;
           }
           i=0;
           j=sb.length()-1;
        }
        return sb.length();
    }
}