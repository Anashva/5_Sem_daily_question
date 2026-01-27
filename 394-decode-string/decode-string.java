class Solution {
    public String decodeString(String s) {
        Stack<Integer> st=new Stack<>();
        Stack<StringBuilder> ans=new Stack();
        StringBuilder sb=new StringBuilder();
        int n=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='['){
                st.push(n);
                n=0;
                ans.push(sb);
                sb=new StringBuilder();
            }
            else if(s.charAt(i)==']'){
                int k=st.pop();
                StringBuilder t=sb;
                sb=ans.pop();
                while(k-->0){
                    sb.append(t);
                }
            }
            else if(Character.isDigit(s.charAt(i))){
                n=n*10+(s.charAt(i)-'0');
            }
            else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}