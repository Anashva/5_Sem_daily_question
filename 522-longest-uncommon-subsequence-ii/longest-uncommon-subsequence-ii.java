class Solution {
    public int findLUSlength(String[] strs) {
        Arrays.sort(strs,(a,b)->b.length()-a.length());
        for(int i=0;i<strs.length;i++){
            boolean uncommon=true;
            for(int j=0;j<strs.length;j++){
                if(i!=j && subs(strs[i],strs[j])){
                    uncommon=false;
                    break;
                }
            }
            if(uncommon){
                return strs[i].length();
            }
        }
        return -1;
    }
    public boolean subs(String a,String b){
        int i=0;
        int j=0;
        while(i<a.length() && j<b.length()){
            if(a.charAt(i)==b.charAt(j)){
                i++;
            }
            j++;
        }
        return i==a.length();
    }
}