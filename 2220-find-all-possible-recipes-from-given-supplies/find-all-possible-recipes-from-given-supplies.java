class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> ans = new ArrayList<>();
        HashSet<String> st = new HashSet<>();
        for (String s : supplies) {
            st.add(s);
        }
        HashMap<String, List<String>> mp = new HashMap<>();
        for (int i = 0; i < recipes.length; i++) {
            mp.putIfAbsent(recipes[i], new ArrayList<>());
            for (String s : ingredients.get(i)) {
                mp.get(recipes[i]).add(s);
            }
        }
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < recipes.length; i++) {
                String s = recipes[i];
                if(st.contains(s)){
                    continue;
                }
                int c = 0;
                for (String t : mp.get(s)) {
                    if (st.contains(t)) {
                        c++;
                    }
                }
                if (c == mp.get(s).size()) {
                    ans.add(s);
                    st.add(s);
                    flag=true;
                }
            }
        }
        return ans;
    }
}