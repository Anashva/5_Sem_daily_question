class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> st=new Stack<>();
        int[] index=new int[26];
        for(int i=0;i<s.length();i++){
            index[s.charAt(i)-'a']=i;
        }
        boolean[] visit=new boolean[26];
        for(int i=0;i<s.length();i++){
            while(!st.isEmpty() && st.peek()>s.charAt(i) && i<index[st.peek()-'a'] && !visit[s.charAt(i)-'a']){
                visit[st.pop()-'a']=false;
            }
            if(!visit[s.charAt(i)-'a']){
                st.push(s.charAt(i));
                visit[s.charAt(i)-'a']=true;
            }
            
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}