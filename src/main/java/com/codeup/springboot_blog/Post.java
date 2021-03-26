package com.codeup.springboot_blog;

import com.mysql.cj.protocol.ColumnDefinition;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column (nullable = false, length = 255)
    private String title;

    @Column (columnDefinition = "TEXT", nullable = false)
    private String body;

//    @Column (columnDefinition="created_time datetime default CURRENT_TIMESTAMP null")
//    @Column
    private Date created_on;
//
////    @Column (columnDefinition = "modified_time datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP")
    private Date modified_on;
//
//    private SimpleDateFormat sdf = new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss");

    public Post(){};

    public Post(long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Post(long id, String title, String body, Date created_on, Date modified_on) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.created_on = created_on;
        this.modified_on = modified_on;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getCreated_on() {
        return created_on;
    }

    public void setCreated_on(Date created_on) {
        this.created_on = created_on;
    }

    public Date getModified_on() {
        return modified_on;
    }

    public void setModified_on(Date modified_on) {
        this.modified_on = modified_on;
    }

//    public SimpleDateFormat getSdf() {
//        return sdf;
//    }


}
