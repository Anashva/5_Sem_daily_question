class Solution {
    static String[] key = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    public List<String> letterCombinations(String digits) {
        List<String>ll= new ArrayList<>();
        if(digits.length()==0){
            return ll;
        }
        phonenumber(digits,"",ll);
        return ll;
    }
    public static void phonenumber(String ques,String ans,List<String> ll){
        if(ques.length()==0){
            ll.add(ans);
            return;
        }
        char ch=ques.charAt(0);
        String getstring=key[ch-'0'];
        for(int i=0;i<getstring.length();i++){
            phonenumber(ques.substring(1),ans+getstring.charAt(i),ll);
        }
    }

}