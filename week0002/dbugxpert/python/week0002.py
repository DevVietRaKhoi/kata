# input size for grid
n, m = 4, 4 
# n, m = map(int, input().strip().split()) 
grid = [[0 for counter in range(n)] for y in range(m)]
top_row = 0 
bottom_row = m-1
left_column = 0
right_column = n-1
counter = 1 
# loop around the grid
for _ in range(m // 2): 
  for t in range(left_column, right_column + 1):
    grid[top_row][t] = counter
    counter += 1
  top_row += 1  
  for t in range(top_row, bottom_row + 1):
    grid[t][right_column] = counter
    counter += 1  
  right_column -= 1
  for t in range(right_column, left_column - 1, -1):  
    grid[bottom_row][t] = counter
    counter += 1
  bottom_row -= 1
  for t in range(bottom_row, top_row - 1, -1):
    grid[t][left_column] = counter
    counter += 1 
  left_column += 1
padding_size = len(str(n*m)) 
for x in grid:
  print(" ".join(str(y).rjust(padding_size) for y in x))
