# 📅 day 13
# 비트맵 폰트

## 📝 설계

- 비트맵 폰트를 담을 자료구조로 `enum`을 선택했습니다.
  - 분기를 나누지 않고, enum의 name을 통해 사용자 입력값에 대한 처리를 하기 위해 선택했는데, 
  Map에 담아서 key와 사용자 입력값을 매칭하는 방식도 괜찮았을 것 같다는 생각이 듭니다.
- 변환 과정
  - 라인별로 2진수를 나타내는, 문자열 리스트 타입의 리스트를 생성합니다.
  - 라인별로 변환된 16진수가 하나의 문자열을 합쳐진, 문자열 리스트를 생성합니다.
  <br>=> 라인별로 4바이트씩 분리하여 포맷합니다.

## 🛠️ 기능 분리

### ⚙️ BitMapFont

- 비트맵 폰트를 관리합니다. (0~9, 공백)
  - 16비트씩 나누어 담습니다.<br>
  ex) `List.of("0000", "1000")`

### ⚙️ Processor

- setUp()
  - 입력값 길이에 따라 `16바이트 단위`의 수를 설정합니다.
  - 입력값에 해당하는 비트맵 폰트를 `numbers`에 추가합니다.
- setLines()
  - index 기준 0~7라인까지 각 라인에 해당하는 (16비트씩 나누어진) 2진수 문자열들을 `lines`에 저장합니다. 
- process()
  - `lines`에서 각 라인의 문자열(2진수)들을 16진수로 변환하여 하나의 문자열로 만듭니다.
  - 16바이트를 기준으로 잡고, 뒤에 빈 공간에는 모두 0을 채워 넣습니다.
- format()
  - 매개변수로 들어온 하나의 `line`에 대해 `substring()`을 사용하여 8문자씩 쪼갠 후, 예시의 형식대로 포맷하여 다시 리스트에 담아 반환합니다.
- binaryToHex()
  - 2진수를 10진수로 변환 후, 16진수로 변환하여 반환합니다.

### ⚙️ Controller

- 사용자 입력에 대한 변환을 진행합니다.

### ⚙️ InputView

- 사용자 입력(word)을 받습니다.

## 테스트 결과

![image](https://github.com/yonghyeonpark/Codesquad-Programming-Practice/assets/126778700/b21d1fa1-8d72-43dc-a44f-ae0dca13fded)

## 💻 결과화면 1

![image](https://github.com/yonghyeonpark/Codesquad-Programming-Practice/assets/126778700/29d16d3c-54a0-4444-a7e0-5d42f8bb57a8)

## 💻 결과화면 2

![image](https://github.com/yonghyeonpark/Codesquad-Programming-Practice/assets/126778700/be23b16d-9a63-461d-bba2-4f861c841162)

## 💻 결과화면 3

![image](https://github.com/yonghyeonpark/Codesquad-Programming-Practice/assets/126778700/ef594840-ab08-4715-8170-47108006f9ef)

## 💻 결과화면 4

![image](https://github.com/yonghyeonpark/Codesquad-Programming-Practice/assets/126778700/c1c297bd-5e72-4d9f-b3c3-b2abde63f3f8)

## 💻 결과화면 5

![image](https://github.com/yonghyeonpark/Codesquad-Programming-Practice/assets/126778700/6308d080-383c-4707-8b8e-bd8b4ceb708f)