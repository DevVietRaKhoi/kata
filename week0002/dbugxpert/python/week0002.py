n = 4
m = 4
g = [[0 for x in range(n)] for y in range(m)] 
tr = 0
br = m-1
lc = 0
rc = n-1
x = 1
for _ in range(m//2):
  for t in range(lc, rc+1):
    g[tr][t] = x
    x += 1
  tr += 1  
  for t in range(tr, br+1):
    g[t][rc] = x
    x += 1  
  rc -= 1
  for t in range(rc, lc-1, -1):  
    g[br][t] = x
    x += 1
  br -= 1
  for t in range(br, tr-1, -1):
    g[t][lc] = x
    x += 1 
  lc += 1  
l = len(str(n*m))
for x in g:
  print(" ".join(str(y).rjust(l) for y in x))