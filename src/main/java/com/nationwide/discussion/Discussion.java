package com.nationwide.discussion;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "discussions")
public class Discussion {

    @Id
    private String id;
    private String userName;
    private String movieName;
    private String comments;
    private String rating;
    private String datePosted;

    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getDatePosted() {
		return datePosted;
	}
	public void setDatePosted(String datePosted) {
		this.datePosted = datePosted;
	}

	public Discussion () {}

	public Discussion(String id, String userName, String movieName, String comments, String rating, String datePosted) {
		this.id = id;
		this.userName = userName;
		this.movieName = movieName;
		this.comments = comments;
		this.rating = rating;
		this.datePosted = datePosted;
	}
}
