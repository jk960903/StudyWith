import sys
#https://www.acmicpc.net/problem/11726
if __name__ == "__main__":
    space = [0 for i in range(1000)]
    space[0] = 1
    space[1] = 2
    for i in range(2,1000):
        space[i] = space[i-1] + space[i-2]

    N = int(sys.stdin.readline())
    print(space[N-1]%10007)
