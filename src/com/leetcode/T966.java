package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class T966 {
    public Set<String> w1;
    public Map<String,String > w2;
    public Map<String,String > w3;
    public String[] spellchecker(String[] wordlist, String[] queries) {
        w1=new HashSet<>();
        w2=new HashMap<>();
        w3=new HashMap<>();

        String [] ans = new String[queries.length];

        for(String word: wordlist){
            w1.add(word);

            String lword=word.toLowerCase();
            w2.putIfAbsent(lword,word);

            String llword=deword(lword);
            w3.putIfAbsent(llword,word);
        }

        for(int i=0;i<queries.length;i++){
            String temps=queries[i];
            if(w1.contains(temps)){
                ans[i++]=queries[i];
            }else if(w2.containsKey(temps.toLowerCase())){
                ans[i++]=w2.get(temps.toLowerCase());
            }else if(w3.containsKey(deword(temps.toLowerCase()))){
                ans[i++]=w3.get(deword(temps.toLowerCase()));
            }else{
                ans[i++]="";
            }
        }
        return ans;
    }

    private String deword(String s) {
        StringBuilder re = new StringBuilder();
        for (char c: s.toCharArray()){
            re.append(isvow(c)?'*':c);
        }
        return  re.toString();
    }

    private boolean isvow(char c) {
        return (c=='a'||c=='e'||c=='i'||c=='o'||c=='u');
    }
}
