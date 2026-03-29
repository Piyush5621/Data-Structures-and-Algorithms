/*

//Using AdjlIst 1 Method;
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/
class Pair{
    int f;
    List<Integer> s;
    Pair(int a,List<Integer>b){
        f=a;
        s=new ArrayList<>(b);
    }
}
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        int n=employees.size();
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<=2000;i++) adj.add(new ArrayList<>());
        Queue<Integer> q=new ArrayDeque<>();
        for(Employee e: employees){
            int idd=e.id;
            int i=e.importance;
            List<Integer> li=new ArrayList<>();
            for(int x: e.subordinates){
                li.add(x);
            }
            adj.get(idd).add(new Pair(i,li));
           
        }
        int ans=0;
        q.add(id);
        while(!q.isEmpty()){
            int iid=q.poll();
            Pair p = adj.get(iid).get(0);
            int impp=p.f;
            ans+=impp;
            for(int x:p.s){
                q.add(x);
            }
        }

        return ans;
    }
}


// 2nd Method using HashMap

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/
class Pair{
    int f;
    List<Integer> s;
    Pair(int a,List<Integer>b){
        f=a;
        s=new ArrayList<>(b);
    }
}
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        int n=employees.size();
        HashMap<Integer,Pair> map=new HashMap<>();
        Queue<Integer> q=new ArrayDeque<>();
        for(Employee e: employees){
            int idd=e.id;
            int i=e.importance;
            List<Integer> li=new ArrayList<>();
            for(int x: e.subordinates){
                li.add(x);
            }
            map.put(idd,new Pair(i,li));
        }
        int ans=0;
        q.add(id);
        while(!q.isEmpty()){
            int iid=q.poll();
            Pair p=map.get(iid);
            int impp=p.f;
            ans+=impp;
            for(int x:p.s){
                q.add(x);
            }
        }

        return ans;
    }
}