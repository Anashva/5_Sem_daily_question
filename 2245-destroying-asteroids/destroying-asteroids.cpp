class Solution {
public:
    bool asteroidsDestroyed(int mass, vector<int>& asteroids) {
        sort(asteroids.begin(),asteroids.end());
        int n=asteroids.size();
        long long m=mass;
        for(int x:asteroids){
            if(x>m){
                return false;
            }
            m+=x;
        }
        return true;
    }
};