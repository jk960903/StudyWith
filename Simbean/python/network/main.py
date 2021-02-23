"""# This is a sample Python script.

# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.
from typing import List

def __init__():
    global Numberarray
    Num = int(input())
    nList = input()
    Number = []
    Numberarray = []
    for i in nList:
        if i == '[' or i == ',' or i == ' ':
            pass
        else:
            if i == ']':
                Numberarray.append(Number)
                Number = []
                continue
            else:
                Number.append(int(i))
    del Numberarray[-1]

def makeVisit(i):
    for j in range(0, len(Numberarray[i])):
        if Numberarray[i][j] == 1:
            try:
                Visitqueue.index(j)
                continue
            except ValueError:
                Visitqueue.append(j)
    print(Visitqueue)

def Network():
    global Visitqueue
    Visitqueue = []
    cnt = 1
    for i in range(0, len(Numberarray)):
        point = 0
        if i == 0:
            for j in range(0, len(Numberarray[0])):
                if Numberarray[0][j] == 1:
                        Visitqueue.append(j)
        for k in range(0, len(Visitqueue)):
            if Numberarray[i][Visitqueue[k]] == 1:
                point = 1
                break
        if point == 0:
            cnt += 1
        makeVisit(i)
    return cnt

def main():
    __init__()
    cnt = Network()
    print(cnt)

if __name__ == '__main__':
    main()
"""
# This is a sample Python script.

# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.
from typing import List

def __init__():
    global Numberarray
    Num = int(input())
    nList = input()
    Number = []
    Numberarray = []
    for i in nList:
        if i == '[' or i == ',' or i == ' ':
            pass
        else:
            if i == ']':
                Numberarray.append(Number)
                Number = []
                continue
            else:
                Number.append(int(i))
    del Numberarray[-1]

def makeVisit(i):
    for j in range(0, len(Numberarray[i])):
        if Numberarray[i][j] == 1:
            try:
                Visitqueue.index(j)
                continue
            except ValueError:
                Visitqueue.append(j)
    print(Visitqueue)

def Network():
    global Visitqueue
    Visitqueue = []
    cnt = 1
    for i in range(0, len(Numberarray[0])):
        if Numberarray[0][i] == 1:
            Visitqueue.index(i)
    while 1:
        for i in range(0, len(Visitqueue))
        for i in range(0, len(Numberarray[index])):
            if Numberarray[index][i] == 1:
                Visitqueue.index(i)

        cnt+= 1
    index = Visitqueue
        makeVisit(i)
    return cnt

def main():
    __init__()
    cnt = Network()
    print(cnt)

if __name__ == '__main__':
    main()
