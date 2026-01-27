class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length()==k){
            return "0";
        }
        Stack<Character> st=new Stack<>();
        for(int i=0;i<num.length();i++){
            while(!st.isEmpty() && st.peek()>num.charAt(i) && k>0){
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty() && k-->0){
            st.pop();
        }
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        while(sb.length()>0 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        return sb.length()==0 ?"0" :sb.toString();
    }
}