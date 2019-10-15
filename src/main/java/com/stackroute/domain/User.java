package com.stackroute.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "music")
public class User {
    public User(int id, String name, String singer, String film, String comments) {
        this.id = id;
        Name = name;
        this.singer = singer;
        this.film = film;
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", singer='" + singer + '\'' +
                ", film='" + film + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }

    @Id
    private int id;
    private String Name;
    private String singer;
    private String film;

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    private String comments;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }



    public User() {
    }




}
