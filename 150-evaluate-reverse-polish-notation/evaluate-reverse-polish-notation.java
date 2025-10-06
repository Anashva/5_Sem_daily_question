class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<tokens.length;i++){
            String s=tokens[i];
            if(s.equals("+")){
                int v2=st.pop();
                int v1=st.pop();
                st.push(v1+v2);
            }
            else if(s.equals("-")){
                int v2=st.pop();
                int v1=st.pop();
                st.push(v1-v2);
            }
            else if(s.equals("*")){
                int v2=st.pop();
                int v1=st.pop();
                st.push(v1*v2);
            }
            else if(s.equals("/")){
                int v2=st.pop();
                int v1=st.pop();
                st.push(v1/v2);
            }
            else{
                int n=Integer.parseInt(tokens[i]);
                st.push(n);
            }
        }
        return st.pop();
    }
}