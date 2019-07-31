package com.nationwide.screen;

import java.util.List;
import java.sql.Array;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "screens")
public class Screen {

    @Id
    private String id;
    private List<List<String>> seats;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<List<String>> getSeats() {
        return seats;
    }

    public void setSeats(List<List<String>> seats) {
        this.seats = seats;
    }

    public Screen(String id, List<List<String>> seats) {
        this.id = id;
        this.seats = seats;
    }
}