package cses_problemset.dynamic_programming;

import java.util.*;

public class book_shop {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int x=in.nextInt();
        int [] price=new int[n];
        for(int i=0;i<n;i++){
            price[i]=in.nextInt();
        }
        int [] pages=new int[n];
        for(int i=0;i<n;i++){
            pages[i]=in.nextInt();
        }
        System.out.println(maxPages(n,x,price,pages));
        in.close();
    }
    public static int maxPages(int n,int x,int [] price,int [] pages){
        int [][] dp=new int[n+1][x+1];
        for(int i=1;i<=n;i++){
            for(int j=0;j<=x;j++){
                int val=price[i-1];
                int pg=pages[i-1];
                int pick=(j>=val)?dp[i-1][j-val]+pg:0;
                int skip=dp[i-1][j];
                dp[i][j]=Math.max(pick,skip);
            }
        }
        return dp[n][x];
    }
    // public static int maxPages(int n,int x,int [] price,int [] pages){
    //     int [][] dp=new int[n][x+1];
    //     for(int [] arr:dp){
    //         Arrays.fill(arr,-1);
    //     }
    //     return helper(price,pages,x,0,dp);
    // }
    // public static int helper(int [] price,int [] pages,int x,int idx,int [][] dp){
    //     if(idx>=price.length || x<0){
    //         return 0;
    //     }
    //     if(dp[idx][x]!=-1){
    //         return dp[idx][x];
    //     }
    //     int max=0;
    //     if(x-price[idx]>=0){
    //         int inc=pages[idx]+helper(price,pages,x-price[idx],idx+1,dp);
    //         max=Math.max(max,inc);
    //     }
    //     int exc=helper(price,pages,x,idx+1,dp);
    //     max=Math.max(max,exc);        
    //     return dp[idx][x]=max;
    // }
}
