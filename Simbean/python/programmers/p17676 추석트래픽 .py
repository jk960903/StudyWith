#https://programmers.co.kr/learn/courses/30/lessons/17676
def find_time(time):
    ans = 0
    print(time)
    for N in time:
        for z in N:
            cnt = 0
            for S, E in time:
                if E < z or S > z + 999:
                    pass
                else:
                    cnt += 1
            ans = max(ans, cnt)
    return ans
def solution(lines):
    answer = 0
    Time = []
    for i in lines:
        _, S, E = i.split()
        S_T = list(map(int,S.replace('.', ':').split(':')))
        T2 = S_T[3] + S_T[2] * 1000 + S_T[1] * 1000 * 60 + S_T[0] * 1000 * 3600
        E_T = int(float(E[:-1]) * 1000)
        T1 = T2 - E_T + 1
        T1 = max(T1, 0)
        Time.append((T1, T2))
    answer =  find_time(Time)
    return answer