n, m = 4, 4 # input for size of grid
# comment out the following line for input parameters if required
# n, m = map(int, input().strip().split()) 
grid = [[0 for x in range(n)] for y in range(m)]
top_row = 0 
bottom_row = m-1
left_column = 0
right_column = n-1
x = 1 # counter for value that will be printed
for _ in range(m // 2): # loop around the grid
  for t in range(left_column, right_column + 1):
    grid[top_row][t] = x
    x += 1
  top_row += 1  
  for t in range(top_row, bottom_row + 1):
    grid[t][right_column] = x
    x += 1  
  right_column -= 1
  for t in range(right_column, left_column - 1, -1):  
    grid[bottom_row][t] = x
    x += 1
  bottom_row -= 1
  for t in range(bottom_row, top_row - 1, -1):
    grid[t][left_column] = x
    x += 1 
  left_column += 1    
l = len(str(n*m)) # max len will be used for padding
for x in grid:
  print(" ".join(str(y).rjust(l) for y in x))
