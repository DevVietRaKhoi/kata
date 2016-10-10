def spi_round(n=4, m=4, x=0):
	'''Looping through the spiral path to return the next
	cell'''
	if (x >= (n+1) / 2) or (x >= (m+1) / 2):
		return
	for i in range(x, m - x -1):
		yield (x, i)
	for i in range(x, n - x - 1):
		yield(i, m - x - 1)
	for i in range(m - x - 1, x, -1):
		yield(n - x - 1, i)
	for i in range(n - x - 1, x, -1):
		yield(i, x)

def spiral(n=4, m=4):
	'''Return the n*m board with numbers
	arrange in spiral format'''
	board = [[False for x in range(m)] for y in range(n)]
	limit = int((n+1) / 2)
	count = 1
	for i in range(limit):
		for next_row, next_col in spi_round(n, m, i):
			if not board[next_row][next_col]:
				board[next_row][next_col] = count
				count += 1
			else:
				return board
	return board

def test_spiral(n, m):
	result = spiral(n, m)
	print('\n'.join([' '.join(['{:2}'.format(item) for item in row]) 
      for row in result]))

if __name__=="__main__":
	test_spiral(4, 4)
	
