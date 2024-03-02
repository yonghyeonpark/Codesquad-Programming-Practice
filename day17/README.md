# 📅 day 17
# 화성 달력 시계

## 📝 설계

- 조건문과 반복문을 활용하여 날짜 계산 로직을 구현했습니다.
- 윤년을 적용해야하는 부분에서 계산이 누락되지 않도록 신경썼습니다.
- 지구날과 화성날짜 계산에 대해 테스트를 진행했습니다.
- 프로그래스 바 구현을 위해 `\r`과 `Thread.sleep()`을 사용했습니다.
- 비동기 프로그래밍을 위해, `CompletableFuture`를 사용했습니다.

## ✅ 개선 사항

- ~~지구날 계산에 `LocalDate`를 사용해 볼 예정입니다.~~
- 충족시키지 못한 요구사항, `Progress Bar`를 구현할 예정입니다.

## 🛠️ 기능 분리

### ⚙️ MarsCalendar(enum)

- 화성 달력의 종류를 관리합니다.
  - 27일까지
  - 28일까지

### ⚙️ DateFactory

- 지구 달력의 각 월마다 일수를 `Map`으로 관리합니다.
- 화성 달력의 각 월마다 일수를 `Map`으로 관리합니다.

### ⚙️ Calculator

- 지구날을 계산합니다.
- 화성날짜를 계산합니다.

### ⚙️ Controller

- `Calculator`를 통해 지구날과 화성날짜를 얻습니다.
- 비동기 프로그래밍을 위해, `CompletableFuture`를 활용합니다.

### ⚙️ InputView

- 사용자 입력을 받습니다.

### ⚙️ OutputView

- `printProgressBar()`
  - 프로그래스 바를 0%부터 10%씩 채우며, 100%까지 진행합니다.
- `printResult()`
  - 형식에 맞게 결과를 출력합니다.
  - 화성날짜에 해당하는 달력 문자열을 가져옵니다

## 💻 결과화면 1

![image](https://github.com/yonghyeonpark/Codesquad-Programming-Practice/assets/126778700/b97b8a70-1716-4e77-832a-bfddc95ff957)

## 💻 결과화면 2

![image](https://github.com/yonghyeonpark/Codesquad-Programming-Practice/assets/126778700/37e874c8-7d2e-45f5-90dc-2ee5937693e1)

## 💻 결과화면 3

![image](https://github.com/yonghyeonpark/Codesquad-Programming-Practice/assets/126778700/dbd2cdb8-276c-4636-9d2c-69c6b31abe3e)
