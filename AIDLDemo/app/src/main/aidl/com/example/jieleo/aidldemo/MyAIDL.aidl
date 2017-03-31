// MyAIDL.aidl
package com.example.jieleo.aidldemo;
//手动导包
import com.example.jieleo.aidldemo.person;
// Declare any non-default types here with import statements

interface MyAIDL {

        void getData();
        void addPerson(in Person person);
        List<Person> getList();
}
