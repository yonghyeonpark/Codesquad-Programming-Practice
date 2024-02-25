# 📅 Day 10

# 🗃️ 로그 분석하기

## 📝 설계

![KakaoTalk_20240225_193725722](https://github.com/yonghyeonpark/Codesquad-Programming-Practice/assets/126778700/3528df9c-7993-4109-bf37-1651a9b4410d)

## 🛠️ 기능 분리

### ⚙️ Log

- 로그 레벨, 기록 시각, 프로세스, 기록을 필드로 갖습니다.
- 로그 레벨과 프로세스를 매개변수로 받아 해당 로그의 필드와 일치하는지 확인합니다.

### ⚙️ LogRepository

- 로그 List, 로그 레벨 Set, 프로세스 Set을 필드로 갖습니다.
- 로그를 매개변수로 받아 로그 리스트에 추가하고, 해당 로그의 레벨, 프로세스를 각 Set에 추가합니다.

### ⚙️ LogManager

- 로그를 로그 리포지토리에 저장합니다.
- 로그 레벨을 매개변수로 받아 해당하는 로그들을 출력합니다.
- 프로세스를 매개변수로 받아 해당하는 로그들을 출력합니다.
- 기록 시각에 따라 오름차순으로 정렬합니다.
- 프로세스에 따라 오름차순으로 정렬합니다.
- 각 로그 레벨별로 개수를 셉니다.
- 각 프로세스별로 개수를 셉니다.
- 검색 가능한 로그 레벨을 출력합니다.
- 검색 가능한 프로세스를 출력합니다.

### ⚙️ FileReader

- 해당 경로의 파일을 한 라인씩 읽고, LogManager로 넘깁니다.

### ⚙️ Controller

- 사용자 입력에 따라 분기를 진행합니다.
- 탈출 명령어, `exit`를 입력하면 프로그램을 종료합니다.

### ⚙️ InputView

- 사용자 입력을 받습니다.

## 💻 결과 화면 1

![image](https://github.com/yonghyeonpark/Codesquad-Programming-Practice/assets/126778700/5a0d1f8e-6a10-418c-8d46-ee9ae367768d)
<br>...<br>
![image](https://github.com/yonghyeonpark/Codesquad-Programming-Practice/assets/126778700/e6911ba4-5b97-4a00-92cf-3e6b538da3a4)

## 💻 결과 화면 2

![image](https://github.com/yonghyeonpark/Codesquad-Programming-Practice/assets/126778700/48ea3ea0-351e-4da8-bc9c-62c0af32e186)

## 💻 결과 화면 3

![image](https://github.com/yonghyeonpark/Codesquad-Programming-Practice/assets/126778700/84957d7a-cb54-48ef-92af-358adc4b11a9)