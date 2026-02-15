class MagicDictionary {
    HashMap<Integer,ArrayList<String>> mp;
    public MagicDictionary() {
        mp=new HashMap<>();
    }
    
    public void buildDict(String[] dictionary) {
        for(String s:dictionary){
            int n=s.length();
            mp.putIfAbsent(n,new ArrayList<>());
            mp.get(n).add(s);
        }
    }
    
    public boolean search(String searchword) {
        if(!mp.containsKey(searchword.length())){
            return false;
        }
        for(String s:mp.get(searchword.length())){
            int c=0;
            for(int i=0;i<searchword.length();i++){
                if(s.charAt(i)!=searchword.charAt(i)){
                    c++;
                    if(c>1){
                        break;
                    }
                }
            }
            if(c==1){
                return true;
            }
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */