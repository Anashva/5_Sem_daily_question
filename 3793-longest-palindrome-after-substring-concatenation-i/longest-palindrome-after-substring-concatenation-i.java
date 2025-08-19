class Solution {
    public int longestPalindrome(String s, String t) {
       List<String> l1=new ArrayList<>();
       List<String> l2=new ArrayList<>();
       substring(s,l1);
       substring(t,l2);
       return longest(l1,l2);
    }
    public int longest(List<String> l1,List<String> l2){
        int ans=0;
        for(int i=0;i<l1.size();i++){
            for(int j=0;j<l2.size();j++){
                String s=l1.get(i);
                String t=l2.get(j);
                String res=s+t;
                if(pall(s) && ans<s.length()){
                    ans=s.length();
                }
                if(pall(t) && ans<t.length()){
                    ans=t.length();
                }
                if(pall(res) && ans<res.length()){
                    ans=res.length();
                }
            }
        }
        return ans;
    }
    public void substring(String s,List<String> ll){
        for(int len=1;len<=s.length();len++){
            for(int j=len;j<=s.length();j++){
                int i=j-len;
                ll.add(s.substring(i,j));
            }
        }
    }
    public boolean pall(String s){
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}