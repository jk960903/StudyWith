#https://www.acmicpc.net/problem/14501
if __name__ == "__main__":
    n = int(input())
    t = []
    for i in range(n):
        t.append(list(map(int, input().split())))
    cost = [0 for i in range(n)]
    t.reverse()
    for i in range(n):
        day, m = t[i]
        if i - day + 1 < 0:
            cost[i] = cost[i-1]
            continue
        cost[i] = max(cost[i - day] + m, cost[i - 1])
    print(cost[-1])