class Solution {
public:
    int maxDistance(string moves) {
        int x=0;
        int y=0;
        int underscore=0;
        for(char ch:moves){
            if(ch=='U'){
                y++;
            }
            else if(ch=='R'){
                x++;
            }
            else if(ch=='L'){
                x--;
            }
            else if(ch=='D'){
                y--;
            }
            else{
                underscore++;
            }
        }
        int ans=abs(x+underscore)+abs(y);
        ans=max(ans,abs(x-underscore)+abs(y));
        ans=max(ans,abs(x)+abs(y-underscore));
        ans=max(ans,abs(x)+abs(y+underscore));
        return ans;

    }
};