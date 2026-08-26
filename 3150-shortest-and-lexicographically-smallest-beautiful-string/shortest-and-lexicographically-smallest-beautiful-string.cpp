class Solution {
public:
    string shortestBeautifulSubstring(string s, int k) {
        string ans;
        int one=0;
        int end=0;
        int start=0;
        int n=s.size();
        int si=-1;
        int ei=-1;
        int minlen=INT_MAX;
        while(end<n){
            if(s[end]=='1'){
                one++;
            }
            while(one>k){
                if(s[start]=='1'){
                    one--;
                }
                start++;
            }
            if(one == k){
                while(s[start]=='0'){
                    start++;
                }
                int len=end-start+1;
                if(minlen>len){
                    minlen=len;
                    si=start;
                    ei=end;
                }
                else if(len==minlen){
                    if(s.compare(start,len,s,si,minlen)<0){
                        si=start;
                        ei=end;
                    }
                }

            }
            end++;
        }
        if(si==-1){
            return "";
        }
        return s.substr(si,minlen);
    }
};