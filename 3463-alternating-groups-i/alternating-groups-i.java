class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int ans=0;
        for(int i=0;i<colors.length;i++){
            int prev=colors[(i)%colors.length];
            int next=colors[(i+2)%colors.length];
            int curr=colors[(i+1)%colors.length];
            if(prev==next && curr!=prev && curr!=next){
                ans++;
                
            }          
        }
        return ans;
    }
}