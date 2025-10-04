class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(a,b)->a[0]==b[0] ? a[1]-b[1] :b[0]-a[0]);
        List<int[]> ll=new ArrayList<>();
        for(int[] a:people){
            ll.add(a[1],a);
        }
        return ll.toArray(new int[people.length][2]);
        
    }
}