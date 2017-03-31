package com.example.jieleo.aidldemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jieleo on 2017/3/29.
 */

public class MyService extends Service {
    private MyBinder mBinder=new MyBinder();

    private List<Person> mPersons;
    @Override
    public void onCreate() {
        super.onCreate();
        mPersons=new ArrayList<>();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    class MyBinder extends MyAIDL.Stub{

        @Override
        public void getData() throws RemoteException {
            Log.d("MyBinder", "服务里的内容");
        }

        @Override
        public void addPerson(Person person) throws RemoteException {
            mPersons.add(person);
        }

        @Override
        public List<Person> getList() throws RemoteException {
            for (Person person : mPersons) {
                Log.d("MyBinder", person.getName() + "   " + person.getAge());
            }
            return null;
        }
    }
}
