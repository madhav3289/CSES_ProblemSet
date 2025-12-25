package cses_problemset.graph;

import java.util.*;

public class Course_Schedule {
    static List<List<Integer>> list;
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        list=new ArrayList<>();
        int n=in.nextInt();
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        int m=in.nextInt();
        for(int i=0;i<m;i++){
            int a=in.nextInt();
            int b=in.nextInt();
            list.get(a).add(b);
        }
        int [] indeg=new int[n+1];
        for(int i=1;i<=n;i++){
            for(int j=0;j<list.get(i).size();j++){
                int e=list.get(i).get(j);
                indeg[e]+=1;
            }
        }
        in.close();
        List<Integer> res=BFS(n,indeg);
        if(res.size()==0){
            System.out.println("IMPOSSIBLE");
            return;
        }
        for(int i=0;i<res.size();i++){
            System.out.print(res.get(i)+" ");
        }
    }
    public static List<Integer> BFS(int n,int [] indeg){
        List<Integer> res=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        for(int i=1;i<=n;i++){
            if(indeg[i]==0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            // remove
            int e=q.poll();
            // self work
            res.add(e);
            // add neighbours
            for(int i=0;i<list.get(e).size();i++){
                int temp=list.get(e).get(i);
                indeg[temp]-=1;
                if(indeg[temp]==0){
                    q.offer(temp);
                }
            }   
        }
        return (res.size()==n)?res:new ArrayList<>();
    }
}
