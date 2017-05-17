package com.example.jieleo.huanxin.bean;

import java.util.List;

/**
 * Created by OldFour on 2017/5/12.
 */

public class MyChatBean {

    private String contactName;

    private ContactMsg mContactMsg;

    public String getContactName() {
        return contactName;
    }

    public MyChatBean setContactName(String contactName) {
        this.contactName = contactName;
        return this;
    }

    public ContactMsg getContactMsg() {
        return mContactMsg;
    }

    public MyChatBean setContactMsg(ContactMsg contactMsg) {
        mContactMsg = contactMsg;
        return this;
    }

    public static class ContactMsg{
        private long  CurrentTimes;
        private String msg;
        private int Type;

        public long getCurrentTimes() {
            return CurrentTimes;
        }

        public ContactMsg setCurrentTimes(long currentTimes) {
            CurrentTimes = currentTimes;
            return this;
        }

        public String getMsg() {
            return msg;
        }

        public ContactMsg setMsg(String msg) {
            this.msg = msg;
            return this;
        }

        public int getType() {
            return Type;
        }

        public ContactMsg setType(int type) {
            Type = type;
            return this;
        }
    }

}
