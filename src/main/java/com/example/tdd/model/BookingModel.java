package com.example.tdd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class BookingModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String reserverName;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private Integer numberGuest;

    public BookingModel(){}

    public BookingModel(Integer id, String reserverName, LocalDate checkIn, LocalDate checkOut, Integer numberGuest) {
        this.id = id;
        this.reserverName = reserverName;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.numberGuest = numberGuest;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReserverName() {
        return reserverName;
    }

    public void setReserverName(String reserverName) {
        this.reserverName = reserverName;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public Integer getNumberGuest() {
        return numberGuest;
    }

    public void setNumberGuest(Integer numberGuest) {
        this.numberGuest = numberGuest;
    }


}
