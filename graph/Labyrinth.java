package cses_problemset.graph;

import java.util.*;

// public class Labyrinth {


    // Important Note -> DFS can find path but doesn't ensure if the path is shortest or not so might give wrong answer so we will use BFS

    // static boolean [][] visited;
    // static StringBuilder sb;
    // static int [] src;
    // public static void main(String[] args) {
    //     Scanner in=new Scanner(System.in);
    //     int n=in.nextInt();
    //     int m=in.nextInt();
    //     char [][] maze=new char[n][m];
    //     visited=new boolean[n][m];
    //     sb=new StringBuilder();
    //     src=new int[2];
    //     for(int i=0;i<n;i++){
    //         String s=in.next();
    //         for(int j=0;j<s.length();j++){
    //             maze[i][j]=s.charAt(j);
    //             if(maze[i][j]=='A'){
    //                 src[0]=i;
    //                 src[1]=j;
    //             }
    //         }
    //     }
    //     DFS(maze,src[0],src[1],new StringBuilder());
    //     if(sb.length()==0){
    //         System.out.println("NO");
    //     }
    //     else{
    //         System.out.println("YES");
    //         System.out.println(sb.length());
    //         System.out.println(sb);
    //     }
    //     in.close();
    // }
    // public static void DFS(char [][] maze,int r,int c,StringBuilder temp){
    //     if(r<0 || c<0 || r>=maze.length || c>=maze[0].length){
    //         return;
    //     }
    //     if(maze[r][c]=='B'){
    //         if(temp.length()<sb.length() || sb.length()==0){
    //             sb.setLength(0);
    //             sb.append(temp);
    //         }
    //         return;
    //     }
    //     if(visited[r][c] || maze[r][c]=='#'){
    //         return;
    //     }
    //     visited[r][c]=true;

    //     // go up
    //     temp.append('U');
    //     DFS(maze,r-1,c,temp);
    //     temp.deleteCharAt(temp.length()-1);

    //     // go left
    //     temp.append('L');
    //     DFS(maze,r,c-1,temp);
    //     temp.deleteCharAt(temp.length()-1);

    //     // go down
    //     temp.append('D');
    //     DFS(maze,r+1,c,temp);
    //     temp.deleteCharAt(temp.length()-1);

    //     // go right
    //     temp.append('R');
    //     DFS(maze,r,c+1,temp);
    //     temp.deleteCharAt(temp.length()-1);

    //     visited[r][c]=false;

    // }


    // Using BFS
// }

public class Labyrinth {
    static int [] src;
    static boolean [][] visited;
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        src=new int[2];
        visited=new boolean[n][m];
        char [][] maze=new char[n][m];
        for(int i=0;i<n;i++){
            String s=in.next();
            for(int j=0;j<s.length();j++){
                maze[i][j]=s.charAt(j);
                if(maze[i][j]=='A'){
                    src[0]=i;
                    src[1]=j;
                }
            }
        }
        BFS(maze);
        in.close();
    }
    public static void BFS(char [][] maze){
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{src[0],src[1]});

        int [][] dir={{-1,0},{1,0},{0,-1},{0,1}};
        char [] dirP={'U','D','L','R'};
        boolean hasPath=false;
        
        int [][][] path=new int[maze.length][maze[0].length][2];
        char [][] move=new char[maze.length][maze[0].length];


        int [] des=new int[2];
        Arrays.fill(des,-1);
        while(!q.isEmpty()){
            // remove
            int [] e=q.poll();
            int r=e[0];
            int c=e[1];
            // ignore
            if(visited[r][c] || maze[r][c]=='#'){
                continue;
            }
            // mark visited
            visited[r][c]=true;
            // self work
            if(maze[r][c]=='B'){
                hasPath=true;
                des[0]=r;
                des[1]=c;
                break;
            }
            // add neighbours
            for(int a=0;a<4;a++){
                int cR=r+dir[a][0];
                int cC=c+dir[a][1];
                if(cR<0 || cC<0 || cR>=maze.length || cC>=maze[0].length){
                    continue;
                }
                if(maze[cR][cC]=='#' || visited[cR][cC]){
                    continue;
                }
                path[cR][cC][0]=r;
                path[cR][cC][1]=c;
                move[cR][cC]=dirP[a];
                q.add(new int[]{cR,cC});
            }
        }
        if(!hasPath){
            System.out.println("NO");
            return;
        }
        StringBuilder sb=new StringBuilder();
        int r=des[0];
        int c=des[1];
        while(!(r==src[0] && c==src[1])){
            sb.append(move[r][c]);
            int cR=path[r][c][0];
            int cC=path[r][c][1];
            r=cR;
            c=cC;
        }
        sb.reverse();
        System.out.println("YES");
        System.out.println(sb.length());
        System.out.println(sb.toString());

    }
}

// 5 8
// ########
// #.A#...#
// #.##.#B#
// #......#
// ########