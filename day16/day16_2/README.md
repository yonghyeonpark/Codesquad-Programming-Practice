# 📅 day 16
# palindrome-number

## 📝 풀이

- reverse-integer 문제의 풀이를 활용했습니다.
  - getLength(int x)
      - 해당 숫자의 길이를 구합니다.
      - 음수일 경우에는 `-`를 제외한 길이를 구합니다.
  - reverse(long x, int length)
      - length, 내부에서 선언한 index 변수를 이용해서 10으로 나눈 나머지에 10^(length - index)를 곱합니다.
      - 해당 숫자를 10으로 나눈 몫으로 대체하고 인덱스를 1 증가시킵니다.
      - 앞의 과정을 반복하며 `나머지 * 10^(length - index)`를 차례로 더합니다.
      - 입력 값은 int의 범위이지만 뒤집었을 때는 범위를 벗어날 수 있으므로 long 타입으로 바꿔줍니다.
  - solution(int x)
      - reverse()의 결과를 반환하되, 범위를 벗어나면 0을 반환합니다.

- isPalindrome(int x)
  - 입력값과 solution()의 결과를 비교하여 true 혹은 false를 반환합니다.
  - 음수일 때는 false를 반환합니다.

## 💻 결과화면

```
[input]
121
-121
321
```

![image](https://github.com/yonghyeonpark/Codesquad-Programming-Practice/assets/126778700/2e42e3c6-9643-45c8-a989-bae6e06adecf)