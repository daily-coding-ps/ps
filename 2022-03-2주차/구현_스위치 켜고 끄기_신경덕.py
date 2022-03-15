N = int(input())
switch = list(map(int, input().split()))
P = int(input())

def man():
  for i in range(number, N+1, number):
    switch[i-1] ^= 1

def woman():
  for i in range(number, N+1):
    r = i
    l = number - (r - number)
    if l < 1:
      break
    if r == l:
      switch[l-1] ^= 1
    elif switch[r-1] == switch[l-1]:
      switch[l-1] ^= 1
      switch[r-1] ^= 1
    else:
      break

for _ in range(P):
  gender, number = map(int, input().split())

  if gender == 1:
    man()
  else:
    woman()

for i in range(0, N, 20):
  print(*switch[i:i+20])

