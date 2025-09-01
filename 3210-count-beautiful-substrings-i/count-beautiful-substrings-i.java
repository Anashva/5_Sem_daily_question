class Solution {
    public int beautifulSubstrings(String s, int k) {
        int ans=0;
        for(int i=0;i<s.length();i++){
            int vowel=0;
            int consonant=0;
            for(int j=i;j<s.length();j++){
                char ch=s.charAt(j);
                if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                    vowel++;
                }
                else{
                    consonant++;
                }
                if(vowel==consonant && (vowel*consonant)%k==0){
                    ans++;
                }
            }
        }
        return ans;
    }
}