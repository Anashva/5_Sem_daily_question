class Solution {
public:
    bool isReachable(int X, int Y) {
        int g=gcd(X,Y);
        while(g%2==0){
            g=g/2;
        }
        return g==1;
    }
    int gcd(int a,int b){
        while(b!=0){
            int t=b;
            b=a%b;
            a=t;
        }
        return a;
    }
};