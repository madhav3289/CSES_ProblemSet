package cses_problemset.greedy;

import java.util.*;

public class Ferris_Wheel {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        long wt=in.nextLong();
        long [] nums=new long[n];
        for(int i=0;i<n;i++){
            nums[i]=in.nextLong();
        }
        Arrays.sort(nums);
        System.out.println(minGandolas(nums,wt));
        in.close();
    }
    public static long minGandolas(long [] nums,long wt){
        int n=nums.length;
        long count=0;
        int lo=0,hi=n-1;
        while(lo<=hi){
            if(nums[lo]+nums[hi]<=wt){
                count++;
                lo++;
                hi--;
            }
            else{
                count++;
                hi--;
            }
        }
        return count;
    }
}
