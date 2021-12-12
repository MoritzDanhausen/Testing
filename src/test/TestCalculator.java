package test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import main.Calculator;


class TestCalculator {

	Calculator calculator = new Calculator();

	@Test
	public void Should_add_two_numbers_and_return_result() {
		assertEquals(2, calculator.add(1, 1));
	}

	@ParameterizedTest
	@CsvSource(value = { "2,2", "3,1", "1,3", "4,0", "6,-2" })
	public void Should_add_two_numbers_and_return_result_parameterized(int valueOne, int valueTwo) {
		assertEquals(4, calculator.add(valueOne, valueTwo),"result does not equal 4");
	}
	
	@Test
	public void Should_substract_two_numbers_and_return_result() {
		assertEquals(-2, calculator.sub(-5, -3));
	}
	
	@Test
	public void Should_multiply_two_numbers_and_return_result() {
		assertEquals(-12, calculator.multiply(4, -3));
	}
	
	@Test
	public void Should_divide_two_numbers_and_return_result() {
		assertEquals(4, calculator.divide(-8, -2));
	}
	
	@Test
	public void Should_throw_an_arithmetic_exception_if_denominator_is_zero() {
        Exception exception = assertThrows(ArithmeticException.class, () ->
        calculator.divide(1, 0));
		assertEquals("/ by zero", exception.getMessage());
	}
}
