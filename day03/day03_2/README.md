# 📅 Day 3
# 💯 OX 퀴즈

## 🛠️ 작업 과정

- BufferedReader를 이용해서 문자열을 입력받고 정수로 변환해 테스트 케이스 변수에 저장합니다.
- 테스트 케이스 개수만큼 반복문을 돌도록 설정하고 반복문마다 퀴즈의 결과인 문자열을 입력받습니다.
- 다시 문자열의 길이만큼 반복문을 돌도록 설정하고 char 형 배열에 문자열의 원소들을 옮겨 담습니다.
- 점수(score)와 연속된 횟수(count)를 나타내는 변수들을 각각 0으로 초기화합니다.
- 다시 char 형 배열의 크기만큼 반복문을 돌도록 설정하고 문자가 'O'일 때는 count의 수를 1 증가시키고, score에 더해줍니다. 문자가 'X'일 때는 count를 다시 0으로 초기화시킵니다.
- 각 테스트 케이스마다 점수를 출력합니다.

## ⌨️ 실행 방법

- 첫째 줄에 테스트 케이스 개수를 입력합니다.
- 테스트 케이스 개수만큼 'O'와 'X'를 사용하여 공백없이 한 줄씩 입력합니다.

## 💻 실행 결과

![image](https://github.com/yonghyeonpark/Codesquad-Programming-Practice/assets/126778700/6abfa543-fb34-4345-b6ac-3653e9f5bdf8)

## 💡 피드백
- `String[] test = bf.readLine().split("");`
<br> => split을 사용해 한 번에 배열에 담은 후, for-each 문을 사용합니다.