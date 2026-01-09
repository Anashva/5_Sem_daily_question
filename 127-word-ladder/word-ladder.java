class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        return ladder(beginWord,endWord,wordList);
    }
    public int ladder(String src,String des,List<String> ll){
        Queue<pair> q=new LinkedList<>();
        HashSet<String> st=new HashSet<>();
        for(String s:ll){
            st.add(s);
        }
        st.remove(src);
        q.add(new pair(src,1));
        while(!q.isEmpty()){
            pair rp=q.poll();
            String s=rp.s;
            int step=rp.step;
            if(s.equals(des)){
                return step;
            }
            for(int i=0;i<s.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char[] arr=s.toCharArray();
                    arr[i]=ch;
                    String ns=new String(arr);
                    if(st.contains(ns)){
                        st.remove(ns);
                        q.add(new pair(ns,step+1));
                    }
                }
            }
        }
        return 0;
    }
    class pair{
        int step;
        String s;
        public pair(String s,int step){
            this.s=s;    
            this.step=step;
        }
    }
}