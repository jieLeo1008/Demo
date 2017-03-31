package com.example;

/**
 * Created by OldFour on 2017/3/31.
 */

public class NewClass {

    private String name;
    private int age;

    public NewClass() {
    }

    public NewClass(String name) {
        this.name = name;
    }

    public NewClass(int age) {
        this.age = age;
    }

    public NewClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void bibi(){
        System.out.println("司帅四个囊踹");
    }

    public void  eat(String food,int a){
        System.out.println("司帅中午吃了"+food+"*"+a);
    }
}
