# 📅 Day 6
# 🐴 윷놀이-말판

## ❗출력 양식 변경

- 명시된 요구 사항에서는 분기점의 위치를 `ZW5`처럼 표기 했습니다.<br>=> 이에 대해 `WV0`처럼 다음 출발 지점과 도착 예정 지점으로 표기하도록 변경했습니다. 

## 🛠️ 기능 분리

### ⚙️ Player

- 말의 시작 위치를 세팅합니다.
- 업데이트된 위치를 매개변수로 받아, 현재 위치를 변경합니다.
- 점수를 추가합니다.

### ⚙️ Game

- 정상 루트와 지름길을 각각 Map에 세팅합니다.
- move()
  - player와 이동 횟수가 담긴 리스트를 매개변수로 받습니다.
  - 분기를 나눠 이동을 진행하고 매 결과를 갖고 player 위치를 업데이트 해줍니다.

### ⚙️ InputView

- 사용자 입력을 받습니다.

### ⚙️ Controller

- 전체적인 게임을 진행합니다.

## ✅ 잘못된 입력에 대한 처리

- 플레이어 수가 2 미만이거나 플레이어들의 이동 횟수가 일치하지 않으면 ["ERROR"]를 출력합니다.
- 플레이어의 입력 중에 숫자로 변환할 수 없는 문자가 있으면 결과를 "점수, ERR"로 나타냅니다.

## 💻 결과 화면 1

![image](https://github.com/yonghyeonpark/Codesquad-Programming-Practice/assets/126778700/35e2f86f-58aa-4dc4-a867-48f5e826312a)

## 💻 결과 화면 2

![image](https://github.com/yonghyeonpark/Codesquad-Programming-Practice/assets/126778700/9ff6edc1-b153-441e-b4ca-db678b97efb8)

## 💻 결과 화면 3

![image](https://github.com/yonghyeonpark/Codesquad-Programming-Practice/assets/126778700/55af051d-343d-42b7-809a-b88e1551d371)

## 💻 결과 화면 4

![image](https://github.com/yonghyeonpark/Codesquad-Programming-Practice/assets/126778700/a373c583-ebdf-40ae-9ef0-f3de43b3f1b1)

## 💻 결과 화면 5

![image](https://github.com/yonghyeonpark/Codesquad-Programming-Practice/assets/126778700/dc13d776-a9c7-4e22-9579-6010730b3db8)

## 💻 결과 화면 6

![image](https://github.com/yonghyeonpark/Codesquad-Programming-Practice/assets/126778700/37e2669d-ee6d-43ac-824e-9ced208f0dbf)