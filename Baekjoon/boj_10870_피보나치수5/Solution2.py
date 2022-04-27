N = int(input()) 

f1, f2 = 0, 1
f3 = 0
for n in range(0, N):
    f1 = f2
    f2 = f3
    f3 = f1 + f2

print(f3)