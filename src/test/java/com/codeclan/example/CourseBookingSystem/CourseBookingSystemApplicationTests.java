package com.codeclan.example.CourseBookingSystem;

import com.codeclan.example.CourseBookingSystem.models.Booking;
import com.codeclan.example.CourseBookingSystem.models.Course;
import com.codeclan.example.CourseBookingSystem.models.Customer;
import com.codeclan.example.CourseBookingSystem.repositories.BookingRepository;
import com.codeclan.example.CourseBookingSystem.repositories.CourseRepository;
import com.codeclan.example.CourseBookingSystem.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class CourseBookingSystemApplicationTests {

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void canFindCourseByRating() {
		List<Course> found = courseRepository.findByRating(4);
		assertEquals(1, found.size());
	}

	@Test
	void canFindBookingByDate() {
		List<Booking> found = bookingRepository.findByDate("08-06-2020");
		assertEquals(1, found.size());
	}

	@Test
	void canFindCustomersWithSpecificCourse() {
		List<Customer> found = customerRepository.findByBookingsCourseName("Intro to Python");
		assertEquals(1, found.size());
	}

	@Test
	void canFindCoursesWithSpecificCustomer() {
		List<Course> found = courseRepository.findByBookingsCustomerName("Michael");
		assertEquals(1, found.size());
	}

}
