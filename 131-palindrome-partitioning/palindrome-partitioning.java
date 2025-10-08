class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        List<String> ll=new ArrayList<>();
        pallind(s,ans,ll);
        return ans;

    }
    public void pallind(String s,List<List<String>> ans,List<String> ll){
        if(s.length()==0){
            ans.add(new ArrayList<>(ll));
            return;
        }
        for(int i=1;i<=s.length();i++){
            String t=s.substring(0,i);
            if(check(t)){
                ll.add(t);
                pallind(s.substring(i),ans,ll);
                ll.remove(ll.size()-1);
            }
        }
    }
    public boolean check(String t){
        int i=0;
        int j=t.length()-1;
        while(i<j){
            if(t.charAt(i)!=t.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}