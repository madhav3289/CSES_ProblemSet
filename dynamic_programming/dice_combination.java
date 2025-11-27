package cses_problemset.dynamic_programming;

import java.util.*;

public class dice_combination {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        // int [] dp=new int[n+1];
        // Arrays.fill(dp,-1);
        // System.out.println(diceCombination(n,dp));
        System.out.println(diceCombination(n));
        in.close();
    }
    static int mod=1_000_000_007;
    public static int diceCombination(int n){
        int [] dp=new int[n+1];
        dp[0]=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<7;j++){
                if(j<=i){
                    dp[i]=(dp[i]+dp[i-j])%mod;
                }
            }
        }
        return dp[n];
    }
    // public static int diceCombination(int n,int [] dp){
    //     if(n<0){
    //         return 0;
    //     }
    //     if(n==0){
    //         return 1;
    //     }
    //     if(dp[n]!=-1){
    //         return dp[n];
    //     }
    //     int count=0;
    //     for(int i=1;i<7;i++){
    //         count=(count+diceCombination(n-i,dp))%mod;
    //     }
    //     return dp[n]=count;
    // }
}