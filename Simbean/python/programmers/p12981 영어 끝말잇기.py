#https://programmers.co.kr/learn/courses/30/lessons/12981
def solution(n, words):
    answer = [0, 0]
    useword = []
    t = []
    for i in range(1, len(words)):
        for j in range(1, n+1):
            t.append((j , i))
    prev = words[0][0]
    # [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
    for people, w in zip(t, words):
        if prev == w[0] and w not in useword:
            useword.append(w)
            prev = w[-1]
        else:
            answer = list(people)
            return answer
    return answer