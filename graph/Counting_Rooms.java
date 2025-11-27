package cses_problemset.graph;

import java.util.*;

public class Counting_Rooms {
    static boolean [][] visited;
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        char [][] maze=new char[n][m];
        for(int i=0;i<n;i++){
            String s=in.next();
            for(int j=0;j<s.length();j++){
                maze[i][j]=s.charAt(j);
            }
        }
        visited=new boolean[n][m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(maze[i][j]=='.' && !visited[i][j]){
                    DFS(maze,i,j);
                    count++;
                }
            }
        }
        System.out.println(count);
        in.close();
    }
    public static void DFS(char [][] maze,int r,int c){
        if(r<0 || c<0 || r>=maze.length || c>=maze[0].length){
            return;
        }
        if(visited[r][c] || maze[r][c]=='#'){
            return;
        }
        visited[r][c]=true;
        DFS(maze,r-1,c);
        DFS(maze,r,c-1);
        DFS(maze,r+1,c);
        DFS(maze,r,c+1);
    }
}
