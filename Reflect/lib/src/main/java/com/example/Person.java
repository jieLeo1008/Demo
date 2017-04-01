package com.example;

/**
 * Created by OldFour on 2017/4/1.
 */

public class Person {
    private String name;
    private int age;
    private double height;
    private double weight;

    public Person() {
    }

    public Person(Builder builder) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
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

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    static  class Builder{
        private String name;
        private int age;
        private double height;
        private double weight;

        public String getName() {
            return name;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public int getAge() {
            return age;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public double getHeight() {
            return height;
        }

        public Builder height(double height) {
            this.height = height;
            return this;
        }

        public double getWeight() {
            return weight;
        }

        public Builder weight(double weight) {
            this.weight = weight;
            return this;
        }

        public Person build(){
            return new Person(this);
        }
    }
}
