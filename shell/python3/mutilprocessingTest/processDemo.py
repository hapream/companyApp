from multiprocessing import Process

def f(x):
    print(x*x)
    return x*x


if __name__ == '__main__':
    p= Process(target=f, args=(2,))
    p.start()
    p.join()
