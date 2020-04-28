package com.amarjefferson.codeabout.java.classes.samples;

import static org.junit.jupiter.api.Assertions.*;

import java.util.logging.Logger;

import org.junit.jupiter.api.*;

class CollegeCourseTest {

	private Logger myLog = Logger.getLogger(getClass().getName());
	private CollegeCourse myCourse;

	@BeforeEach
	void setUpTestCourse() {
		myCourse = new CollegeCourse();
	}

	@AfterEach
	void clearTestCourse() {
		myCourse = null;
	}

	@Test
	@DisplayName("Default Constructor Test")
	void testConstructor() {
		// perform tests
		assertEquals("Welcome 101", myCourse.courseNumber());
		assertEquals("Orientation", myCourse.courseName());
		assertEquals(10, myCourse.getStudentCount());

		// use logger to display data on the console
		logResult();
	}

	@Test
	@DisplayName("Course Number Input Test")
	void testInputCourseNumber() {
		// perform tests
		assertEquals("Welcome 101", myCourse.courseNumber());
		assertEquals("Orientation", myCourse.courseName());
		assertEquals(10, myCourse.getStudentCount());

		myCourse.inputCourseNumber();

		// use logger to display data on the console
		logResult();
	}

	@Test
	@DisplayName("Course Name Input Test")
	void testInputCourseName() {
		// perform tests
		assertEquals("Welcome 101", myCourse.courseNumber());
		assertEquals("Orientation", myCourse.courseName());
		assertEquals(10, myCourse.getStudentCount());

		myCourse.inputCourseName();

		// use logger to display data on the console
		logResult();
	}

	@Test
	@DisplayName("Student Count Input Test")
	void testInputStudentCount() {
		// perform tests
		assertEquals("Welcome 101", myCourse.courseNumber());
		assertEquals("Orientation", myCourse.courseName());
		assertEquals(10, myCourse.getStudentCount());

		myCourse.inputStudentCount();

		// use logger to display data on the console
		logResult();
	}

	@Test
	@DisplayName("Calculating Average Test")
	void testAverage() {
		// perform tests
		assertEquals("Welcome 101", myCourse.courseNumber());
		assertEquals("Orientation", myCourse.courseName());
		assertEquals(10, myCourse.getStudentCount());

		myCourse.inputMarks();
		myCourse.average();

		// use logger to display data on the console
		myLog.info(myCourse.toString());
	}

	private void logResult() {
		myLog.info("Course: " + myCourse.courseNumber() + " - " + myCourse.courseName() + " ("
				+ myCourse.getStudentCount() + ")");
	}
	
}
