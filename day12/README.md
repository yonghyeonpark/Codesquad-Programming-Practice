# 📅 day 12

# HEAP 메모리

## 🛠️ 기능 분리

### ⚙️ Heap

- `init(heapSize)`
  - 힙 사이즈를 매개변수로 받고, 상수로 설정된 기본 주소를 반환합니다.
  - 힙 사이즈를 이용해, 공간이 할당되었는지 확인하기 위한 배열의 크기를 설정합니다.
- `setSize(type, length)`
  - Map에 type을 key로, length를 value로 저장합니다.
  - 길이는 지정된 숫자만 사용됐는지, 타입은 중복되지 않는지 체크합니다.
- `malloc(type, count)`
  - 타입을 count만큼 곱해서 할당할 크기를 구합니다.
  - `isFull` 배열을 순회하며 빈공간들을 찾아, 위에서 구한 크기만큼 메모리를 할당합니다.
  - 매개변수로 넘어온 type과 count를 필드로 갖는 Data 객체를 List에 담습니다.
- `free(pointer)`
  - Data 타입의 List를 순회하며, 매개변수인 pointer에 해당하는 Data 객체를 찾아, 그 객체가 갖고 있는 인덱스에 해당하는 메모리 공간을 비웁니다. 
- `usage()`
  - `isFull` 배열을 사용하여 전체 용량, 사용량, 잔여량을 구합니다. 
- `heapdump()`
  - Data 타입의 List를 순회하며, 해당 객체들을 출력합니다.

### ⚙️ Data

- 타입, 크기, 할당된 공간의 위치(인덱스) 리스트를 필드로 갖습니다.
- 위치 리스트에 인덱스를 추가합니다.
- 상대 주소를 반환합니다.

## 💻 결과화면

> 호출

![image](https://github.com/yonghyeonpark/Codesquad-Programming-Practice/assets/126778700/fa6304f1-5e97-49e5-9aad-d14333113811)

> 결과

![image](https://github.com/yonghyeonpark/Codesquad-Programming-Practice/assets/126778700/3a52acca-219f-454b-8c85-576815b9c406)