# 📅 Day 9

# 📁 CSV 파일

## 📝 설계

- 정규식을 활용합니다.
- 데이터 입력 시, 테이블의 컬럼 순서대로 입력한다고 가정합니다.
- `CREATE`
  ![image](https://gist.github.com/assets/126778700/1b911263-d083-41f3-a016-1147d2c9bda5)
- `INSERT`
  ![image](https://gist.github.com/assets/126778700/aa355571-deca-4dc9-9dd7-034cafbccfef)
- `DELETE`
  ![image](https://gist.github.com/assets/126778700/c1b6e01b-23e5-434b-9065-a47dba004745)
## 🛠️ 기능 분리

### ⚙️ Table

- 테이블 이름, 컬럼 리스트, 데이터 리스트, id를 필드로 갖습니다.
- 생성자에서 매개변수로 컬럼 리스트를 받고, 해당 리스트의 맨 앞에 `id`를 추가하고 필드에 저장합니다.
- `insertData()`
  - 매개변수로 데이터를 받고, 그 크기가 id를 제외한 컬럼의 개수와 일치하면, 데이터 추가 로직을 진행합니다.
  - 매개변수인 데이터의 맨 앞에 id 값을 추가하고 데이터 리스트에 추가합니다.
  - 추가된 데이터의 정보를 출력하고 id 값을 1 증가시킵니다.
- `deleteData()`
  - 컬럼명과 그 값을 매개변수로 받습니다.
  - 데이터 리스트에 대해 iterator를 사용하여 해당 컬럼에 대한 값이 존재하는지 찾습니다.
  - 찾는 데이터가 존재하면 제거 후, 제거된 데이터의 정보를 출력합니다.

### ⚙️ Database

- 테이블 리스트를 필드로 갖습니다.
- `addTable()`
  - 테이블을 추가하며, 추가할 때마다, 리스트에 중복되는 테이블명이 존재하는지 확인합니다.
- `findTable()`
  - 테이블 이름을 매개변수로 받은 후, 해당 테이블을 찾아 반환합니다. (해당 테이블이 존재하지 않을 경우, 예외가 발생합니다.)

### ⚙️ SqlProcessor

- `COMMAND_REGEX`를 사용해, 명령어를 확인하고, 해당하는 분기로 들어갑니다.
- `CREATE`
  - `CREATE_TABLE_REGEX`를 사용해, 테이블명과 컬럼 리스트을 얻고, 테이블을 생성한 후, 데이터베이스에 해당 테이블을 추가합니다.
- `INSERT`
  - `INSERT_DATA_REGEX`를 사용해, 테이블명과 컬럼 리스트, 값 리스트를 얻고, 해당 테이블에 컬럼 리스트와, 값 리스트를 넘깁니다.
- `DELETE`
  - `DELETE_DATA_REGEX`를 사용해, 테이블명과 조건(컬럼과 값)을 얻고, 해당 테이블에 조건을 넘깁니다.

### ⚙️ FileManager

- 테이블명으로 파일을 생성합니다.
- 해당 파일에 텍스트를 작성합니다.
- 해당 파일의 텍스트를 삭제(다른 텍스트로 대체)합니다.
- 해당 파일을 삭제합니다.

### ⚙️ Controller

- sql 명령문을 반복해서 입력받습니다.
- `exit`이 입력되면 생성된 파일들을 삭제하고 프로그램이 종료됩니다.
- 예외가 발생할 경우, 올바른 입력이 들어올 때까지 반복합니다.

### ⚙️ InputView

- SQL 명령문인 문자열을 입력받습니다.

## ✅ 예외 처리

- Table
  - 컬럼의 개수를 확인합니다. (1~9)
  - insert 데이터의 컬럼, 값의 수가 일치하는지 확인합니다.
  - insert 데이터의 컬럼명과 해당 테이블의 컬럼명이 일치하는지 확인합니다.
  - insert 데이터의 컬럼 개수와 해당 테이블의 컬럼 개수가 일치하는지 확인합니다.
  - delete 조건에 해당하는 데이터가 있는지 확인합니다.

- Database
  - create 시, 테이블 이름이 기존 테이블과 중복되는지 확인합니다.
  - insert 혹은 delete 시, 해당 테이블이 존재하는지 확인합니다.

- SqlProcessor
  - create 시, 컬럼의 타입이 유효한지 확인합니다.

## 💻 결과 화면 1

![image](https://gist.github.com/assets/126778700/d131e30b-19c0-4d53-8702-95e5bf748e2c)

![image](https://gist.github.com/assets/126778700/02f50957-a41c-4bb2-b452-f1850d8e1d6d)

## 💻 결과 화면 2

![image](https://gist.github.com/assets/126778700/3b09e659-8245-49c7-97d4-42df9d130d7f)

## 💻 결과 화면 3

![image](https://gist.github.com/assets/126778700/00048edc-f14f-4766-9778-ab69e30772e5)

![image](https://gist.github.com/assets/126778700/ef4b10e3-5836-4cdf-985a-6a324b22e80d)

## 💻 결과 화면 4

![image](https://gist.github.com/assets/126778700/551d90c8-2ff2-4c50-888d-eabca86759e4)