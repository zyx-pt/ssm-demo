package com.zyx.domain;

import java.io.Serializable;

/**
 * <pre>
 * 描述：TODO
 * </pre>
 *
 * @author zhengyx
 * @email zhengyx@gillion.com.cn
 * @date 2020/9/21
 * @time 17:39
 * @description: TODO
 */

public class User implements Serializable {

    private String username;
    private String password;
    private Integer age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
