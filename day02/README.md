# 📅 Day 2

# 🎯 다트 점수판

## ⚙️ ScoringTable

✅ 생성자를 통해 점수표의 크기와 점수(String)를 입력받습니다.<br>
✅ generateScoringTable 함수를 통해 점수표의 크기만큼 점수를 배열에 입력하고, 크기를 넘어선 마지막 2개의 점수는 인덱스 0, 1의 점수를 입력합니다.<br>
✅ 입력값을 통해 만들어진 점수표를 반환합니다.

## ⚙️ Member

✅ 점수를 획득할 수 있는 인덱스를 결과 리스트에 추가합니다. (List, int 타입) <br>
✅ 지금까지의 획득 점수를 계산합니다.

## ⚙️ Game

✅ 기준이 되는 인덱스가 범위를 벗어나는지 체크해서 1만큼 벗어나면 인덱스 0으로, 2만큼 벗어나면 인덱스 1로 바꿔줍니다.<br>
✅ 기준이 되는 인덱스에 해당하는 멤버 인덱스가 존재하면 각 멤버의 결과 리스트에 추가합니다.<br>
✅ 보너스 점수의 계산을 위해 단일 결과를 담을 수 있는 리스트를 사용하고, 만약 보너스 점수 획득 조건에 해당한다면 멤버의 결과 리스트에 해당 인덱스를 추가합니다.<br>
✅ 멤버 A와 B의 최종 점수를 통해 결과를 출력합니다.

## ⚙️ InputView

✅ 배열 형식의 String 타입 문자열을 분리하여 라운드별로 이중 리스트에 담아 반환합니다.

## ⚙️Util

✅ 배열 형식의 String 타입 문자열을 분리하여 StringTokenizer 타입으로 반환합니다.

## 💻 결과 화면 1
### 1라운드만 입력하고 B가 더 큰 경우

![image](https://github.com/yonghyeonpark/Codesquad-Programming-Practice/assets/126778700/6940b302-b988-497d-a4f7-252114cd7799)

## 💻 결과 화면 2
### 3라운드만 입력하고 A가 더 큰 경우

![image](https://github.com/yonghyeonpark/Codesquad-Programming-Practice/assets/126778700/9bb31db2-13d6-4cb0-9676-8ae32f8e965a)

## 💻 결과 화면 3
### 2라운드만 입력하고 동점인 경우

![image](https://github.com/yonghyeonpark/Codesquad-Programming-Practice/assets/126778700/7103e6ef-8023-4d9b-8c98-8b6c52e8ee56)

## 💻 결과 화면 4
### 2 라운드만 입력하고 A가 보너스 점수를 얻는 경우

![image](https://github.com/yonghyeonpark/Codesquad-Programming-Practice/assets/126778700/e2ebcfd9-5175-41dd-b69b-2718ef2fb03b)
