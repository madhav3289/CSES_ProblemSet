package cses_problemset.dynamic_programming;

import java.util.*;

public class edit_distance {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String n=in.next();
        String m=in.next();
        System.out.println(Math.min(editDistance(n,m),editDistance(m,n)));
        in.close();
    }
    public static int editDistance(String str1,String str2){
        int n=str1.length();
        int m=str2.length();
        int [][] dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=i;
        }
        for(int j=0;j<=m;j++){
            dp[0][j]=j;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                else{
                    dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                }
            }
        }
        return dp[n][m];
    }
    // public static int editDistance(String n,String m){
    //     int [][] memo=new int[n.length()+1][m.length()+1];
    //     for(int [] arr:memo){
    //         Arrays.fill(arr,-1);
    //     }
    //     return helper(n,m,0,0,memo);
    // }
    // public static int helper(String n,String m,int i,int j,int [][] memo){
    //     if(i==n.length()){
    //         // we can only add character
    //         return m.length()-j;
    //     }
    //     if(j==m.length()){
    //         // we can only delete character
    //         return n.length()-i;
    //     }
    //     if(memo[i][j]!=-1){
    //         return memo[i][j];
    //     }
    //     int add=0,del=0,rep=0;
    //     if(n.charAt(i)==m.charAt(j)){
    //         return helper(n,m,i+1,j+1,memo);
    //     }
    //     else{
    //         // we can add a character
    //         add=1+helper(n,m,i,j+1,memo);
    //         // we can delete a character
    //         del=1+helper(n,m,i+1,j,memo);
    //         // we can replace a character
    //         rep=1+helper(n,m,i+1,j+1,memo);
    //     }
    //     return memo[i][j]=Math.min(add,Math.min(del,rep));
    // }
}
