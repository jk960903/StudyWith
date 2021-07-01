#https://programmers.co.kr/learn/courses/30/lessons/77484
def solution(lottos, win_nums):
    answer = []
    c1 = lottos[:]
    c2 = win_nums[:]
    zero = 0
    for i in lottos:
        if i == 0:
            zero += 1
            continue
        try:
            c2.remove(i)
        except ValueError:
            pass
    L = min(1 + len(c2), 6)
    while len(c2) > 0:
        if zero <= 0:
            break
        zero -= 1
        c2.pop()
    W = min(1 + len(c2), 6)
    answer = [W, L]
    return answer