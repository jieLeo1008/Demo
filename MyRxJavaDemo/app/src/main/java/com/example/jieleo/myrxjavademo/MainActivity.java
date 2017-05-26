package com.example.jieleo.myrxjavademo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import static java.lang.Integer.valueOf;

public class MainActivity extends AppCompatActivity {


    public String[] names = new String[]{"张三", "李四", "王五", "赵六", "囊踹", "姜红", "司帅"};

    public Integer[]  num=new Integer[]{1,2,3,4,5};

    private int resId = R.mipmap.ic_launcher;

    private ImageView mImageView;

    private List<Student> students;

    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = (ImageView) findViewById(R.id.iv_01);
        mProgressBar = (ProgressBar) findViewById(R.id.pb_01);
        students = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            Student student = new Student();
            List<Student.Course> courses = new ArrayList<>();
            if (i % 2 == 1) {
                courses.add(new Student.Course().setName("语文"));
                courses.add(new Student.Course().setName("化学"));
            }
            courses.add(new Student.Course().setName("数学"));
            student.setName(names[i]);
            student.setCourse(courses);
            students.add(student);
        }


        //遍历数组中的元素并打印出来
        Observable.from(names).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.d("MainActivity", s);
            }
        });


//        Observable.create(new Observable.OnSubscribe<Drawable>() {
//            @Override
//            public void call(Subscriber<? super Drawable> subscriber) {
//                Drawable drawable = getTheme().getDrawable(resId);
//                subscriber.onNext(drawable);
//                subscriber.onCompleted();
//            }
//        }).subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<Drawable>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onNext(Drawable drawable) {
//                        mImageView.setImageDrawable(drawable);
//                    }
//                });

        Observable.just(1, 2, 3, 4)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        Log.d("MainActivity", "integer:" + integer);
                    }
                });


        Observable.just(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Download/ccccc.jpg")
                .map(new Func1<String, Bitmap>() {
                    @Override
                    public Bitmap call(String s) {
                        Log.d("MainActivity", s);
                        return getBitmapFromPath(s);
                    }
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()
                ).subscribe(new Action1<Bitmap>() {
            @Override
            public void call(Bitmap bitmap) {
                mImageView.setImageBitmap(bitmap);
            }
        });


        //map 一对一
        Observable.from(students).map(new Func1<Student, String>() {
            @Override
            public String call(Student student) {
                return student.getName();
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Log.d("MainActivity", s);
            }
        });


        Observable.from(students).flatMap(new Func1<Student, Observable<Student.Course>>() {
            @Override
            public Observable<Student.Course> call(Student student) {
                if (student.getName().equals("姜红")){
                return Observable.from(student.getCourse());
                }
                return null;
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<Student.Course>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Student.Course course) {
                Log.d("MainActivity", course.getName());
            }
        });


        Observable observable =Observable.from(num);

        observable.lift(new Observable.Operator<String,Integer>() {

            @Override
            public Subscriber<? super Integer> call(final Subscriber<? super String> subscriber) {
                return new Subscriber<Integer>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("MainActivity", e.toString());
                    }

                    @Override
                    public void onNext(Integer integer) {
                        subscriber.onNext(""+integer);
                    }
                };
            }
        }).map(new Func1<String,Student>() {

            @Override
            public Student call(String s) {

                return new Student().setName(s);
            }
        })
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.d("MainActivity", e.toString());
            }

            @Override
            public void onNext(Object o) {
                Log.d("MainActivity", ((Student) o).getName());
            }
        });



        Subscriber subscriber=new Subscriber<String>() {

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Log.d("MainActivity", s);
            }
        };

        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("你好");
                subscriber.onCompleted();
            }
        }).subscribeOn(Schedulers.io()).doOnSubscribe(new Action0() {
            @Override
            public void call() {
                mImageView.setVisibility(View.GONE);
            }
        }).subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);





    }








    private Bitmap getBitmapFromPath(String s) {
        Bitmap bitmap = BitmapFactory.decodeFile(s);
        return bitmap;
    }


    public static class Student {
        private String name;
        private List<Course> course;

        public String getName() {
            return name;
        }

        public Student setName(String name) {
            this.name = name;
            return this;
        }

        public List<Course> getCourse() {
            return course;
        }

        public Student setCourse(List<Course> course) {
            this.course = course;
            return this;
        }

        static class Course {
            private String name;

            public String getName() {
                return name;
            }

            public Course setName(String name) {
                this.name = name;
                return this;
            }
        }

    }
}
