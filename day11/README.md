# 📅 Day 11
# 직선과 도형
## 📝 설계

- 인터페이스 `Figure`를 활용했습니다.
  - `double calculate()` : 직선은 길이를, 도형은 넓이를 구합니다.
  - `void printValue()` : 구한 값을 출력합니다. 
  - 해당 인터페이스를 직선과 도형으로 구현했습니다.

## 🛠️ 기능 분리
### ⚙️ Coordinate

- 입력 값에 대해 정규식을 적용하여 x와 y좌표를 구합니다.
  - 범위에 대한 유효성 검사를 진행합니다.

### ⚙️ Controller

- 좌표에 대한 유효성 검사를 진행한 후, Coordinate 타입의 리스트인 `coordinates`에 담습니다.
- `coordinates`의 크기에 따라 분기를 나누어 해당하는 도형의 공식을 적용합니다.

### ⚙️ InputView

- 사용자 입력을 받고, 문자열을 `-`를 기준으로 분리하여 배열로 반환합니다.

### ⚙️ Line

- 인터페이스 `Figure`를 구현합니다.
- `double calculate()` : 공식을 이용해 직선의 길이를 구합니다.
- `void printValue()` : 직선 길이를 출력합니다.

### ⚙️ Triangle

- 인터페이스 `Figure`를 구현합니다.
- `double calculate()` : 공식을 이용해 삼각형의 넓이를 구합니다.
- `void printValue()` : 삼각형 넓이를 출력합니다.

### ⚙️ Polygon

- 좌표의 순서를 알아야 신발끈 공식을 사용할 수 있는데, 좌표가 랜덤으로 주어질 때, 해당 좌표들의 순서를 찾을 방법을 모르겠습니다. 😢

## 💻 결과화면 1

![image](https://github.com/yonghyeonpark/Codesquad-Programming-Practice/assets/126778700/0ebe8c3b-f0f5-40e8-9daf-1a00dcbe8326)

## 💻 결과화면 2

![image](https://github.com/yonghyeonpark/Codesquad-Programming-Practice/assets/126778700/01094c05-3824-4c8e-9cf4-14d2c9270fad)