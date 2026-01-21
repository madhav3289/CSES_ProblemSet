package cses_problemset.greedy;

import java.util.*;

public class Increasing_Array {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int [] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=in.nextInt();
        }
        System.out.println(findMinMoves(nums,n));
        in.close();
    }
    public static long findMinMoves(int [] nums,int n){
        long count=0;
        for(int i=1;i<n;i++){
            if(nums[i]<nums[i-1]){
                count+=(nums[i-1]-nums[i]);
                nums[i]=nums[i-1];
            }
        }
        return count;
    }
}
