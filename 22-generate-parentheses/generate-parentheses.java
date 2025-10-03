class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ll=new ArrayList<>();
        generate(n,ll,0,0,"");
        return ll;
    }
    public void generate(int n,List<String> ll,int closed,int opened,String ans){
        if(closed==n && opened==n){
            ll.add(ans);
            return;
        }
        if(closed >opened || closed>n || opened>n){
            return;
        }
        generate(n,ll,closed,opened+1,ans+"(");
        generate(n,ll,closed+1,opened,ans+")");
    }
}