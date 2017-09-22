from multiprocessing import Pool


def func(x):
    return x * x


def test():
    p = Pool(5)
    print(p.map(func, (range(4))))

def testWith():
    with Pool(5) as p:
        print(p.map(func, (range(3))))

if __name__ == '__main__':
    # test()
    test()
