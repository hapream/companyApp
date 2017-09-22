from multiprocessing import Array, Value, Process


def func(a, b):
    a.value = 3.3333333333333333
    for j in range(len(b)):
        b[j] = -b[j]


if __name__ == '__main__':
    num = Value('d', 0.0)
    arr = Array('i', range(11))
    if 0:
        t = Process(target=func, args=(num, arr))
        t.start()
        t.join()
    else:
        c = Process(target=func, args=(num, arr))
        d = Process(target=func, args=(num, arr))
        c.start()
        c.join()
        d.start()
        d.join()
    print(num.value)
    print(arr[:])
    for i in arr:
        print(i),
