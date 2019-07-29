package com.nationwide.screen;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Screen {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private Arrays seats;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Arrays getSeats() {
        return seats;
    }

    public void setSeats(Arrays seats) {
        this.seats = seats;
    }
}