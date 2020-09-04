package com.leetcode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: Zhao Haihang
 * @Date: 2020/09/04/17:24
 * @Description:
 */
public class Test {
//    static  int dir[][]={{0,1},{0,-1},{1,0},{-1,0}};
////    public static int numFlowerBushes(int[][] grid) {
////        // write your code here
////        if(grid!=null){
////            int count=0;
////            for(int i=0;i<grid.length;i++){
////                for(int j =0;j<grid[0].length;j++){
////                    if(grid[i][j]==1){
////                        dfs(grid,i,j);
////                        count++;
////                    }
////                }
////            }
////            return count;
////        }
////        return 0;
////    }
////
////    public static void dfs(int[][] grid,int x,int y){
////        if(grid[x][y]==1){
////            grid[x][y]=0;
////            for(int i=0;i<4;i++){
////                int nx=x+dir[i][0];
////                int ny=y+dir[i][1];
////                if(nx>=0&&nx<grid.length&&ny>=0&&ny<grid[0].length){
////                    dfs(grid,nx,ny);
////                }
////            }
////        }
////    }
////
////    public static void main(String[] args) {
////        int d[][]= {
////                {1, 1, 0, 0, 0},
////                {0, 1, 0, 0, 1},
////                {0, 0, 0, 1, 1},
////                {0, 0, 0, 0, 0},
////                {0, 0, 0, 1, 1}};
////        System.out.println(numFlowerBushes(d));
////    }

    public int findFirstBadVersion(boolean[] version) {
        // write your code here
        return findBIn(version,0,version.length-1);
    }
    public static int findBIn(boolean[] version,int l,int r){
        while(l+1<r){
            int mid=(l+r)/2;
            if(version[mid]){
                l=mid;
            }else{
                r=mid;
            }
        }
        if(!version[l]) return l;
        if(!version[r]) return r;
        return version.length;//假设全为true时，返回长度
    }

    public static void main(String[] args) {

    }

}
