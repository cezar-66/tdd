package com.example.tdd;

import com.example.tdd.model.BookingModel;
import com.example.tdd.repository.BookingRepository;
import com.example.tdd.service.BookingService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
public class BookingServiceTest {

    @Autowired
    private BookingService bookingService;

    @MockBean
    private BookingRepository bookingRepository;

    @Before
    public void setup(){
        LocalDate checkIn = LocalDate.parse("2021-10-01");
        LocalDate checkOut = LocalDate.parse("2021-10-11");
        BookingModel bookingModel = new BookingModel(1, "Cezar", checkIn, checkOut, 2);

        Mockito.when(bookingRepository.findByReserverName(bookingModel.getReserverName()))
                .thenReturn(java.util.Optional.of(bookingModel));
    }

    @TestConfiguration
    static class BookingServiceTestConfiguration {
        @Bean
        public BookingService bookingService(){
            return new BookingService();
        }
    }

    @Test
    public void bookingTestServiceDaysCalculator(){
        String name = "Cezar";
        Integer days = bookingService.daysCalculatorWithDataBase(name);
        Assertions.assertEquals(days, 10);
    }

}
