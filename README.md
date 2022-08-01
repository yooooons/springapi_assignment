# Spring학생 정보 관리 REST API 구현 및 REST API 개념 문서 작성 
![image](https://user-images.githubusercontent.com/96519249/182191528-d99f93c0-04e4-426d-9f3e-4a05e22b92cd.png)

### 요구사항
#### 데이터 베이스 List로 대체한다.
#### 등록
* 학생등록시 중복의 검증 절차를 가진다.


#### 조회
* 모든 학생의 데이터를 가져올 수있다.

* 학생의 아이디를 통해서 학생정보를 가져올 수 있다.
* 학생의 이름를 통해서 학생정보를 가져올 수있다. 중복된 이름일 시 모두 조회한다.
* 조회하려는 학생이 없을경우 404에러와 함께 "학생을 찾을수 없습니다."라는 메세지를 전달한다.
#### 삭제
* 학생의 아이디를 통해서 학생정보를 삭제할 수 있다.
* 삭제하려는 학생이 없을경우 404에러와 함께 "학생을 찾을수 없습니다."라는 메세지를 전달한다.

#### 수정
* 학생의 아이디를 통해서 학생정보를 단건으로 수정할 수 있다.
* 학생의 학급진급시 학년만 올릴 수 있다. 6학년이 넘어갈때는 "해당 학생은 졸업반입니다."라는 메세지를 호출한다.
* 수정하려는 학생이 없을경우 404에러와 함께 "학생을 찾을수 없습니다."라는 메세지를 전달한다.

##### 모든 api는 dto를 사용하여 데이터를 입출력하였습니다.  
  
## 등록
![image](https://user-images.githubusercontent.com/96519249/182198357-2a22761c-938d-4abe-8480-9afeb5e4a362.png)
![image](https://user-images.githubusercontent.com/96519249/182198433-f32fc386-74d1-4c8c-b585-136b0d1531a5.png)

## 조회
![image](https://user-images.githubusercontent.com/96519249/182198581-79c411c7-63b5-4f36-883d-f9b30c991002.png)
![image](https://user-images.githubusercontent.com/96519249/182198727-6c947957-7d45-4685-8353-ae54c5e34f5f.png)
![image](https://user-images.githubusercontent.com/96519249/182198788-20afed67-62c4-4b1a-a433-fb6a31bb4d50.png)  

## 삭제
![image](https://user-images.githubusercontent.com/96519249/182199021-94c4a97e-cc2e-41ff-8b0c-6527d1309612.png)
![image](https://user-images.githubusercontent.com/96519249/182199079-1155de95-eace-4776-b1a8-497c7426868c.png)  

## 수정
![image](https://user-images.githubusercontent.com/96519249/182199441-c38c6196-2f91-450f-b20a-d332ed41a538.png)
![image](https://user-images.githubusercontent.com/96519249/182199492-74480e2b-679b-4078-bb92-2b883af4d1ef.png)
![image](https://user-images.githubusercontent.com/96519249/182199578-cb52fb75-bc2a-4d3d-824b-78e877f7046b.png)
![image](https://user-images.githubusercontent.com/96519249/182199625-195b0e02-1713-418b-a72f-6a51572682aa.png)








