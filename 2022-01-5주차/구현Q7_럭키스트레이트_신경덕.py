N = list(map(int,list(input())))

N_len = len(N)

if sum(N[:N_len//2]) == sum(N[N_len//2:]):
    print("LUCKY")
else:
    print("READY")