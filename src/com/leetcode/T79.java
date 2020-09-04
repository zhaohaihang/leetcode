package com.leetcode;

public class T79 {
    public boolean [][] vis;
    public char[][] graph;
    public int[][] dir ={{0,1},{0,-1},{1,0},{-1,0}};
    public char[] tar;
    public boolean exist(char[][] board, String word) {
        vis=new boolean[board.length][board[0].length];
        graph=board;
        tar=word.toCharArray();

        for(int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if(dfs(i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int x, int y, int s) {
        if(s==tar.length-1){
            return tar[s]==graph[x][y];
        }
        if(tar[s]==graph[x][y]){
            vis[x][y]=true;
            for(int i=0;i<4;i++){
                int nx=x+dir[i][0];
                int ny=y+dir[i][1];
                if(check(nx,ny)&&!vis[nx][ny]){
                    if(dfs(nx,ny,s+1)){
                        return true;
                    }
                }
            }
            vis[x][y]=false;
        }
        return false;
    }

    private boolean check(int nx, int ny) {
        return (0<=nx&&nx<graph.length)&&(0<=ny&&ny<graph[0].length);
    }

}
