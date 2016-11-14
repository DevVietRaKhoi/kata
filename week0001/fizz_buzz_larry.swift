import Foundation

func printFizzBuzz() {
	for var index in 1...100 {
		if index % 3 == 0 {
			print("Fizz")
		}
		
		if index % 5 == 0 {
			print("Buzz")
		}
	}
}

printFizzBuzz()