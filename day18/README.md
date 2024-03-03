# 📅 day 18
# 한글 시계

## 📝 설계

### 요구사항 선택
- UI 디자인 구현을 제외했습니다.
- 화면의 변경이 이전 결과를 덮어씌우지 않고, 순차적으로 출력됩니다.

### 구현
- 현재 시간을 구하기 위해 `LocalTime.now()`를 사용했습니다.
- 1초마다 현재 시간을 출력하기 위해 `ScheduledExecutorService`를 사용했습니다.
- 비동기를 적용하기 위해 `CompletableFuture`를 사용했습니다.
<br>❓❔ 하지만 결국 제 코드는 `1. 현재 시간 구하기`, `2. 한글로 변환하기`, `3. 시계 설정하기`, `4. 시계 출력하기`와 같이  순차적으로 진행돼야만 하는 로직인데, 
비동기 적용의 의미가 있는 건지 의문이 생깁니다.

## 🛠️ 기능 분리

### ⚙️ Point

- 2차원 배열인, 시계의 지점을 관리하기 위해 행과 열을 필드로 갖습니다.

### ⚙️ ConvertFactory

- 현재 시간을 시계에 표시하기 위해 자료들을 저장합니다.
  - `오전`, `오후`의 위치를 저장합니다.
  - `hour`의 위치를 저장합니다.
  - `minute`의 10의 자리, 1의 자리의 위치를 저장합니다.
  - `second`의 한글 변환을 위해, 10의 자리, 1의 자리를 각각 한글화한 자료들을 저장합니다.

### ⚙️ Convert

- `🌞`인지 `🌛`인지를 판단하여 `String sunOrMoon`에 저장합니다.
- 현재 시간에 대해 `오전` 혹은 `오후`를 판단하고 `시`, `분`과 함께 각각을 표시할 위치를 `List<Point> currentState`에 저장합니다.
- 한글로 변환한 `초`를 `String hangulSeconds`에 저장합니다.

### ⚙️ Clock

- 현재 시간을 변환한 `Convert` 클래스를 통해 2차원 배열인 시계를 세팅합니다.
  - `sunOrMoon`, `hangulSeconds`를 정해진 위치에 저장합니다.
  - `currentState`에 해당하는 위치에 `❗`를 붙여 현재 시간을 표시합니다.

### ⚙️ Controller

- `ScheduledExecutorService`를 이용해 1초마다 현재 시간을 시계로 출력하도록 합니다.
- `CompletableFuture`를 이용해 현재 시간의 계산과 나머지 로직들이 비동기적으로 동작합니다.

### ⚙️ OutputView

- 시계를 출력합니다.

## 💻 결과화면 1

`시간 : LocalTime.of(12, 5, 20)`

![image](https://github.com/yonghyeonpark/Codesquad-Programming-Practice/assets/126778700/bf78496e-98d0-4397-995b-29d3d5e73bdf)

## 💻 결과화면 2

`시간 : LocalTime.of(0, 8, 45)`

![image](https://github.com/yonghyeonpark/Codesquad-Programming-Practice/assets/126778700/05ff4614-6900-47ef-a1ad-ee8923ed975e)

## 💻 결과화면 3

`시간 : LocalTime.of(7, 2, 33)`

![image](https://github.com/yonghyeonpark/Codesquad-Programming-Practice/assets/126778700/01ab6fbe-8c8e-4ea8-9d67-8d92d44cdf6e)

## 💻 결과화면 4

`시간 : LocalTime.of(19, 0, 12)`

![image](https://github.com/yonghyeonpark/Codesquad-Programming-Practice/assets/126778700/55d5297d-c190-4b75-a2e4-5984a0109a0e)

## 💡 셀프 피드백

❗`final이 아닌 필드의 활용은 최소화 하자` 
<br>=> Convert 클래스의 `convert()`에는 많은 내장 메서드가 있고, 이 메서드들을 통해 클래스의 필드에 값이 저장되는데, 이는 다음과 같은 문제점이 있습니다.

1. 테스트 시, 작은 단위로 분리해서 할 수 없습니다.
2. 변경이 가능한 필드에 저장되기 때문에, 의도치 않게 값이 수정될 수 있습니다.

이를 해결하기 위해서, 작은 단위의 내장 메서드들이 해당 클래스의 필드를 통해 결과를 저장하는 것이 아니라, 값으로 반환을 하도록 수정한 후, `public`으로 전환해 외부에서 사용할 수 있도록 합니다.
