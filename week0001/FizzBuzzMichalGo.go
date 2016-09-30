package main

import (
	"fmt"
)

func main() {
	for i := 1; i <= 100; i++ {
		if 0 == i % 3 {
			fmt.Println("Fizz")
		}
		if 0 == i % 5 {
			fmt.Println("Buzz")
		}
	}
}
