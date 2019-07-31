package com.nationwide.showing;

import java.sql.Timestamp;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "showings")
public class Showing {

    @Id
    private String id;
    private String filmId;
    private Timestamp time;
    private String screenId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFilmId() {
        return filmId;
    }

    public void setFilmId(String filmId) {
        this.filmId = filmId;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getScreenId() {
        return screenId;
    }

    public void setScreenId(String screenId) {
        this.screenId = screenId;
    }

    public Showing(String id, String filmId, Timestamp time, String screenId) {
        this.id = id;
        this.filmId = filmId;
        this.time = time;
        this.screenId = screenId;
    }
}