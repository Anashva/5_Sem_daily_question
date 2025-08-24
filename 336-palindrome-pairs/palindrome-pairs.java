class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans=new ArrayList<>();
        HashMap<String,Integer> mp=new HashMap<>();
        for(int i=0;i<words.length;i++){
            mp.put(words[i],i);
        }
        for(int i=0;i<words.length;i++){
            String s=reverse(words[i]);
            if(mp.containsKey(s)){
                int idx=mp.get(s);
                if(idx==i){
                    continue;
                }
                ans.add(Arrays.asList(i,idx));
            }
        }
        if(mp.containsKey("")){
            int idx=mp.get("");
            for(int i=0;i<words.length;i++){
                if(idx!=i && pallindrome(words[i])){
                    ans.add(Arrays.asList(idx,i));
                    ans.add(Arrays.asList(i,idx));
                }
            }
        }
        for(int i=0;i<words.length;i++){
            String s=words[i];
            for(int j=1;j<s.length();j++){
                if(pallindrome(s.substring(0,j))){
                    String t=reverse(s.substring(j));
                    if(mp.containsKey(t)){
                        int idx=mp.get(t);
                        if(idx!=i){
                            ans.add(Arrays.asList(idx,i));
                        }
                    }
                }
                if(pallindrome(s.substring(j))){
                    String t=reverse(s.substring(0,j));
                    if(mp.containsKey(t)){
                        int idx=mp.get(t);
                        if(idx!=i){
                            ans.add(Arrays.asList(i,idx));
                        }
                    }
                }
            }
        }
        return ans;
    }
    public String reverse(String s){
        StringBuilder sb=new StringBuilder(s);
        return sb.reverse().toString();
    }
    public boolean pallindrome(String s){
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