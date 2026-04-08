class Solution {
public:
    bool reachingPoints(int sx, int sy, int tx, int ty) {
        while(sx<tx && sy<ty){
            if(tx>ty){
                tx=tx%ty;
            }
            else{
                ty=ty%tx;
            }
        }
        if(tx==sx && ty >= sy && (ty-sy)%sx==0){
            return true;
        }
        return ty==sy && (tx-sx)%sy==0;
    }
};