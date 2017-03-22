package com.jieleo.liteorm;

import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.enums.AssignType;

/**
 * Created by yuyongjie on 17/3/22.
 */

@Table("MyTable")
public class Bean  {
    @PrimaryKey(AssignType.AUTO_INCREMENT)
    private int id;
    private String name;
    private int age;
    private String sex;

    public Bean(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public Bean setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Bean setAge(int age) {
        this.age = age;
        return this;
    }

    public String getSex() {
        return sex;
    }

    public Bean setSex(String sex) {
        this.sex = sex;
        return this;
    }
}
