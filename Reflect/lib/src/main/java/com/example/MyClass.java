package com.example;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class MyClass {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException, NoSuchFieldException {
//        MyClass myClass=new MyClass();
//        System.out.print(myClass.getClass().getName());
        //第一种方式
        Class<?> classOne=Class.forName("com.example.NewClass");
//        //第二种方式
//        Class<?> classTwo=NewClass.class;
//        //第三种方式
//        Class<?> classThree=new NewClass().getClass();
//        System.out.print("第一种"+classOne.getName()+"第二种"+classTwo.getName()+"第三种"+classThree.getName());

//        Constructor<?> constructor[] =classOne.getConstructors();
//        for (int i = 0; i < constructor.length; i++) {
//            /**
//             * 得到所有方法的参数类型
//             */
//            Class<?> type[]=constructor[i].getParameterTypes();
//            for (int i1 = 0; i1 < type.length; i1++) {
//                System.out.println(type[i1].getName());
//            }
//        }
//
//        NewClass newClass= (NewClass) constructor[0].newInstance("姓名",100);
//        System.out.println(newClass.getName()+"   "+newClass.getAge());
//
//        //获取类的属性
//        Field field[] =classOne.getDeclaredFields();
//        for (int i = 0; i < field.length; i++) {
//            //权限修饰符
//            int typeNum=field[i].getModifiers();
//            //权限修饰符转化为String类型
//            String type= Modifier.toString(typeNum);
//
//            Class<?> xType=field[i].getType();
//
//            System.out.println(type+" "+xType);
//        }

//        //获取类的所有方法
//        Method method[] =classOne.getMethods();
//        for (int i = 0; i < method.length; i++) {
//            int type=method[i].getModifiers();
//            String xType=Modifier.toString(type);
//            //返回值类型
//            Class<?>  returnType=method[i].getReturnType();
//            System.out.println(xType+"   "+returnType+"  "+method[i].getName());
//        }
//


//        //调用方法
//        Method method=classOne.getMethod("bibi");
//
//        method.invoke(classOne.newInstance());
//
//        Method method1=classOne.getMethod("eat",String.class,int.class);
//
//        method1.invoke(classOne.newInstance(),"姜红",10);


//        //修改修饰符为private类型的变量
//        Object object=classOne.newInstance();
//        //获取name的属性
//        Field field=classOne.getDeclaredField("name");
//        //设置可以访问到
//        field.setAccessible(true);
//        field.set(object,"修改的内容");
//        System.out.println(field.getName()+"   "+field.get(object));
//

        ArrayList<Integer>  list=new ArrayList<>();
        Method method=list.getClass().getMethod("add",Object.class);
        method.invoke(list,"我是添加的字符串");
        System.out.println(list.get(0));

        /**
         * 建造者模式
         * 链式编程
         */
        Person.Builder builder=new Person.Builder();
        builder.name("刘浩").age(100).height(100.0).weight(200.2).build();
        System.out.println("name"+builder.getName()+"age"+builder.getAge()+"height"+builder.getHeight()+"weight"+builder.getWeight());


    }
}
