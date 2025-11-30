package cses_problemset.graph;

import java.util.*;

public class Monsters {
    static char [][] maze;
    static int [][] dist_M;
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        maze=new char[n][m];        
        dist_M=new int[n][m];
        for(int [] a:dist_M){
            Arrays.fill(a,Integer.MAX_VALUE);
        }
        start=new int[2];
        end=new int[2];
        for(int i=0;i<n;i++){
            String s=in.next();
            for(int j=0;j<m;j++){
                maze[i][j]=s.charAt(j);
                if(s.charAt(j)=='A'){
                    start[0]=i;
                    start[1]=j;
                }
            }
        }
        BFS(n,m);
        in.close();
    }
    static int [] start;
    static int [] end;
    public static void BFS(int n,int m){
        int [][] d={{-1,0},{1,0},{0,-1},{0,1}};
        char [] DIR={'U','D','L','R'};

        Queue<int[]> qm=new LinkedList();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(maze[i][j]=='M'){
                    qm.add(new int[]{i,j});
                    dist_M[i][j]=0;
                }
            }
        }
        while(!qm.isEmpty()){
            // remove
            int [] a=qm.poll();
            int r=a[0];
            int c=a[1];
            // ignore
            // mark visited
            // self work
            // add neighbours
            for(int i=0;i<4;i++){
                int nRow=r+d[i][0];
                int nCol=c+d[i][1];
                if(nRow>=0 && nCol>=0 && nRow<n && nCol<m && maze[nRow][nCol]!='#' && dist_M[nRow][nCol]>dist_M[r][c]+1){
                    dist_M[nRow][nCol]=dist_M[r][c]+1;
                    qm.add(new int[]{nRow,nCol});
                }
            }
        }
        Queue<int[]> q=new LinkedList();
        boolean [][] visited=new boolean[n][m];
        q.add(new int[]{start[0],start[1]});
        visited[start[0]][start[1]]=true;

        int [][] dist_A=new int[n][m];
        dist_A[start[0]][start[1]]=0;
        boolean hasReach=false;
        char [][] parent=new char[n][m];
        while(!q.isEmpty()){
            // remove
            int [] a=q.poll();
            int r=a[0];
            int c=a[1];
            // ignore
            // mark visited
            // self work
            if(r==0 || c==0 || r==n-1 || c==m-1){
                end[0]=r;
                end[1]=c;
                hasReach=true;
                break;
            }
            // add neighbours
            for(int i=0;i<4;i++){
                int nRow=r+d[i][0];
                int nCol=c+d[i][1];
                if(nRow>=0 && nCol>=0 && nRow<n && nCol<m && maze[nRow][nCol]!='#' && !visited[nRow][nCol] && dist_A[r][c]+1<dist_M[nRow][nCol]){
                    visited[nRow][nCol]=true;
                    parent[nRow][nCol]=DIR[i];
                    dist_A[nRow][nCol]=dist_A[r][c]+1;
                    q.add(new int[]{nRow,nCol});
                }
            }
        }
        if(!hasReach){
            System.out.println("NO");
            return;
        }
        StringBuilder path=new StringBuilder();
        int r=end[0];
        int c=end[1];
        while(r!=start[0] || c!=start[1]){
            char ch=parent[r][c];
            path.append(ch);
            int idx=-1;
            for(int i=0;i<4;i++){
                if(ch==DIR[i]){
                    idx=i;
                }
            }
            r-=d[idx][0];
            c-=d[idx][1];
        }
        path.reverse();
        System.out.println("YES");
        System.out.println(path.length());
        System.out.println(path.toString());
    }
}
