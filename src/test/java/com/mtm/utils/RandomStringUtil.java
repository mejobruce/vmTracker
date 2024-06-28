package com.mtm.utils;

import java.util.*;
  
public class RandomStringUtil
{
  
static int MAX = 26;
public static String randWord="";  
// Returns a String of random alphabets of
// length n.
static String printRandomString(int n)
{
    char []alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g',
                        'h', 'i', 'j', 'k', 'l', 'm', 'n', 
                        'o', 'p', 'q', 'r', 's', 't', 'u',
                        'v', 'w', 'x', 'y', 'z' };
  
    String res = "";
    for (int i = 0; i < n; i++) 
        res = res + alphabet[(int) (Math.random() * 100 % MAX)];
      
    return res;
}
  
// Driver code
//public static void main(String[] args)
public RandomStringUtil()
{
    int n = 15;
    randWord=printRandomString(n);
    System.out.print("Auto Generated 15 letter word : "+randWord);
    //return randWord;
    		
}

}