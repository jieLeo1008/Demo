package com.benny.viewdemo.util.tool;

import com.jieleo.xmly_plus.model.bean.model_search_.SearchBean;

/**
 * Created by liuHao on 17/2/10.
 */
public interface CallBackNew {
    //请求成功后的回调，形参就是我们最后解析好的数据 因为不知道具体的类型，所以我们用T泛型代替
    void onSuccess(SearchBean[] response);

    //失败的回调，形参中我们填写的是异常对象
    void onError(Throwable throwable);

}
