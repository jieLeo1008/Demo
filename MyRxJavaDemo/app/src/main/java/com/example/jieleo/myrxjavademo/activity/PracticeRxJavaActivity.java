package com.example.jieleo.myrxjavademo.activity;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.jieleo.myrxjavademo.PersonBean;
import com.example.jieleo.myrxjavademo.R;
import com.example.jieleo.myrxjavademo.TestBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.observables.GroupedObservable;
import rx.schedulers.Schedulers;

public class PracticeRxJavaActivity extends AppCompatActivity {

    private List<TestBean> mTestBeanList;

    private List<Integer>  mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_rx_java);
        mTestBeanList = new ArrayList<>();
        mList=new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            mList.add(i);
            if (i % 2 == 0) {
                List<TestBean.House> houseList = new ArrayList<>();
                for (int j = 0; j < 7; j++) {
                    if (j % 2 == 0) {
                        TestBean.House house = new TestBean.House("小明", 100);
                        houseList.add(house);
                    } else {
                        TestBean.House house = new TestBean.House("小马", 300);
                        houseList.add(house);

                    }
                }
                TestBean testBean = new TestBean("刘浩", 200, houseList);
                mTestBeanList.add(testBean);
            } else {
                List<TestBean.House> houseList = new ArrayList<>();
                for (int j = 0; j < 5; j++) {
                    TestBean.House house = new TestBean.House("小马", 50);
                    houseList.add(house);
                }
                TestBean testBean = new TestBean("司帅", 100, houseList);
                mTestBeanList.add(testBean);
            }
        }
//        flatMapUse(mTestBeanList);
//        groupByUse();
//        filterUse();
//        takeUse();
//        takeUtilsUse();
//        distinctUse();
//        mergeUse();
//        combLineLatest();
        joinUse();
//        getApps();
    }



    private void createObserver() {
        //创建观察者Observer
        Observer<Object> observer = new Observer<Object>() {
            @Override
            public void onCompleted() {
                Log.d("PracticeRxJavaActivity", "onCompleted");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Object o) {

            }
        };
    }


    private void createObservable() {
        //创建被观察者
        Observable<Object> observable = Observable.create(new Observable.OnSubscribe<Object>() {
            @Override
            public void call(Subscriber<? super Object> subscriber) {

            }
        });
    }


    private void justUse() {
        Observable observable = Observable.just("one", "two", "three");
        observable.subscribe(new Observer() {
            @Override
            public void onCompleted() {
                Log.d("PracticeRxJavaActivity", "onCompleted");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Object o) {
                Log.d("PracticeRxJavaActivity", o.toString());
            }
        });
    }


    private void justCreate() {
        Observable.create(new Observable.OnSubscribe<Integer>() {

            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                for (int i = 0; i < 5; i++) {
                    subscriber.onNext(i);
                }

                subscriber.onCompleted();
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onCompleted() {
                Log.d("PracticeRxJavaActivity", "onComplete");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer integer) {
                Log.d("PracticeRxJavaActivity", "integer:" + integer);
            }
        });
    }


    private void mapUse() {
        //将传入的值转换为我们期望的值
        Observable.just(1, 2, 3, 4)
                .map(new Func1<Integer, String>() {
                    @Override
                    public String call(Integer integer) {
                        return "This is " + integer;
                    }
                }).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Log.d("PracticeRxJavaActivity", s);
            }
        });
    }

    private void flatMapUse(List<TestBean> testBeen) {
        Observable.from(testBeen)
                .map(new Func1<TestBean, String>() {
                    @Override
                    public String call(TestBean testBean) {
                        return testBean.getName();
                    }
                }).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Log.d("PracticeRxJavaActivity", s);
            }
        });

//         flatMap的使用
        Observable.from(mTestBeanList)
                .flatMap(new Func1<TestBean, Observable<TestBean.House>>() {

                    @Override
                    public Observable<TestBean.House> call(TestBean testBean) {
                        return Observable.from(testBean.getList());
                    }
                }).subscribe(new Subscriber<TestBean.House>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(TestBean.House house) {
                Log.d("PracticeRxJavaActivity", house.getName());
            }
        });


//        flatMapIterable 的使用
        Observable.from(testBeen)
                .flatMapIterable(new Func1<TestBean, Iterable<TestBean.House>>() {

                    @Override
                    public Iterable<TestBean.House> call(TestBean testBean) {
                        return testBean.getList();
                    }
                }).subscribe(new Action1<TestBean.House>() {
            @Override
            public void call(TestBean.House house) {
                Log.d("PracticeRxJavaActivity", house.getName());
            }
        });

