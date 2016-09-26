
p "Start counting:" 
for counter in 0..100
  if counter % 3 == 0
    p "Fizzi \n" 
  elsif counter % 5 == 0 
    p "Buzz \n" 
  else
    p counter
  end
end
