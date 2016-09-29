FIZZ = ["Fizz","Fizz\nFizz","Fizz\nFizz"]

def fizz_buzz(n)
  t = n/5
  t.times{|i|
    puts FIZZ[i%3]
    puts "Buzz"
  }
end

fizz_buzz(100)
