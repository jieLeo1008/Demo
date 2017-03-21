package com.example;

import java.util.ArrayList;
import java.util.List;

import rx.*;
import rx.Observer;
import rx.functions.Func1;

public class MyClass {

    public  static  void  main(String[]  args){
//        Company company=new Company();
//        Person person =new Person(company);
//        company.setData("今天的报纸");
//            NewCompany newCompany =new NewCompany();
//            NewPerson newPerson=new NewPerson(newCompany);
//            newCompany.setData("更新数据");





//        Observable<String>   observable =Observable.create(subscriber -> subscriber.onNext("刘浩"));
//
//        rx.Observer <String>  observer=new Observer<String>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            /**
//             * 任何错误都会走
//             * @param e
//             */
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            /**
//             * 主要使用
//             * @param s
//             */
//            @Override
//            public void onNext(String s) {
//                System.out.println(s);
//            }
//        };
//
//        observable.subscribe(observer);
//
//
//        Observable.just("刘浩").subscribe(s -> System.out.println(s));
        MyClass myClass =new MyClass();
        myClass.getMessage();
    }




    public Observable<List<String>> search(String url){
        List<String>  list =new ArrayList<>();
        list.add("百度"+url);
        list.add("腾讯");
        list.add("阿里巴巴"+url);
        list.add("快播");
        return Observable.just(list);
    }


    public  void getMessage(){
        search("姜弘").
                //flatMap这个操作符的用处是将Observable拆分开来，一个一个的执行
                        //Observable.from(strings)遍历集合的方法
                flatMap((Func1<List<String>, Observable<?>>) strings -> Observable.from(strings))
                //过滤器  过滤"百度姜弘" 不显示
                .filter(s->!s.equals("百度姜弘"))
                //设置显示的数量
                .take(3)

                .subscribe(string->System.out.println(string));
    }

}
