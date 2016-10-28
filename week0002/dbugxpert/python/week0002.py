n, m = 4, 4 
# n, m = map(int, input().strip().split()) 
grid = [[0 for cell in range(n)] for row in range(m)]
top_row, bottom_row, left_column, right_column, counter = 0, m - 1, 0, n - 1, 1
PADDING_SIZE = len(str(n*m)) 

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
  
for row in grid:
  print(" ".join(str(cell).rjust(PADDING_SIZE) for cell in row))
