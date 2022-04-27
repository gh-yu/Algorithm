N = int(input()) 

f1, f2, f3 = 0, 1, 1 # 피보나치 수 세팅

# N이 2 이상일때부터 N-2만큼 반복
for n in range(2, N+1):
    f3 = f1 + f2
    f1 = f2 # 한 칸씩 뒤로
    f2 = f3 # 한 칸씩 뒤로
    
    
if N == 0:
    print(f1) 
elif N == 1:
    print(f2)
else:
    print(f3)