package com.codeclan.example.CourseBookingSystem.components;

import com.codeclan.example.CourseBookingSystem.models.Booking;
import com.codeclan.example.CourseBookingSystem.models.Course;
import com.codeclan.example.CourseBookingSystem.models.Customer;
import com.codeclan.example.CourseBookingSystem.repositories.BookingRepository;
import com.codeclan.example.CourseBookingSystem.repositories.CourseRepository;
import com.codeclan.example.CourseBookingSystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CustomerRepository customerRepository;

    public DataLoader() {

    }

    public void run(ApplicationArguments args) {
        Customer customer1 = new Customer("Michael", "Glasgow", 31);
        customerRepository.save(customer1);

        Customer customer2 = new Customer("Sophie", "Glasgow", 33);
        customerRepository.save(customer2);

        Course course1 = new Course("Intro to Python", "Glasgow", 4);
        courseRepository.save(course1);

        Course course2 = new Course("Cryptography", "Edinburgh", 5);
        courseRepository.save(course2);

        Booking booking1 = new Booking("08-06-2020", customer1, course1);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("20-07-2020", customer2, course2);
        bookingRepository.save(booking2);
    }
}
