
p "Start counting:" 
for counter in 0..100
  if counter % 3 == 0
    p "Fizzi" 
  elsif counter % 5 == 0 
    p "Buzz" 
  else
    p counter
  end
end
