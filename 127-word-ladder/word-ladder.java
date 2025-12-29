class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        return count(beginWord,endWord,wordList);
    }
    public int count(String src,String des,List<String> ll){
        Queue<pair> q=new LinkedList<>();
        HashSet<String> st=new HashSet<>();
        q.add(new pair(src,1));
        for(String s:ll){
            st.add(s);
        }
        st.remove(src);
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
                    String news=new String(arr);
                    if(st.contains(news)){
                        st.remove(news);
                        q.add(new pair(news,step+1));
                    }
                }
            }
        }
        return 0;
    }

    class pair{
        String s;
        int step;
        pair(String s,int step){
            this.s=s;
            this.step=step;
        }
    }
}