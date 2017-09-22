from time import ctime, sleep


def music(argv):
    for i in range(2):
        print("Listen music %s. %s" % (argv, i))
        sleep(1)


def movie(argv):
    for i in range(2):
        print("watch moive ! %s. %s" % (argv, i))


if __name__ == '__main__':
    music("trouble is a friend")
    movie("bian xing jin gang")
    print("all over %s" % ctime())
