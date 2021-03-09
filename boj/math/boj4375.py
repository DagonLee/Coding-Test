while True:
    try:
        n = int(input())
        ones = "1"
        while True:
            if int(ones) % n == 0:
                print(len(ones))
                break
            else:
                ones += "1"
    except:
        break
