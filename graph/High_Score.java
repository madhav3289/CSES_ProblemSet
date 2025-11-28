package cses_problemset.graph;

import java.util.*;

// As per the question graph might contains negative edges so Dijkastra Algorithm might give a wrong answer.
// So we will use BellMan Ford Algorithm
// even in bellman ford make sure there is no negative weight cycle.

// Using BellMan Ford Algorithm

public class High_Score {
    static HashMap<Integer,List<Pair>> map;
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        map=new HashMap<>();
        for(int i=1;i<=n;i++){
            map.put(i,new ArrayList<>());
        }
        int m=in.nextInt();
        for(int i=0;i<m;i++){
            int a=in.nextInt();
            int b=in.nextInt();
            long cost=in.nextLong();
            map.get(a).add(new Pair(b,cost));
        }
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
}
// Output
// Print one integer: the maximum score you can get. However, if you can get an arbitrarily large score, print -1.
// Constraints

// 1 \le n \le 2500
// 1 \le m \le 5000
// 1 \le a,b \le n
// -10^9 \le x \le 10^9

// Example
// Input:
// 4 5
// 1 2 3
// 2 4 -1
// 1 3 -2
// 3 4 7
// 1 4 4

// Output:
// 5

// public class High_Score {
//     static HashMap<Integer,List<Pair>> map;
//     public static void main(String[] args) {
//         Scanner in=new Scanner(System.in);
//         int n=in.nextInt();
//         map=new HashMap<>();
//         for(int i=1;i<=n;i++){
//             map.put(i,new ArrayList<>());
//         }
//         int m=in.nextInt();
//         for(int i=0;i<m;i++){
//             int a=in.nextInt();
//             int b=in.nextInt();
//             long cost=in.nextLong();
//             map.get(a).add(new Pair(b,cost));
//         }
//         System.out.println(dijkstra());
//         in.close();
//     }
//     static class Pair{
//         int vtx;
//         long cost;
//         Pair(int vtx,long cost){
//             this.vtx=vtx;
//             this.cost=cost;
//         }
//     }
//     public static long dijkstra(){
//         long ans=0;
//         PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Long.compare(b.cost, a.cost));
//         pq.add(new Pair(1,0));
//         HashSet<Integer> set=new HashSet<>();
//         while(!pq.isEmpty()){
//             // remove
//             Pair p=pq.poll();
//             // ignore
//             if(set.contains(p.vtx)){
//                 continue;
//             }
//             // mark visited
//             set.add(p.vtx);
//             // self work
//             ans+=p.cost;
//             // add neighbours
//             for(Pair key:map.get(p.vtx)){
//                 if(!set.contains(key.vtx)){
//                     long cost=key.cost+p.cost;
//                     pq.add(new Pair(key.vtx,cost));
//                 }
//             }
//         }
//         return ans;
//     }
// }