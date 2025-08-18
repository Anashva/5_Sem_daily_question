class Solution {
    public int countOfSubstrings(String word, int k) {
        if(word.length()<5){
            return 0;
        }
        int ans=0;
        for(int i=0;i<word.length();i++){
            int a=0,e=0,I=0,o=0,u=0,c=0;
            for(int j=i;j<word.length();j++){
                if(word.charAt(j)=='a'){
                    a++;
                }
                else if(word.charAt(j)=='e'){
                    e++;
                }
                else if(word.charAt(j)=='i'){
                    I++;
                }
                else if(word.charAt(j)=='o'){
                    o++;
                }
                else if(word.charAt(j)=='u'){
                    u++;
                }
                else{
                    c++;
                }
                if(c==k && a>0 && e>0 && I>0 && o>0 && u>0){
                ans++;
            }
            }
            
        }
        return ans;

    }
}