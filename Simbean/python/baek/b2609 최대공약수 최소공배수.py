#https://www.acmicpc.net/problem/2609
def gcd(a, b):
    t = False
    while a != 0 and b != 0:
        if t == True:
            a %= b
            t = False
        else:
            b %= a
            t = True
    return max(a, b)
if __name__ == "__main__":
    a, b = input().split()
    a = int(a)
    b = int(b)
    g = gcd(a, b)
    print(g)
    print(int(a * b / g))