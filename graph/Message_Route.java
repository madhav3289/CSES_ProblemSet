package cses_problemset.graph;

import java.util.*;

public class Message_Route {
    static List<List<Integer>> map;
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        map=new ArrayList<>();
        for(int i=0;i<=n;i++){
            map.add(new ArrayList<>());
        }
        int m=in.nextInt();
        for(int i=0;i<m;i++){
            int a=in.nextInt();
            int b=in.nextInt();
            map.get(a).add(b);
            map.get(b).add(a);
        }
        BFS(n);
        in.close();
    }
    public static void BFS(int n){
        boolean isWay=false;

        Queue<Integer> q=new LinkedList();
        // Set<Integer> set=new HashSet<>();
        boolean [] visited=new boolean[n+1];

        int [] parent=new int[n+1];
        Arrays.fill(parent,-1);

        q.add(1);
        visited[1]=true;

        while(!q.isEmpty()){
            // remove
            int e=q.poll();

            // ignore
            // if(set.contains(e)){
            //     continue;
            // }

            // mark visited
            // set.add(e);
            
            // self work
            if(e==n){
                isWay=true;
                break;
            }
            // add neighbours
            for(int key:map.get(e)){
                if(!visited[key]){
                    visited[key]=true;
                    parent[key]=e;
                    q.add(key);
                }
            }
        }
        if(!isWay){
            System.out.println("IMPOSSIBLE");
            return;
        }
        List<Integer> res=new ArrayList<>();
        int val=n;
        while(val!=-1){
            res.add(val);
            val=parent[val];
        }
        System.out.println(res.size());
        for(int i=res.size()-1;i>=0;i--){
            System.out.print(res.get(i)+" ");
        }
    }
}
