package com.leetcode;

public class T6 {
    public String convert(String s, int numRows) {
        if (numRows<=1)
            return s;
        StringBuilder[] stringBuilders = new StringBuilder[numRows];
        for (int i=0;i<numRows;i++){
            stringBuilders[i]=new StringBuilder();
        }
        int total=2*numRows-2;
        int ind=0;
        for (int i=0;i<s.length();i++){
            int temp=i%total;
            if(temp>=numRows) {
                temp = 2 * (numRows - 1) - temp;
            }
            stringBuilders[temp].append(s.charAt(i));
        }
        StringBuilder ans = new StringBuilder();
        for (int i=0;i<numRows;i++){
            ans.append(stringBuilders[i]);
        }
        return ans.toString();
    }

    public String convert2(String s, int numRows) {
        if (numRows<=1)
            return s;
        int ind[] = new int[s.length()];
        int total=2*numRows-2;
        for (int i=0;i<s.length();i++){
            int temp=i%total;
            if(temp>=numRows) {
                temp = 2 * (numRows - 1) - temp;
            }
            ind[i]=temp;
        }
        StringBuilder ans = new StringBuilder();
        for(int j=0;j<numRows;j++){
            for(int i=0;i<s.length();i++){
                if(ind[i]==j){
                    ans.append(s.charAt(i));
                }
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        T6 t=new T6();
        String s = t.convert2("PAYPALISHIRING", 3);
        System.out.println(s);
    }
}