//        switchMap
        Observable.from(testBeen)
                .switchMap(new Func1<TestBean, Observable<TestBean.House>>() {

                    @Override
                    public Observable<TestBean.House> call(TestBean testBean) {
                        return Observable.from(testBean.getList());
                    }
                }).subscribe(new Action1<TestBean.House>() {
            @Override
            public void call(TestBean.House house) {
                Log.d("PracticeRxJavaActivity", house.getName());
            }
        });


        Observable.just("1", "2", "3", "4", "5")
                .scan(new Func2<String, String, String>() {
                    @Override
                    public String call(String s, String s2) {
                        return s + s2;
                    }
                }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.d("PracticeRxJavaActivity", s);
            }
        });

        Observable.from(testBeen)
                .scan(new Func2<TestBean, TestBean, TestBean>() {
                    @Override
                    public TestBean call(TestBean testBean, TestBean testBean2) {
                        return testBean2;
                    }
                }).subscribe(new Action1<TestBean>() {
            @Override
            public void call(TestBean testBean) {
                Log.d("PracticeRxJavaActivity", testBean.getName());
            }
        });

    }


    private void groupByUse() {
//        Observable<GroupedObservable<String, TestBean.House>> groupedObservableObservable = Observable.from(mTestBeanList.get(0).getList())
//                .groupBy(new Func1<TestBean.House, String>() {
//                    @Override
//                    public String call(TestBean.House house) {
//                        return house.getName();
//                    }
//                });
//
//        Observable.concat(groupedObservableObservable)
//                .subscribe(new Action1<TestBean.House>() {
//                    @Override
//                    public void call(TestBean.House house) {
//                        Log.d("PracticeRxJavaActivity", house.getName());
//                    }
//                });


        Observable.concat(Observable.from(mTestBeanList.get(0).getList()).groupBy(new Func1<TestBean.House, String>() {
            @Override
            public String call(TestBean.House house) {
                return house.getName();
            }
        })).subscribe(new Action1<TestBean.House>() {
            @Override
            public void call(TestBean.House house) {
                Log.d("PracticeRxJavaActivity", house.getName());
            }
        });

        Observable.concat(Observable.from(mTestBeanList.get(0).getList()).groupBy(new Func1<TestBean.House, Integer>() {
            @Override
            public Integer call(TestBean.House house) {
                return house.getPrice();
            }
        })).subscribe(new Action1<TestBean.House>() {
            @Override
            public void call(TestBean.House house) {
                Log.d("PracticeRxJavaActivity", "house.getPrice():" + house.getPrice());
            }
        });
    }


    private void filterUse(){
        Observable.just(mTestBeanList.get(1).getList())
                .filter(new Func1<List<TestBean.House>, Boolean>() {
                    @Override
                    public Boolean call(List<TestBean.House> houses) {
                        return houses.size()>0;
                    }
                }).subscribe(new Action1<List<TestBean.House>>() {
            @Override
            public void call(List<TestBean.House> houses) {
                for (TestBean.House house : houses) {
                    Log.d("PracticeRxJavaActivity", house.getName());
                }
            }
        });



        Observable.from(mList)
                .filter(new Func1<Integer, Boolean>() {
                    @Override
                    public Boolean call(Integer integer) {
                        return integer>3;
                    }
                }).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                Log.d("PracticeRxJavaActivity", "integer:" + integer);
            }
        });
    }

    private void takeUse(){
        Observable.from(mList)
                .take(3).filter(new Func1<Integer, Boolean>() {
            @Override
            public Boolean call(Integer integer) {
                return integer>1;
            }
        }).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                Log.d("PracticeRxJavaActivity", "integer:" + integer);
            }
        });
    }

    private void takeUtilsUse(){
        Observable<Long>  observableA =Observable.interval(2000, TimeUnit.MILLISECONDS);
        Observable<Long>  observableD =Observable.interval(9000, TimeUnit.MILLISECONDS);

        observableA.takeUntil(observableD)
                .subscribe(new Subscriber<Long>() {
                    @Override
                    public void onCompleted() {
                        Log.d("PracticeRxJavaActivity", "print:" + 0);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Long aLong) {
                        Log.d("PracticeRxJavaActivity", "print:" + aLong);
                    }
                });
    }

    private void distinctUse(){
        mList.add(4);
        //Distinct()
        Observable.from(mList).distinct()
                .map(new Func1<Integer, String>() {
                    @Override
                    public String call(Integer integer) {
                        return integer+"    ";
                    }
                }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.d("PracticeRxJavaActivity", s);
            }
        });
        //Distinct(Func)
        Observable.from(mTestBeanList).distinct(new Func1<TestBean, String>() {
            @Override
            public String call(TestBean testBean) {
                return testBean.getName();
            }
        }).subscribe(new Action1<TestBean>() {
            @Override
            public void call(TestBean testBean) {
                Log.d("PracticeRxJavaActivity", testBean.getName());
            }
        });


        //DistinctUntilChanged()
        Observable.from(mList).distinctUntilChanged().map(new Func1<Integer, Integer>() {
            @Override
            public Integer call(Integer integer) {
                return integer;
            }
        }).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                Log.d("PracticeRxJavaActivity", "integer:" + integer);
            }
        });

        //DistinctUntilChanged(Func)
        Observable.from(mTestBeanList.get(1).getList())
                .distinctUntilChanged(new Func1<TestBean.House, String>() {
                    @Override
                    public String call(TestBean.House house) {
                        return house.getName();
                    }
                }).subscribe(new Action1<TestBean.House>() {
            @Override
            public void call(TestBean.House house) {
                Log.d("PracticeRxJavaActivity", house.getName());
            }
        });
    }


    private void mergeUse(){
        final String[]  letters =new String[]{"A","B","C","D","E","F"};
        final Integer[]  num =new Integer[]{1,2,3,4,5,6};
        Observable<String> observable =Observable.interval(300,TimeUnit.MILLISECONDS)
                .map(new Func1<Long, String>() {
                    @Override
                    public String call(Long aLong) {
                        return letters[aLong.intValue()];
                    }
                }).take(letters.length);
        Observable<Long>  observable1 =Observable.interval(300,TimeUnit.MILLISECONDS).take(6);
//        Observable.merge(observable,observable1)
//                .subscribe(new Action1<Serializable>() {
//                    @Override
//                    public void call(Serializable serializable) {
//                        Log.d("PracticeRxJavaActivity", serializable.toString());
//                    }
//                });

        Observable<String>  observable2 =Observable.from(letters)
                .map(new Func1<String, String>() {
                    @Override
                    public String call(String s) {
                        return s;
                    }
                });
        Observable<Integer> observable3 =Observable.from(num)
                .map(new Func1<Integer, Integer>() {
                    @Override
                    public Integer call(Integer integer) {
                        return integer;
                    }
                });

        Observable[] observables =new Observable[]{observable2,observable3};
//        Observable.merge(observables)
//                .subscribe(new Action1() {
//                    @Override
//                    public void call(Object o) {
//                        Log.d("PracticeRxJavaActivity", o.toString());
//                    }
//                });
//

        //Zip
        Observable.zip(observable2, observable3, new Func2<String, Integer, String>() {
            @Override
            public String call(String s, Integer integer) {
                return s+integer;
            }
        }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.d("PracticeRxJavaActivity", s);
            }
        });




    }


    private void combLineLatest(){
        final String[] letters =new String[]{"A","B","C","D","E","F"};
        Observable<String> observable =Observable.interval(1,TimeUnit.SECONDS)
                .map(new Func1<Long, String>() {
                    @Override
                    public String call(Long aLong) {
                        return letters[aLong.intValue()];
                    }
                }).take(letters.length);
        Observable<Long> observable1 =Observable.interval(300,TimeUnit.MILLISECONDS).take(20);

        Observable.combineLatest(observable, observable1, new Func2<String, Long, String>() {
            @Override
            public String call(String s, Long aLong) {
                Log.d("PracticeRxJavaActivity", "aLong.intValue():" + aLong.intValue());
                return s+aLong.intValue();
            }
        }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.d("PracticeRxJavaActivity", s);
            }
        });

        Log.d("PracticeRxJavaActivity", "Calendar.getInstance().get(Calendar.DAY_OF_WEEK):" + Calendar.getInstance().get(Calendar.DAY_OF_WEEK));
    }


    private void joinUse(){

        final List<TestBean.House>  houses =mTestBeanList.get(0).getList();
        Observable<TestBean.House> houseObservable =Observable.interval(1,TimeUnit.SECONDS)
                .map(new Func1<Long, TestBean.House>() {
                    @Override
                    public TestBean.House call(Long aLong) {
                        return houses.get(aLong.intValue());
                    }
                }).take(houses.size());
        Observable<Long>  longObservable =Observable.interval(1,TimeUnit.SECONDS);
        houseObservable.join(longObservable, new Func1<TestBean.House, Observable<Long>>() {

            @Override
            public Observable<Long> call(TestBean.House house) {
                return Observable.timer(2, TimeUnit.SECONDS);
            }
        }, new Func1<Long, Observable<Long>>() {

            @Override
            public Observable<Long> call(Long aLong) {
                return Observable.timer(0, TimeUnit.SECONDS);
            }
        }, new Func2<TestBean.House, Long, String>() {
            @Override
            public String call(TestBean.House house, Long aLong) {
                return aLong.intValue()+"---->"+house.getName();
            }
        })
//                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.d("PracticeRxJavaActivity", s);
            }
        });

    }


    private void getApps(){
        PackageManager pm =this.getPackageManager();
        List<ApplicationInfo> applicationInfos =pm.getInstalledApplications(PackageManager.GET_UNINSTALLED_PACKAGES);
        for (ApplicationInfo applicationInfo : applicationInfos) {
            Log.d("PracticeRxJavaActivity", applicationInfo.loadLabel(pm).toString());
        }
        Log.d("PracticeRxJavaActivity", "applicationInfos.size():" + applicationInfos.size());
    }


}
