package com.leetcode;

public class T410 {
    public int splitArray(int[] nums, int m) {
        int l=-1,r=0;
        for(int num :nums){
            l=Math.max(l,num);
            r+=num;
        }

        while(l<r){
            int mid=(l+r)/2;
            int cnt=1;
            int temp=0;
            for(int num : nums){
                temp+=num;
                if (temp>mid){
                    temp=num;
                    cnt++;
                }
            }
            if(cnt>m){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        return l;
    }
}
