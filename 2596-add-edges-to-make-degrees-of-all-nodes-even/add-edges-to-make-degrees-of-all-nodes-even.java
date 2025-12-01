class Solution {
    HashMap<Integer,HashSet<Integer>> mp;
    public boolean isPossible(int n, List<List<Integer>> edges) {
        mp=new HashMap<>();
        for(int i=1;i<=n;i++){
            mp.put(i,new HashSet<>());
        }
        for(List<Integer> ll:edges){
            int v1=ll.get(0);
            int v2=ll.get(1);
            mp.get(v1).add(v2);
            mp.get(v2).add(v1);
        }
        int odd=0;
        List<Integer> ll=new ArrayList<>();
        for(int i=1;i<=n;i++){
            int c=mp.get(i).size();
            if(c%2==1){
                odd++;
                ll.add(i);
            }
        }
        if(odd==0){
            return true;// no odd degree node
        }
        else if(odd==2){// two odd degree node
            int v1=ll.get(0);
            int v2=ll.get(1);
            if(!mp.get(v1).contains(v2)){
                 return true;
            }
            for(int i=1;i<=n;i++){
                if(v1!=i && v2!=i){
                    if(!mp.get(v1).contains(i) && !mp.get(v2).contains(i)){
                        return true;
                    }
                }
            }

        }
        else if(odd==4){
            int v1=ll.get(0);
            int v2=ll.get(1);
            int v3=ll.get(2);
            int v4=ll.get(3);
            if((!mp.get(v1).contains(v2) && !mp.get(v3).contains(v4)) || (!mp.get(v1).contains(v3) && !mp.get(v2).contains(v4)) || (!mp.get(v2).contains(v3) && !mp.get(v1).contains(v4))){
                return true;
            }
        }
        return false;
    }
}

// if there are  4 node having odd degree then we will make to into two disconnected component graph