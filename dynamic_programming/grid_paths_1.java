package cses_problemset.dynamic_programming;

import java.util.*;
public class grid_paths_1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        char [][] grid=new char[n][n];
        for(int i=0;i<n;i++){
            String s=in.next();
            for(int j=0;j<n;j++){
                grid[i][j]=s.charAt(j);
            }
        }
        System.out.println(minPaths(grid,n));
        in.close();
    }
    static int mod=1_000_000_007;
    public static int minPaths(char [][] grid,int n){
        int [][] dp=new int[n][n];
        for(int [] arr:dp){
            Arrays.fill(arr,-1);
        }
        return helper(grid,n,0,0,dp);
    }
    public static int helper(char [][] grid,int n,int row,int col,int [][] dp){
        if(row>=n || col>=n || grid[row][col]=='*'){
            return 0;
        }
        if(row==n-1 && col==n-1){
            return 1;
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        int count=0;
        count=(count+helper(grid,n,row,col+1,dp))%mod;
        count=(count+helper(grid,n,row+1,col,dp))%mod;
        return dp[row][col]=count;
    }
}
