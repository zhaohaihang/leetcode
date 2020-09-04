package com.leetcode;

import javafx.util.Pair;

import java.util.*;

public class T127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int len = beginWord.length();
        Map<String,List<String>> graph = new HashMap<>();
        Map<String,Boolean> vis = new HashMap<>();
        for (String word : wordList){
            for ( int i=0;i<len;i++){
                String tempword= word.substring(0,i)+"*"+word.substring(i+1,len);
                List<String > templist=graph.getOrDefault(tempword, new ArrayList<>());
                templist.add(word);
                graph.put(tempword, templist);
            }
        }

        Queue<Pair<String,Integer>> Q= new ArrayDeque<>();
        Q.add(new Pair(beginWord,1));
        vis.put(beginWord,true);
        while (!Q.isEmpty()){
            Pair<String,Integer> node = Q.remove();
            String word = node.getKey();
            Integer level = node.getValue();
            for(int i =0 ;i<len;i++){
                String tempword= word.substring(0,i)+"*"+word.substring(i+1,len);
                for(String s : graph.getOrDefault(tempword,new ArrayList<>())){
                    if(s.equals(endWord)){
                        return level+1;
                    }
                    if(!vis.containsKey(s)){
                        vis.put(s, true);
                        Q.add(new Pair(s,level+1));
                    }
                }
            }
        }
        return 0;

    }
}
