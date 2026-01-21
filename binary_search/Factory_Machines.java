package cses_problemset.binary_search;

import java.util.*;

public class Factory_Machines {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        long t=in.nextLong();
        long [] nums=new long[n];
        for(int i=0;i<n;i++){
            nums[i]=in.nextLong();
        }
        Arrays.sort(nums);
        System.out.println(minTime(nums,t,n));
        in.close();
    }
    public static long minTime(long [] nums,long t,int n){
        long ans=-1;
        long lo=1;
        long hi=nums[0]*t;
        while(lo<=hi){
            long mid=lo+(hi-lo)/2;
            if(isPossible(nums,mid,t)){
                ans=mid;
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return ans;
    }
    public static boolean isPossible(long [] nums,long mid,long t){
        long count=0;
        for(int i=0;i<nums.length;i++){
            count+=mid/nums[i];
            if(count>=t) return true;
        }
        return count>=t;
    }
}
