package cses_problemset.graph;

import java.util.*;

public class Building_Teams {
    static List<List<Integer>> map;
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        map=new ArrayList<>();
        int n=in.nextInt();
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
        bipartiteGraph(n);
        in.close();
    }
    public static void bipartiteGraph(int n){
        Queue<int[]> q=new LinkedList<>();
        // [vertex,distance]
        boolean [] visited=new boolean[n+1];
        int [] d=new int[n+1];
        for(int i=1;i<=n;i++){
            if(visited[i]){
                continue;
            }
            q.add(new int[]{i,0});
            while(!q.isEmpty()){
                // remove
                int [] a=q.poll();

                // ignore
                if(visited[a[0]]){
                    if(d[a[0]]!=a[1]){
                        System.out.println("IMPOSSIBLE");
                        return;
                    }
                    continue;
                }

                // mark visited
                visited[a[0]]=true;
                d[a[0]]=a[1];

                // self work

                // add neighbours
                for(int key:map.get(a[0])){
                    if(!visited[key]){
                        q.add(new int[]{key,a[1]+1});
                    }
                }
            }
        }
        int [] res=new int[n+1];
        Arrays.fill(res,-1);
        visited=new boolean[n+1];
        Queue<int[]> queue=new LinkedList();
        for(int i=1;i<=n;i++){
            if(visited[i]){
                continue;
            }
            queue.add(new int[]{i,1});
            visited[i]=true;
            while(!queue.isEmpty()){
                // remove
                int [] p=queue.poll();

                // ignore

                // mark visited

                // self work
                res[p[0]]=p[1];

                // add neighbours
                for(int key:map.get(p[0])){
                    if(!visited[key]){
                        visited[key]=true;
                        if(p[1]==1){
                            queue.add(new int[]{key,2});
                        }
                        else{
                            queue.add(new int[]{key,1});
                        }
                    }
                }
            }
        }
        for(int i=1;i<=n;i++){
            System.out.print(res[i]+" ");
        }
    }
}
