package cses_problemset.graph;

import java.util.*;

public class Shortest_Routes_I {
    static HashMap<Integer,HashMap<Integer,Long>> map;
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        map=new HashMap<>();
        int n=in.nextInt();
        for(int i=1;i<=n;i++){
            map.put(i,new HashMap<>());
        }
        int m=in.nextInt();
        for(int i=0;i<m;i++){
            int v1=in.nextInt();
            int v2=in.nextInt();
            long cost=in.nextLong();
            Long prev=map.get(v1).get(v2);
            if(prev==null || cost<prev){
                map.get(v1).put(v2,cost);
            }
        }
        List<Long> res=dijkstra(n);
        for(long i:res){
            System.out.print(i+" ");
        }
        System.out.println();
        in.close();
    }
    static class Pair{
        int vtx;
        long cost;
        Pair(int vtx,long cost){
            this.vtx=vtx;
            this.cost=cost;
        }
    }
    public static List<Long> dijkstra(int n){
        long [] dist=new long[n+1];
        Arrays.fill(dist,(long)1e18);
        dist[1]=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>(new Comparator<Pair>(){
            @Override
            public int compare(Pair a,Pair b){
                return Long.compare(a.cost, b.cost);
            }
        });
        pq.add(new Pair(1,0));
        while(!pq.isEmpty()){
            // remove
            Pair p=pq.poll();
            // ignore
            if(p.cost!=dist[p.vtx]){
                continue;
            }
            // mark visited
            // self work
            // add neighbours
            for(int key:map.get(p.vtx).keySet()){
                long cost=map.get(p.vtx).get(key)+p.cost;
                if(dist[key]>cost){
                    dist[key]=cost;
                    pq.add(new Pair(key,cost));
                }                
            }
        }
        List<Long> res=new ArrayList<>();
        for(int i=1;i<=n;i++){
            res.add(dist[i]);
        }
        return res;
    }
}
