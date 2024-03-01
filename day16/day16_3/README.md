# 📅 day 16
# longest-common-prefix

## 📝 풀이

- getMinLength(String[] strs)
  - 반복 횟수를 정하기 위해 배열의 문자열 중에 가장 짧은 길이를 구합니다.

- findCommonPrefix(String[] strs, int minLength)
  - `currentChar`을 배열의 가장 첫 번째 문자열의 첫 번째 원소로 설정합니다.
  - 매칭 여부를 나타내는 `isMatching`을 false로 설정합니다.
  - 문자열 배열에 대해 반복을 돌면서 해당 문자열의 인데스 문자와 `currentChar`이 일치하는지 확인한 후, 일치하지 않으면 `isMatching`을 false로 설정하고 반복문을 종료합니다.
  - 내부 반복문이 종료된 후, 바깥쪽의 반복문에서 다시 한 번 `isMatching`을 확인하여 true라면 StringBuilder에 해당 문자를 추가합니다.

## 💻 결과화면

```
[input]
new String[]{"flower","flow","flight"}
new String[]{"dog","racecar","car"}
```

![image](https://github.com/yonghyeonpark/Codesquad-Programming-Practice/assets/126778700/98d9e9f0-3eed-4bd7-9f43-609447879822)