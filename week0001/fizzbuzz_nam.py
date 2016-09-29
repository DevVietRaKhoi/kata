def fizzbuzz(n=100):
	loop = (x%15 for x in range(1,n+1) if x%3==0 or x%5==0)
	for x in loop:
		if x in (3,6,9,12):
			yield "Fizz"
		elif x in (5,10):
			yield "Buzz"
		else:
			yield "Fizz\nBuzz"

if __name__ == "__main__":
	for x in fizzbuzz(100):
		print(x)
	
