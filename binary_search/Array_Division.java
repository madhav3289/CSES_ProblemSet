package cses_problemset.binary_search;

import java.util.*;

public class Array_Division {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        long k=in.nextLong();
        long [] nums=new long[n];
        for(int i=0;i<n;i++){
            nums[i]=in.nextLong();
        }
        System.out.println(minSubarraySum(nums,k,n));
        in.close();
    }
    public static long minSubarraySum(long [] nums,long k,int n){
        long sum=0;
        long max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,nums[i]);
            sum+=nums[i];
        }
        long lo=max;
        long hi=sum;
        long ans=sum;
        while(lo<=hi){
            long mid=lo+(hi-lo)/2;
            if(isPossible(nums,k,n,mid)){
                ans=mid;
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return ans;
    }
    public static boolean isPossible(long [] nums,long k,int n,long mid){
        long cSum=0;
        long count=1;
        for(int i=0;i<n;i++){
            if(nums[i]>mid) return false;
            if(cSum+nums[i]>mid){
                cSum=nums[i];
                count++;
            }
            else{
                cSum+=nums[i];
            }
        }
        return count<=k;
    }
    
}
