class DSU{
public:
    vector<int> parent,rank;
    DSU(int n){

        parent.resize(n);
        rank.resize(n,0);
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
    }
    int find(int x){
        if(parent[x]==x){
            return x;
        }
        int val=find(parent[x]);
        return parent[x]=val;
    }
    void unite(int x,int y){
        int px=find(x);
        int py=find(y);
        if(px==py){
            return;
        }
        else if(rank[px]<rank[py]){
            parent[px]=py;
        }
        else if(rank[px]>rank[py]){
            parent[py]=px;
        }
        else{
            parent[py]=px;
            rank[px]++;
        }
    }
};

class Solution {
public:
    int makeConnected(int n, vector<vector<int>>& connections) {
        if(connections.size()<n-1){
            return -1;
        }
        DSU dsu(n);
        for(auto &e:connections){
            dsu.unite(e[0],e[1]);
        }
        unordered_set<int> component;
        for(int i=0;i<n;i++){
            component.insert(dsu.find(i));
        }
        return component.size()-1;

    }
};

