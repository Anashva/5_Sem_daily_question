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
    int removeStones(vector<vector<int>>& stones) {
        int n=stones.size();
        DSU dsu(n);
        unordered_map<int,int> row;
        unordered_map<int,int> col;
        for(int i=0;i<n;i++){
            if(row.find(stones[i][0])!=row.end()){
                dsu.unite(row[stones[i][0]],i);
            }
            if(col.find(stones[i][1])!=col.end()){
                dsu.unite(col[stones[i][1]],i);
            }
            row[stones[i][0]]=i;
            col[stones[i][1]]=i;
        }
        int count=0;
        for(int i=0;i<dsu.parent.size();i++){
            if(dsu.find(i)==i){
                count++;
            }
        }
        return n-count;
    }
};