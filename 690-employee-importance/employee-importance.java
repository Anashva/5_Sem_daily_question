/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer,Employee> mp=new HashMap<Integer,Employee>();
        for(Employee e:employees){
            mp.put(e.id,e);
        }
        return importance(id,mp);
    }
    public int importance(int id,HashMap<Integer,Employee> mp){
        Employee e=mp.get(id);
        int sum=e.importance;
        for(int sub:e.subordinates){
            sum+=importance(sub,mp);
        }
        return sum;
    }
}