#https://programmers.co.kr/learn/courses/30/lessons/12973
def solution(s):
    answer = 0
    idx = 0
    w = [s[0]]
    while idx + 1 < len(s):
        if len(w) > 0 and w[-1] == s[idx + 1]:
            w.pop()
        else:
            w.append(s[idx + 1])
        idx += 1
    if len(w) == 0:
        answer = 1
    return answer
if __name__ == '__main__':
    print(solution('baabaa'))