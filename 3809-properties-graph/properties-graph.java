class Solution {
    HashMap<Integer,List<Integer>> mp;
    public int numberOfComponents(int[][] properties, int k) {
        mp=new HashMap<>();
        int n=properties.length;
        for(int i=0;i<n;i++){
            mp.put(i,new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int size=intersect(properties[i],properties[j]);
                if(size>=k){
                    mp.get(i).add(j);
                    mp.get(j).add(i);
                }
            }
        }
        return bft();

    }
    public int bft(){
        HashSet<Integer> st=new HashSet<>();
        Queue<Integer> q=new LinkedList<>();
        int c=0;
        for(int k:mp.keySet()){
            if(st.contains(k)){
                continue;
            }
            c++;
            q.add(k);
            while(!q.isEmpty()){
                int r=q.poll();
                if(st.contains(r)){
                    continue;
                }
                st.add(r);
                for(int nbr:mp.get(r)){
                    if(!st.contains(nbr)){
                        q.add(nbr);
                    }
                }
            }
        }
        return c;
    }
    public int intersect(int[]a,int[]b){
        HashSet<Integer> s1=new HashSet<>();
        HashSet<Integer> s2=new HashSet<>();
        for(int n:a){
            s1.add(n);
        }
        for(int n:b){
            if(s1.contains(n)){
                s2.add(n);
            }
        }
        return s2.size();
    }
}