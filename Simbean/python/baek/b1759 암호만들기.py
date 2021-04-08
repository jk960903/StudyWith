import sys
#https://www.acmicpc.net/problem/1759
m = ['a','e','i','o','u']
global C
def find(word, moum):
    mcnt = 0
    zcnt = 0
    for j in word:
        if j in m:
            mcnt += 1
        else:
            zcnt += 1
    if mcnt >= 1 and zcnt >= 2:
        return 1
    return 0
def combinations(index,n):
    for i in range(index+1 , N[1]):
        if len(n)+1 >= N[0]:
            C.append(n+word[i])
        else:
            combinations(i,n+word[i])
    return 1
if __name__ == "__main__":
    N = list(map(int,sys.stdin.readline().split()))
    word = sys.stdin.readline().rstrip().split(' ')
    word.sort()
    C = []
    combinations(-1,'')
    for i in C:
        cnt = find(i, m)
        if cnt == 1:
            print(i)