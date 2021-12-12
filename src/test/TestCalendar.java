package test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import main.Calendar;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.GregorianCalendar;

class TestCalendar {
	
	@ParameterizedTest
	@ValueSource(ints = {400, 1664, 1884, 2000, 2016})
	public void Should_return_true(int year) {
		Calendar calendar = new Calendar(year);
		assertEquals(true, calendar.isLeapYear());
	}

	@ParameterizedTest
	@ValueSource(ints = {100, 534, 1630, 1800, 1982})
	public void Should_return_false(int year) {
		Calendar calendar = new Calendar(year);
		assertEquals(false, calendar.isLeapYear());
	}
	
	GregorianCalendar gregorianCalendar = new GregorianCalendar();

	@ParameterizedTest
	@ValueSource(ints = {400,534,1664,1800,2016})
	//year 100 results in failure
	public void Should_return_if_year_is_leap(int year) {
		Calendar calendar = new Calendar(year);
		assertEquals(calendar.isLeapYear(), gregorianCalendar.isLeapYear(year));
	}

	@ParameterizedTest
	@ValueSource(ints = {Integer.MIN_VALUE-1,0,Integer.MAX_VALUE+1})
	public void Should_throw_exception(int year) {
		Calendar calendar = new Calendar(year);
		assertEquals(false, calendar.isLeapYear());
	}
}
