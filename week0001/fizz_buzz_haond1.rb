FIZZ = [1,2,2]
def fizz_buzz(n)
  (n/5).times{|i|
    FIZZ[i%3].times{ p 'Fizz' }
    p 'Buzz'
  }
end
fizz_buzz(100)
