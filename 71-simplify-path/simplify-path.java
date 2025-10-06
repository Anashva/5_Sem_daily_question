class Solution {
    public String simplifyPath(String path) {
        String[] s=path.split("/");
        Stack<String> st=new Stack<>();
        int c=0;
        for(int i=s.length-1;i>=0;i--){
            String dir = s[i];
            if(dir.equals(".") || dir.equals("")){
                continue;
            }
            else if(dir.equals("..")){
                c++;
            }
            else{
                if(c>0){
                    c--;
                }
                else{
                    st.push(dir);
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append("/").append(st.pop());
        }
        return sb.length()==0 ? "/" :sb.toString();

    }
}