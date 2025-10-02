class Solution {
    public int numWaterBottles(int nb, int me) {
        int drink=0;
        while(nb>=me){
            int k=nb/me;
            drink+=me*k;
            nb-=me*k;
            nb+=k;
        }
        return drink+nb;
   }
}