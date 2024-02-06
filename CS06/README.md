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

![image](https://gist.github.com/assets/126778700/8048da3a-7410-4eac-9280-c9d1f231d86d)

## 💻 결과 화면 2

![image](https://gist.github.com/assets/126778700/ab829b1d-4fa9-455a-bf44-cb9667695aaf)

## 💻 결과 화면 3

![image](https://gist.github.com/assets/126778700/9d719004-06b9-4ffb-92ff-7b0e7138aa1e)

## 💻 결과 화면 4

![image](https://gist.github.com/assets/126778700/d01afc24-cc0b-494b-a2b1-82066ff274e4)

## 💻 결과 화면 5

![image](https://gist.github.com/assets/126778700/1b991d86-d718-48d6-b190-a95058b810e9)

## 💻 결과 화면 6

![image](https://gist.github.com/assets/126778700/c81cf5d3-7096-4faf-ab62-edd47d08bc01)