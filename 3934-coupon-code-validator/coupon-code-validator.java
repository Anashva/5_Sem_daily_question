class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String[]> ll=new ArrayList<>();
        List<String> c = Arrays.asList("electronics", "grocery", "pharmacy", "restaurant");
        int n=code.length;
        for(int i=0;i<n;i++){
            String s=code[i];
            String bs=businessLine[i];
            if(s.matches("[a-zA-Z0-9_]+") && isActive[i] && !s.isEmpty() && c!=null){
                if(c.contains(bs)){
                    ll.add(new String[]{s,bs});
                }
            }
        }
        ll.sort((a,b)->{int ct=Integer.compare(c.indexOf(a[1]),c.indexOf(b[1]));
        if(ct!=0){
            return ct;
        }
            return a[0].compareTo(b[0]);
        });
        List<String> ans=new ArrayList<>();
        for(String[] i:ll){
            ans.add(i[0]);
        }
        return ans;
    }
}