package com.leetcode;

public class T1310 {
    /**
     * 暴力解
     * @param arr
     * @param queries
     * @return
     */
//    public int[] xorQueries(int[] arr, int[][] queries) {
//
//        int total=queries.length;
//        int ans[] = new int[total];
//        for(int i=0;i<total;i++){
//            for(int j=queries[i][0];j<queries[i][1];j++){
//                ans[i]^=arr[j];
//            }
//        }
//        return ans;
//    }

    public int[] xorQueries(int[] arr, int[][] queries) {
        int [] ans = new int[queries.length];
        int [] pre=new int[arr.length+1];
        for (int i=1;i<=arr.length;i++){
            pre[i]=pre[i-1]^arr[i-1];
        }
        for(int i=0;i<queries.length;i++){
            ans[i]=pre[queries[i][0]]^pre[queries[i][1]+1];
        }
        return ans;
    }
}

/*

异或性质：
a^a=0
a^0=a
a^b=b^a


*  当a<b时，有如下推论：
*  arr[a]^arr[a+1]^...^arr[b-1]^arr[b]    =   (arr[0]^arr[0])^(arr[1]^arr[1])^...^(arr[a-1]^arr[a-1])^(arr[a]^arr[a+1]^...^arr[b])
*                                       =   (arr[0]^arr[1]^...^arr[a-1])^(arr[0]^arr[1]^...^arr[a-1]^arr[a]^...^arr[b])
*
* 令arr[0]^arr[1]^...^arr[i-1]=pre[i]
* 原式=pre[a]^pre[b+1]
*
* 将O（n^2）查询 转化为 O（n)
*
*
* */
