class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> mp=new HashMap<>();
        String[] arr=s.trim().split("\\s+");
        if(arr.length!=pattern.length()){
            return false;
        }
        for(int i=0;i<pattern.length();i++){
            if(mp.containsKey(pattern.charAt(i))){
                if(!mp.get(pattern.charAt(i)).equals(arr[i])){
                    return false;
                }
            }
                else{
                    if(mp.containsValue(arr[i])){
                        return false;
                    }
                    mp.put(pattern.charAt(i),arr[i]);
                }
        }
        return true;
    }
}