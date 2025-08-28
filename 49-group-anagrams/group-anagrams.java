class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // List<List<String>> ans=new ArrayList<>();
        // HashMap<String,Integer> mp=new HashMap<>();
        // int id=0;
        // for(int i=0;i<strs.length;i++){
        //     char[] ch=strs[i].toCharArray();
        //     Arrays.sort(ch);
        //     String s=new String(ch);
        //     if(mp.getOrDefault(s,-1)==-1){
        //         List<String> ll=new ArrayList<>();
        //         ll.add(strs[i]);
        //         mp.put(s,id);
        //         ans.add(ll);
        //         id++;
        //     }
        //     else{
        //         List<String> ll=ans.get(mp.get(s));
        //         ll.add(strs[i]);
        //     }
        // }
        // return ans;
        return anagram(strs);
    }


    public List<List<String>> anagram(String[] strs){
        HashMap<String,List<String>> mp=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String k=getkey(strs[i]);
            if(!mp.containsKey(k)){
                mp.put(k,new ArrayList<>());
            }
            mp.get(k).add(strs[i]);
        }
        List<List<String>> ans=new ArrayList<>();
        for(String s:mp.keySet()){
            ans.add(mp.get(s));
        }
        return ans;
    }


    public String getkey(String s){
        int [] freq=new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<freq.length;i++){
            sb.append(freq[i]).append(" ");
        }
        return sb.toString();
    }

}