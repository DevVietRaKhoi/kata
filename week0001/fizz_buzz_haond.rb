def fizz_buzz(n)
  (1..n).each { |i| 
    fizz(i)
    buzz(i)  
  }
end

#fizz(3) => 'fizz'
#fizz(6) => 'fizz'
def fizz(n)
  p 'fizz' if n%3==0
end

#buzz(5) => 'buzz'
#buzz(10) => 'buzz'
def buzz(n)
  p 'buzz' if n%5==0
end

fizz_buzz(100)
