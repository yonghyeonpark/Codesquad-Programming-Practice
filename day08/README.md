# 📅 Day 8
# 🔁 컴퓨터 옮기기
## 📝 설계

- 재귀 호출을 활용하는 하노이탑 알고리즘을 사용했습니다.
- 책상 위에 컴퓨터 부품들을 쌓을 때, 스택을 사용했습니다.
- 출력 포맷을 맞추기 위해 스택의 값을 리스트로 변환했습니다.

## 🛠️ 기능 분리

### ⚙️ Desk

- 이름을 나타내는 `name`, 쌓인 컴퓨터 부품들을 나타내는 `computerParts`를 필드로 갖습니다.
- 스택의 pop, push의 기능을 하는 `draw`, `put` 함수를 갖고 있습니다.
- `getResult()`
  - 각 스택의 요소들을 리스트로 옮기되 9칸을 기준으로 맞추어 빈공간은 출력 포맷에 맞는 공백을 추가합니다. 

### ⚙️ Process

- 단계를 나타내는 `step`, 책상들의 모음을 나타내는 `desks`를 필드로 갖습니다.
- step은 객체 생성 시, `1`로 초기화합니다.
- `move()`
  - `step`에 1을 더하고, 매개변수로 넘어온 `start`에 해당하는 desk에서 값을 꺼내 매개변수인 `to`에 해당하는 desk에 넣습니다.
- `print()`
  - 현재 step을 StringBuilder에 추가합니다. 
  - 각 책상의 스택 값을 Desk의 `getResult()`로 가져와 반복문을 돌려 인덱스에 해당하는 각 리스트의 값들을 차례대로 StringBuilder에 추가합니다.
  - 마지막으로 desk1~3의 이름을 차례로 StringBuilder에 추가 후, 문자열로 반환합니다. 

### ⚙️ Controller

- `Desk` 타입의 desk1~3 객체를 생성 후, 재귀 호출을 이용한 로직을 진행합니다.
- 사용자 입력(step)에 해당하는 시점에서 Process의 `print()`를 호출하고 프로그램을 종료합니다.
- 입력 값이 1인 경우에는 재귀 함수를 들어가지 않고 조건문을 통해 `print()`를 호출하고 프로그램을 종료합니다.

### ⚙️ InputView

- 사용자 입력을 받습니다. (step)

## 💻 결과 화면 1

![image](https://github.com/yonghyeonpark/Codesquad-Programming-Practice/assets/126778700/b1107454-ae40-4205-a198-e34771340ac9)

## 💻 결과 화면 2

![image](https://github.com/yonghyeonpark/Codesquad-Programming-Practice/assets/126778700/c0bdca22-282e-4681-9c37-d9453e6e3d98)

## 💻 결과 화면 3

![image](https://github.com/yonghyeonpark/Codesquad-Programming-Practice/assets/126778700/a24c84dd-73e6-4cf2-ae66-7f5196cc87fc)

## 💻 결과 화면 4

![image](https://github.com/yonghyeonpark/Codesquad-Programming-Practice/assets/126778700/e8a6a266-1839-49c5-b428-d3d0226dd3c1)

## 💡 피드백

- `nextInt` 사용 <br>=> 정수로 변환하는 불필요한 과정을 제거합니다.
- `메서드 분리` <br>=> getResult(), print() 함수를 분기별로 분리합니다.
- `요구 사항` 꼼꼼하게 체크 <br>=> 누락된 조건, "만약 입력값이 완료 단계보다 크다면 완료 단계를 출력한다."를 확인합니다.