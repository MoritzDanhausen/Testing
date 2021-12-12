package main;

public class FizzBuzz {
	
	public String convertNumber(int number) {
		var result = "";
		if (number % 5 == 0 && number % 7 != 0) {
			result = "Fizz";
		}else if (number % 5 != 0 && number % 7 == 0) {
			result = "Buzz";
		}else if (number % 5 == 0 && number % 7 == 0){
			result = "FizzBuzz";
		}
		return result;
	}
}
