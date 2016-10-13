import sys


def generate(m, n):
    row = 0
    # init array with m rows and n columns assign -1 for every position
    a = [[-1 for o in range(n)] for o in range(m)]
    val = 1
    flag = 0
    while flag < m / 2 + (m <= n and m % 2 or 0):
        for col in range(flag, n - flag):
            a[row][col] = val
            val += 1
        for row in range(flag + 1, m - flag):
            a[row][col] = val
            val += 1
        if val > n * m:  # stuck and could't get anyway better
            break
        for col in range(n - 1 - flag - 1, flag - 1, -1):
            a[row][col] = val
            val += 1
        if val > n * m:  # stuck and could't get anyway better
            break
        for row in range(m - 2 - flag, flag, -1):
            a[row][col] = val
            val += 1
        flag += 1

    return a


def print_array(a):
    print('\n'.join([' '.join(['{:2}'.format(item) for item in row])
                     for row in a]))


if __name__ == '__main__':
    args = sys.argv[1:]
    m = int(args[0])
    n = int(args[1])
    b = generate(m, n)
    print_array(b)
