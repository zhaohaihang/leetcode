package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class T916 {
    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> ans= new ArrayList<>();

        int bmax[] = getnum("");
        for(String b: B){
            int [] bnum=getnum(b);
            for(int i=0;i<26;i++){
                bmax[i]=Math.max(bmax[i],bnum[i]);
            }
        }

        for(String a:A){
            int []anum=getnum(a);
            int i=0;
            for (i=0;i<26;i++){
                if(anum[i]<bmax[i]){
                    break;
                }
            }
            if(i==26){
                ans.add(a);
            }
        }
        return ans;
    }

    private int[] getnum(String s) {
        int temp[]=new int[26];
        for (int i=0;i<s.length();i++){
            temp[s.charAt(i)-'a']++;
        }
        return temp;
    }


}
