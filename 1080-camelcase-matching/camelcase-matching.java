class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans=new ArrayList<>();
        for(String s:queries){
            int i=0;
            int j=0;
            boolean flag=true;
            while(i<s.length()){
                if(j<pattern.length() && s.charAt(i)==pattern.charAt(j)){
                    i++;
                    j++;
                }
                else{
                    if(Character.isUpperCase(s.charAt(i))){
                        flag=false;
                        break;
                    }
                    i++;
                }
            }
            if(j!=pattern.length()){
                flag=false;
            }
            ans.add(flag);
        }
        return ans;
    }
}