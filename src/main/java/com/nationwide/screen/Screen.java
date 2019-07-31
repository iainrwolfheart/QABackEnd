package com.nationwide.screen;

import java.util.Arrays;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "screens")
public class Screen {

    @Id
    private String id;
    private Arrays seats;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Arrays getSeats() {
        return seats;
    }

    public void setSeats(Arrays seats) {
        this.seats = seats;
    }

    public Screen(String id, Arrays seats) {
        this.id = id;
        this.seats = seats;
    }
}