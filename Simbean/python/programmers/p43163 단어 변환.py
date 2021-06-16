#https://programmers.co.kr/learn/courses/30/lessons/43163
def diff_word(N, M, visit):
    diff = 0
    for idx, i in enumerate(N):
        if visit & (1 << idx) == 1:
            continue
        if N[idx] != M[idx]:
            diff += 1
            visit = visit | (1 << idx)
    return diff, visit
def dfs(word, words, target, count = None, visit_words = None, visit_word = None, ans = None):
    if count == None:
        count = 0
    if ans == None:
        ans = 11
    if visit_words == None:
        visit_words = 0
    if visit_word == None:
        visit_word = 0
    if word == target:
        ans = min(ans, count)
        return ans
    N = list(word)
    for idx, i in enumerate(words):
        if visit_words & (1 << idx) > 0:
            continue
        M = list(i)
        diff, trans_visit = diff_word(N, M, visit_word)
        if diff == 1:
            ans = dfs(i, words, target,
                      count + 1, visit_words | (1 << idx), visit_word, ans)
    return ans

def solution(begin, target, words):
    answer = 0
    if target in words:
        answer = dfs(begin, words, target)
    else:
        return 0
    print(answer)
    return answer

if __name__ == "__main__":
    solution("hit",	"cog",	["hot", "dot", "dog", "lot", "log", "cog"])