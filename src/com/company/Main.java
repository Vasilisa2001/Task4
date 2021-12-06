package com.company;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println(makeEssay(10, 7, "hello my name is Bessie and this is my essay"));
        System.out.println(split("((()))(())()()(()())"));
        System.out.println(toCamelCase("is_modal_open"));
        System.out.println(toSnakeCase("helloEdabit"));
        System.out.println(overTime(new double[]{16, 18, 30, 1.8}));
        System.out.println(BMI("154 pounds", "2 meters"));
        System.out.println(bugger(999));
        System.out.println(toStarShorthand("77777geff"));
        System.out.println(doesRhyme("Sam I am!", "Green eggs and HAM."));
        System.out.println(trouble(766677, 123477766));
        System.out.println(countUniqueBooks("$AA$BBCATT$C$$B$", '$'));
    }

    public static String makeEssay(int n, int k, String str){
        String ess = "";
        String[] words_arr = str.split(" ");
        int line_am = 0;
        for(int i=0; i<n; i++){
            String word = words_arr[i];
            int len = word.length();
            if(line_am == 0){
                line_am += len;
                ess += word;
            }
            else if(line_am + len <= k){
                line_am += len;
                ess += " " + word;
            }
            else {
                line_am = len;
                ess += "\n" + word;
            }
        }
        return ess;
    }

    public static ArrayList<String> split(String str){
        ArrayList<String> str_arr = new ArrayList<String>();
        int am = 0;
        int subam = 0;
        String subch = "";
        String substr = "";
        for(int i=0; i<str.length(); i++){
            subch = str.substring(i, i+1);
            if(subch.equals("(")){
                if(am == subam && subam != 0){
                    str_arr.add(substr);
                    am = 1;
                    subam = 0;
                    substr = "";
                }
                else am++;
            }
            else if(subch.equals(")")) subam++;
            substr += subch;
        }
        str_arr.add(substr);
        return str_arr;
    }

    public static String toSnakeCase(String str){
        String newstr = "";
        char ch = ' ';
        for(int i=0; i<str.length(); i++) {
            ch = str.charAt(i);
            if(ch >= 'A' && ch <= 'Z'){
                newstr += "_";
                ch = Character.toLowerCase(ch);
            }
            newstr += ch;
        }
        return newstr;
    }

    public static String toCamelCase(String str){
        String newstr = "";
        char ch = ' ';
        int i = 0;
        while(i<str.length()) {
            ch = str.charAt(i);
            if(str.charAt(i) == '_'){
                i++;
                ch = Character.toUpperCase(str.charAt(i));
            }
            newstr += ch;
            i++;
        }
        return newstr;
    }

    public static String overTime(double[] arr){
        double sum = 0;
        if(arr[1]>17){
            sum = (17-arr[0])*arr[2] + (arr[1]-17)*arr[2]*arr[3];
        }
        else sum = (arr[1]-arr[0])*arr[2];
        return String.format("$%.2f", sum);
    }

    public static String BMI(String str1, String str2){
        double weight = Double.parseDouble(str1.split(" ")[0]);
        double kilo = str1.split(" ")[1].equals("kilos") ? weight : weight*0.453592;
        double height = Double.parseDouble(str2.split(" ")[0]);
        double meter = str2.split(" ")[1].equals("meters") ? height : height*0.0254;

        double res = kilo/(meter*meter);
        String str = "";
        if(res<18.5) str = String.format("%.1f Underweight", res);
        else if(res>25) str = String.format("%.1f Overweight", res);
        else str = String.format("%.1f Normal weight", res);
        return str;
    }

    public static int bugger(int n){
        int am = 0;
        String str = String.valueOf(n);
        int len = str.length();
        while(len > 1){
            am++;
            int subm = 1;
            for(int i=0; i< len; i++){
                subm *= Integer.parseInt(str.substring(i, i+1));
            }
            str = String.valueOf(subm);
            len = str.length();
        }
        return am;
    }

    public static String toStarShorthand(String str){
        if(str.length() < 1) return "";
        String newstr = "";
        String ch = "";
        String oldch = str.substring(0, 1);
        int am = 0;
        for(int i=0; i<str.length(); i++) {
            ch = str.substring(i, i + 1);
            if(ch.equals(oldch)) am++;
            else if(am > 1){
                newstr += oldch + "*" + am;
                am = 1;
            }
            else newstr += oldch;
            oldch = ch;
        }
        newstr += oldch;
        if(am>1) newstr += "*" + am;
        return newstr;
    }

    public static boolean doesRhyme(String str1, String str2){
        String[] arr1 = str1.toLowerCase().split(" ");
        String[] arr2 = str2.toLowerCase().split(" ");
        str1 = arr1[arr1.length-1];
        str2 = arr2[arr2.length-1];
        String check_str = "aeiouy";
        String substr1 = "";
        String substr2 = "";
        String ch = "";
        for(int i=0; i<str1.length(); i++) {
            ch = str1.substring(i, i + 1);
            if(check_str.contains(ch)) substr1 += ch;
        }
        for(int i=0; i<str2.length(); i++) {
            ch = str2.substring(i, i + 1);
            if(check_str.contains(ch)) substr2 += ch;
        }
        return substr1.equals(substr2);
    }

    public static boolean trouble(int num1, int num2){
        String a = String.valueOf(num1);
        String b = String.valueOf(num2);
        String ch = "";
        String oldch = a.substring(0, 1);
        int am = 1;
        for(int i=1; i<a.length(); i++) {
            ch = a.substring(i, i + 1);
            if (ch.equals(oldch)) am++;
            else am = 1;
            if (am > 3) continue;
            if (am > 2) {
                String sub_ch = "";
                String sub_oldch = b.substring(0, 1);
                int sub_am = 1;
                for (int j = 1; j < b.length(); j++) {
                    sub_ch = b.substring(j, j+1);
                    if (ch.equals(sub_ch) && sub_ch.equals(sub_oldch)) sub_am++;
                    else sub_am = 1;
                    if (sub_am > 1) return true;
                    sub_oldch = sub_ch;
                }

            }

            oldch = ch;
        }
        return false;
    }

    public static int countUniqueBooks(String str, char ch_end){
        String end = "" + ch_end;
        int am = 0;
        String uni_list = "";
        String ch = "";
        boolean flag = false;
        for(int i=0; i<str.length(); i++) {
            ch = str.substring(i, i + 1);
            if(ch.equals(end)){
                flag = !flag;
            }
            else if(flag){
                if(!uni_list.contains(ch.toUpperCase())){
                    uni_list += ch.toUpperCase();
                    am++;
                }
            }
        }
        return am;
    }
}
