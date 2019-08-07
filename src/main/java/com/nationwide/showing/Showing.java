package com.nationwide.showing;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "showings")
public class Showing {

    @Id
    private String id;
    private String filmId;
    private String time;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getScreenId() {
        return screenId;
    }

    public void setScreenId(String screenId) {
        this.screenId = screenId;
    }

    //public Showing(String id, String filmId, LocalDateTime time, String screenId) {
		public Showing(String filmId, String time, String screenId) {
        //this.id = id;
        this.filmId = filmId;
        this.time = time;
        this.screenId = screenId;
	}

	public Showing(){}

}
