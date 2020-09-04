package com.leetcode;

public class T12 {
    public String intToRoman(int num) {
        int [] n = new int[]{
                1000,900,500,400,
                100,90,50,40,
                10,9,5,4,1};
//        String [] s =new String[]{
//                "M","CM","D","CD",
//                "C","XC","L","XL",
//                "X","IX","V","IV","I"};

        StringBuilder ans = new StringBuilder();
        for(int i=0;i<n.length;i++){
            while(num>=n[i]){
                num-=n[i];
                ans.append(gets(n[i]));
            }
        }
        return ans.toString();
    }

    public String gets(int a){
        switch (a){
            case 1000: return "M";
            case 900: return "CM";
            case 500: return "D";
            case 400: return "CD";
            case 100: return "C";
            case 90: return "XC";
            case 50: return "L";
            case 40: return "XL";
            case 10: return "X";
            case 9: return "IX";
            case 5: return "V";
            case 4: return "IV";
            case 1: return "I";
            default:return "";
        }
    }
}
