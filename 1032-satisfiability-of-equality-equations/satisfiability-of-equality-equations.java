class Solution {
    int[] parent=new int[26];
    public boolean equationsPossible(String[] equations) {
        for(int i=0;i<26;i++){
            parent[i]=i;
        }
        for(int i=0;i<equations.length;i++){
            String a=equations[i];
            if(a.charAt(1)=='='){
                int ch1=a.charAt(0)-'a';
                int ch2=a.charAt(3)-'a';
                union(ch1,ch2);
            }
        }

        for(int i=0;i<equations.length;i++){
            String a=equations[i];
            if(a.charAt(1)=='!'){
                int ch1=a.charAt(0)-'a';
                int ch2=a.charAt(3)-'a';
                if(find(ch1)==find(ch2)){
                    return false;
                }
            }
        }
        return true;
    }
    public void union(int a,int b){
        int pa=find(a);
        int pb=find(b);
        if(pa!=pb){
            parent[pa]=pb;
        }
    }
    public int find(int x){
        if(parent[x]==x){
            return x;
        }
        parent[x]=find(parent[x]);
        return parent[x];
    }
}