def solution(s):
	min = 1001
	result = ""
	answer = 0
	for i in range(1,(len(s) / 2) + 1):
		tmp = s[:i]
		result += s[:i]
		cnt =0 
		for j in range(i,len(s),i):
			if tmp == s[j:j+i]:
				cnt += 1
			else :
				if (cnt >= 2) :
					answer += 1
					result += str(cnt)
				tmp = s[j + i: j+i+i]
				cnt = 1
			print(tmp)
		if(answer < min):
			min = answer
	return answer
print(solution("aaabbaccc"))
