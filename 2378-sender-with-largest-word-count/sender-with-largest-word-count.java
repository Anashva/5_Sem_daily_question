class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
       TreeMap<String,Integer> mp=new TreeMap<>();
       for(int i=0;i<messages.length;i++){
        int count=count(messages[i]);
        mp.put(senders[i],mp.getOrDefault(senders[i],0)+count);
       } 
       String ans="";
       int maxcount=0;
       for(String s:mp.keySet()){
        if(mp.get(s)>maxcount || (mp.get(s) == maxcount && s.compareTo(ans) > 0)){
            maxcount=mp.get(s);
            ans=s;
            }
       }
       return ans;

    }
    public int count(String s){
        int ans=0;
        String[] arr=s.split(" ");
        return arr.length;
    }
}