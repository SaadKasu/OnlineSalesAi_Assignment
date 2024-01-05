#Updated Python Script :

#Changed 4 chars :
#1.) Added <= in elif instead of < 
#2.) Changed range from (1,n-10) to (1,n-9)
#3.) Changed lim in else from n-20 to n-19

def compute(n):
    if n < 10:
        out = n ** 2
    elif n <= 20:
        out = 1
        for i in range(1, n-9):
            out *= i
    else:
        lim = n - 19
        out = lim * lim
        out = out - lim
        out = out / 2 
    print(out)


n = int(input("Enter an integer: "))
compute(n)