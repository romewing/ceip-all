
def fibs(num):
    result = [0, 1];
    for i in range(num-2):
        result.append(result[-1] + result[-2])
    return result

if __name__ == '__main__':
    a = fibs(5)
    print a