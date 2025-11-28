package cses_problemset.graph;

import java.util.*;

public class Building_Roads {
    static List<List<Integer>> map;
    static List<Integer> res;
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
        System.out.println(minRoads(n));
        for(int i=0;i<res.size()-1;i++){
            System.out.println(res.get(i)+" "+res.get(i+1));
        }
        in.close();
    }
    public static int minRoads(int n){
        int count=-1;
        res=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        // HashSet<Integer> set=new HashSet<>();    // searching -> O(logn)
        // using boolean array for easy and fast searching      // searching O(1)
        boolean [] visited=new boolean[n+1];
        for(int i=1;i<=n;i++){
            // if(set.contains(i)){
            //     continue;
            // }
            if(visited[i]){
                continue;
            }
            res.add(i);
            count++;
            q.add(i);
            while(!q.isEmpty()){
                // remove
                int e=q.poll();

                // ignore
                // if(set.contains(e)){
                //     continue;
                // }
                if(visited[e]){
                    continue;
                }

                // mark visited
                // set.add(e);
                visited[e]=true;

                // self work

                // add neighbours
                for(int key:map.get(e)){
                    // if(!set.contains(key)){
                    //     q.add(key);
                    // }
                    if(!visited[key]){
                        q.add(key);
                    }
                }
            }
        }
        return count;
    }
}
