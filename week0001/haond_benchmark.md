This is my benchmark code week1
```
require 'benchmark'
def fb(n)
  s = ''
  (1..n).each{|i|
    s = 'Fizz' if i%3 == 0
    s = 'Buzz' if i%5 == 0
  }                    
end


def fb1(n)
  x = 0
  y = 0
  s = ''
  while(x + 3 <= n || y + 5 <= n)
    if(x+3<=y+5)
      x+=3
      s = "Fizz"
    else
      y+=5
      s = "Buzz"
    end
  end
end


FIZZ = ["Fizz","Fizz\nFizz","Fizz\nFizz"]
def fb2(n)
  t = n/5
  s = ''
  t.times{|i|
    s = FIZZ[i%3]
    s = "Buzz"
  }
end

Benchmark.bm do |x|
  x.report {fb(100000)}
  x.report {fb1(100000)}
  x.report {fb2(100000)}
end
```
Then output :
```
       user     system      total        real
   0.030000   0.000000   0.030000 (  0.023087)
   0.010000   0.000000   0.010000 (  0.009984)
   0.000000   0.000000   0.000000 (  0.004115)
```
