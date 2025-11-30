package cses_problemset.graph;

import java.util.*;

public class Round_Trip {
    static List<List<Integer>> map;
    static int [] parent;
    static boolean [] visited;
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        map=new ArrayList<>();
        visited=new boolean[n+1];
        parent=new int[n+1];
        Arrays.fill(parent,-1);
        
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
        for(int i=1;i<=n;i++){
            if(!visited[i] && DFS(i,-1)){
                break;
            }
        }
        printPath();
        in.close();  
    }
    public static boolean DFS(int node,int par){
        visited[node]=true;
        for(int key:map.get(node)){
            if(key==par){
                continue;
            }
            if(visited[key]){
                stNode=key;
                edNode=node;
                return true;
            }
            else{
                parent[key]=node;
                if(DFS(key,node)){
                    return true;
                }
            }
        }
        return false;
    }
    static int stNode=-1;
    static int edNode=-1;
    public static void printPath(){
        if(stNode==-1){
            System.out.println("IMPOSSIBLE");
            return;
        }
        List<Integer> res=new ArrayList<>();
        int node=edNode;
        res.add(stNode);
        while(node!=stNode && node!=-1){
            res.add(node);
            node=parent[node];
        }
        res.add(stNode);
        Collections.reverse(res);
        System.out.println(res.size());
        for(int ele:res){
            System.out.print(ele+" ");
        }
    }
}
// 10 20
// 9 8
// 9 5
// 6 4
// 5 10
// 7 5
// 7 8
// 3 4
// 6 5
// 2 1
// 10 4
// 6 1
// 9 7
// 7 3
// 4 5
// 2 9
// 5 3
// 2 3
// 8 5
// 6 7
// 3 8
