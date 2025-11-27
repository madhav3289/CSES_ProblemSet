package cses_problemset.dynamic_programming;

import java.util.*;

public class coin_Combination_1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int amt=in.nextInt();
        int [] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        System.out.println(coinCombination(arr, amt));
        in.close();
    }
    static int mod=1_000_000_007;
    public static int coinCombination(int [] arr,int amt){
        int [] dp=new int[amt+1];
        dp[0]=1;
        for(int i=1;i<=amt;i++){
            for(int j=0;j<arr.length;j++){
                if(i>=arr[j]){
                    dp[i]=(dp[i]+dp[i-arr[j]])%mod;
                }
            }
        }
        return dp[amt];
    }
}
