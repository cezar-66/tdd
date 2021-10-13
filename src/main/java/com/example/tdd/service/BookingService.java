package com.example.tdd.service;

import com.example.tdd.model.BookingModel;
import com.example.tdd.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Period;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public Integer daysCalculatorWithDataBase(String name){
        Optional<BookingModel> bookingModelOptional = bookingRepository.findByReserverName(name);
        return Period.between(
                bookingModelOptional.get().getCheckIn(),
                bookingModelOptional.get().getCheckOut())
                .getDays();
    }
}
