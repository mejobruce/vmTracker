package com.mtm.utils;



import java.util.*;
import java.text.*;

public class DateToWords{
String string;
String st1[] = { "", "one", "two", "three", "four", "five", "six", "seven",
"eight", "nine", };
String st2[] = { "hundred", "thousand"};
String st3[] = { "ten", "eleven", "twelve", "thirteen", "fourteen",
"fifteen", "sixteen", "seventeen", "eighteen", "ninteen", };
String st4[] = { "twenty", "thirty"};

public String getMonth(int month) {
return new DateFormatSymbols().getMonths()[month-1];
}

public String convert(int number){
int n = 1;
int word;
string = "";
while (number != 0) {
switch (n) {
case 1:
word = number % 100;
pass(word);
if (number > 100 && number % 100 != 0) {
show("and ");
}
number /= 100;
break;

case 2:
word = number % 10;
if (word != 0) {
show(" ");
show(st2[0]);
show(" ");
pass(word);
}
number /= 10;
break;

case 3:
word = number % 100;
if (word != 0) {
show(" ");
show(st2[1]);
show(" ");
pass(word);
}
number /= 100;
break;

case 4:
word = number % 100;
if (word != 0) {
show(" ");
show(st2[2]);
show(" ");
pass(word);
}
number /= 100;
break;

case 5:
word = number % 100;
if (word != 0) {
show(" ");
show(st2[3]);
show(" ");
pass(word);
}
number /= 100;
break;

}
n++;
}
return string;
}

public void pass(int number) {
int word, q;
if (number < 10) {
show(st1[number]);
}
if (number > 9 && number < 20) {
show(st3[number - 10]);
}
if (number > 19) {
word = number % 10;
if (word == 0) {
q = number / 10;
show(st4[q - 2]);
} else {
q = number / 10;
show(st1[word]);
show(" ");
show(st4[q - 2]);
}
}
}
public void show(String s) {
String st;
st = string;
string = s;
string += st;
}

/*public static void main(String[] args) {
	System.out.println(date2Words());
}*/

public  String date2Words() {
DateToWords num = new DateToWords();
Calendar cal = Calendar.getInstance();
Date d=new Date();
cal.setTime(d);
int day = cal.get(Calendar.DATE);
int month = cal.get(Calendar.MONTH) + 1;
int year = cal.get(Calendar.YEAR);
System.out.println("Today's Date is: "+d.toString());
return num.getMonth(month)+" "+num.convert(day)+" "+num.convert(year);
}
}
