def fizz_buzz(n)
  x = 0
  y = 0
  while(x + 3 <= n || y + 5 <= n)
    if(x + 3 <= y + 5)
        x += 3
        puts "Fizz"
    else
        y += 5
        puts "Buzz"
    end
  end
end 
fizz_buzz(100)

