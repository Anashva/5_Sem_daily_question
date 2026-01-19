class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(!st.isEmpty()){
                 if((s.charAt(i)==')' && st.peek()=='(') || (s.charAt(i)==']' && st.peek()=='[') || (s.charAt(i)=='}' && st.peek()=='{')){
                     st.pop();
                     continue;
                 }
            }
            
                st.push(s.charAt(i));
            
        }
        return st.isEmpty();
    }
}