class Solution {
public:
    int minFlipsMonoIncr(string s) {
        int one=0;
        int zero=0;
        int flip=0;
        for(int i=0;i<s.length();i++){
            if(s[i]=='0'){
                flip++;//flip current 0->1 
                if(flip>one){
                    flip=one;//if minimum previud one then flip all
                }
            }
            else{
                one++;
            }
        }
        return  flip;
    }  
};