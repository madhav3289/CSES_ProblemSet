package cses_problemset.binary_search;

import java.util.*;

public class Multiplication_Table {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        long n=in.nextLong();
        System.out.println(median(n));
        in.close();
    }
    public static long median(long n){
        long lo=1;
        long hi=n*n;
        long ans=hi;
        while(lo<=hi){
            long mid=lo+(hi-lo)/2;
            if(isPossible(mid,n)){
                ans=mid;
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return ans;
    }
    public static boolean isPossible(long mid,long n){
        long count=0;
        long req=((long)n*n+1)/2;
        for(int i=1;i<=n;i++){
            count+=Math.min(n,mid/i);
        }
        return count>=req;
    }
}
