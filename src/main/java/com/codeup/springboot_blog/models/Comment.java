package com.codeup.springboot_blog.models;

import javax.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long comment_id;

    @Column (columnDefinition = "TEXT", nullable = false)
    private String comment;

    @ManyToOne
    @JoinColumn (name = "author_id", referencedColumnName = "id", nullable = false)
    private User author;

    @ManyToOne
    @JoinColumn (name = "post_id", referencedColumnName = "id", nullable = false)
    private Post post;

    public Comment() {};

    public Comment(long id, String comment, User author, Post post) {
        this.comment_id = id;
        this.comment = comment;
        this.author = author;
        this.post = post;
    }

    public Comment(String comment, User author, Post post) {
        this.comment = comment;
        this.author = author;
        this.post = post;
    }

    public long getId() {
        return comment_id;
    }

    public void setId(long id) {
        this.comment_id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
