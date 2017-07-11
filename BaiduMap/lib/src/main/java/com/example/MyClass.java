package com.example;

public class MyClass {



    public static void main(String[] args){
        System.out.println(new MyClass().getPoi(116.408298,39.929616));
    }


    public String getPoi(double a,double b){
        double x=a*20037508.34/180/Math.pow(2,18-21)/256;
        double y =Math.log(Math.tan((90+b)*Math.PI/360))/(Math.PI/180);
        y = y *20037508.34/180/(Math.pow(2,18-21))/256;
        return "x="+x+"y="+y;
    }


}
