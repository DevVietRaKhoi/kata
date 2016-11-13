#include <iostream>

int main() {
	for (int i = 1; i <= 100; ++i) {
		if (i % 3 == 0) 
			std::cout << "Fizz" << endl;
		if(i % 5 == 0)
			std::cout << "Buzz" << endl;
	}
	return 0;
}