package com.example;

import java.util.*;

/**
 * Created by yuyongjie on 17/3/20.
 */


public class NewPerson implements java.util.Observer {
    private String data;

    public NewPerson(NewCompany  newCompany) {
        newCompany.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object o) {
        NewCompany newCompany= (NewCompany) observable;
        System.out.print(newCompany.getData());
    }
}
