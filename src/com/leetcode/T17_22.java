package com.leetcode;

import java.util.*;

public class T17_22 {

    List<String> newwordlist;
    int start=-1,end=-1;
    Set<Integer> [] graph;
    boolean visited[];
    List<String> ans;
    public  List<String> findLadders(String beginWord, String endWord, List<String> wordList) {

        newwordlist=new ArrayList<>();
        //newwordlist.add(0,beginWord);
        newwordlist.addAll(wordList);

        for(int i=0;i<newwordlist.size();i++){
            if (endWord.equals(newwordlist.get(i))){
                end=i;
            }
            if(beginWord.equals(newwordlist.get(i))){
                start=i;
            }
        }
        if (start==-1){
            newwordlist.add(beginWord);
            start=newwordlist.size()-1;
        }
        System.out.println(start);
        if (end==-1)
            return new ArrayList<String>();

        graph = new Set[newwordlist.size()];
        visited=new boolean[newwordlist.size()];
        ans = new ArrayList<>();

        for(int i=0;i<newwordlist.size();i++){
            graph[i]=new HashSet<>();
        }

        for (int i=0;i<newwordlist.size();i++){
            for (int j=0;j<newwordlist.size();j++){
                if (isRea(newwordlist.get(i),newwordlist.get(j))){
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }

        dfs(start);
        if(ans.size()==0)
            return new ArrayList<String>();
        ans.add(newwordlist.get(start));
        Collections.reverse(ans);
        return ans;
    }
    public boolean dfs(int s){
        visited[s]=true;
        if(s==end){
            //ans.add(newwordlist.get(s));
            return true;
        }
        for(int i : graph[s]){
            if(!visited[i]){
                if(dfs(i)){
                    ans.add(newwordlist.get(i));
                    return true;
                }
            }
        }
        return false;
    }
    public  boolean isRea(String a,String b){
        int total=0;
        for (int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)){
                total++;
            }
        }
        return total<=1;
    }

    public static void main(String[] args) {

        T17_22 c =new T17_22();

        String s1="hit";
        String s2="cog";
        List<String > l1= new ArrayList<>();
        l1.add("hot");
        l1.add("dot");
        l1.add("dog");
        l1.add("lot");
        l1.add("log");
        l1.add("cog");

        List<String> ladders = c.findLadders(s1, s2, l1);
        System.out.println(ladders);
    }
}
