#https://programmers.co.kr/learn/courses/30/lessons/49191
#https://programmers.co.kr/learn/courses/30/lessons/49191
def solution(n, results):
    answer = 0
    win = {}
    lose= {}
    for i in results:
        if i[0] in win:
            win[i[0]].append(i[1])
        else:
            win[i[0]] = [i[1]]
        if i[1] in lose:
            lose[i[1]].append(i[0])
        else:
            lose[i[1]] = [i[0]]
    #print(win)
    #print(lose)
    w = [0 for i in range(n+1)]
    for i in range(n):
        for i in win:
            for j in win[i]:
                if j in win:
                    win[i] = list(set(win[i][:] + win[j][:]))
        for i in lose:
            for j in lose[i]:
                if j in lose:
                    lose[i] = list(set(lose[i][:] + lose[j][:]))
    for i in range(n+1):
        if i in win:
            w[i] += len(win[i])
        if i in lose:
            w[i] += len(lose[i])
        if w[i] == n-1:
            answer+= 1
    print(w)
    print(win)
    print(lose)
    return answer
if __name__ == "__main__":
    print(solution(5,	[[4, 3], [4, 2], [3, 2], [1, 2], [2, 5]]))