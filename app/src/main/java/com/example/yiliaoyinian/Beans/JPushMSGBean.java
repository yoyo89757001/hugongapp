package com.example.yiliaoyinian.Beans;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class JPushMSGBean {

    @Id(assignable = true)
    private Long id;
    private String message;
    private int count;
    private long time;
    private long time2;//根据这个时间，超过一星期删除

    public long getTime2() {
        return time2;
    }

    public void setTime2(long time2) {
        this.time2 = time2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
