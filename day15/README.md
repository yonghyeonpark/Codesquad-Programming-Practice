# 📅 day 15
# 2차원 QR 디코딩

## 📝 설계

- 디코딩을 위해 데이터를 저장하는 과정에서 중복되는 작업에 대해 공통으로 처리하려고 노력했습니다.

## 🛠️ 기능 분리

### ⚙️ Code(enum)

- 각 10진수(code)에 매칭되는 문자를 관리하는 enum입니다.

### ⚙️ Direction(enum)

- 방향을 관리하는 enum입니다.
  - 위, 아래, 시계, 시계 반대

### ⚙️ Point

- 배열안에서 위치를 나타내는 행과 열을 필드로 갖습니다.

### ⚙️ DecodingData

- 디코딩해야되는 데이터를 객체로 생성하기 위한 클래스입니다.
- 시작 지점과 이동 방향을 필드로 갖습니다.

### ⚙️ QrCode

- 사용자 입력인 문자열을 2차원 배열의 QR 코드로 바꿔줍니다.
- 유효성 검사를 진행합니다.
  - 가로와 세로길이가 21이 아니면 예외가 발생합니다.
  - 시작과 끝 영역이 올바르면, 유효한 QR 코드인지를 나타내는 변수인, `isValidate`를 `true`로 선언합니다.

### ⚙️ DecodingDataFactory

- 디코딩해야하는 데이터들을 연관된 객체끼리 리스트에 담습니다.

### ⚙️ Moving

- 읽는 방향에 따라 읽는 순서를 구분하여 읽고, 그 후에 읽은 지점들을 리스트에 담아 반환합니다. 
  - 위, 아래, 시계, 시계 반대

### ⚙️ Util

- 디코딩하는 데이터의 종류(길이, 데이터, 에러)에 따라 알맞은 결과를 반환해줍니다.
  - 길이 : int 타입 반환
  - 데이터 : 해당 코드에 매칭되는 String 타입의 문자를 반환 
  - 에러 : String 타입의 16진수 반환

### ⚙️ Controller

- `DecodingDataFactory`로 부터 데이터들을 가져와서 읽습니다.
  - 결과로 출력할 데이터의 개수 제한에 사용되는 `lengh`를 계산합니다.
  - String 타입으로 반환되는 데이터와 에러는 각각의 StringBuilder의 append로 합칩니다.
  - `move()` 메서드를 통해 방향 분기를 설정하여 로직을 진행합니다.
  - 데이터와 에러의 결과를 `printResult()`로 보내 출력합니다.

### ⚙️ InputView

- 사용자 입력을 받습니다.

## 💻 결과화면 1

![image](https://github.com/yonghyeonpark/Codesquad-Programming-Practice/assets/126778700/23878046-47d8-461a-97de-681caa68f656)

## 💻 결과화면 2

`시작 혹은 끝 영역이 올바르지 않은 경우`

![image](https://github.com/yonghyeonpark/Codesquad-Programming-Practice/assets/126778700/c7c615a4-e493-4897-a335-a0c19da72850)

## 💻 결과화면 3

`QR 코드의 가로 길이가 올바르지 않은 경우`

![image](https://github.com/yonghyeonpark/Codesquad-Programming-Practice/assets/126778700/0fc82ac0-be10-4ad6-963b-6849547c6fca)

## 💻 결과화면 4

`QR 코드의 세로 길이가 올바르지 않은 경우`

![image](https://github.com/yonghyeonpark/Codesquad-Programming-Practice/assets/126778700/7bbd4df0-9d4b-4766-b6c4-70710fdae5c6)
