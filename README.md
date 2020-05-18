# NewsBada
뉴스 제공 서비스


## 목차
- 개요
  - 아이디어 개요
  - 주제 선정 배경 및 필요성
  - 개발 목표
  
- 요구사항 분석
  - 기능적 요구사항
  - 비기능적 요구사항
  - Use Case List
  
- 개발 개요 및 환경 구축
  - 시스템 구조도
  - 데이터베이스 스키마
  - ER 다이어그램
  - 개발 환경 구축
  
- 구현 프로그램 및 주요기능
  - 구현 프로그램
  - 주요 기능
  
- 결론 및 향후 계획
  - 개발 일정
  - 개발 자원
  - 기대 효과
  - 향후 개선점


## 1. 개요
### 1.1 아이디어 개요  
 뉴스바다는 사용자에게 뉴스 기사를 보여주는 프로그램이다. 오프라인에 존재하는 신문 가판대를 온라인으로 제공하는 서비스이다. 사용자들은 애플리케이션에 접속하여 정치, 사회 등 다양한 테마 별로 기사를 보게 된다. 기사 리스트에는 기자와 언론사, 타이틀이 보여진다. 유저가 특정 기사를 선택하여 들어가면 기사의 본문 일부, 작성 날짜, 작성자 등의 정보를 보여준다. 유저가 기사의 본문 전체를 확인하고 싶을 경우 해당 기사 URL과 연결된 버튼을 눌러 해당 기사가 있는 페이지로 이동한다.  
 그리고 뉴스바다는 기사의 인기 척도를 보여준다. 기사의 조회수를 제공하며 해당 기사 타인들에게 얼마나 인기가 있는지 알게 된다. 또한, 유저는 성별의 정보를 가지고 있어, 유저가 해당 기사를 읽을 경우 해당 기사의 성별 조회수가 기록된다. 그리고 DB에 내용이 업데이트 되고, 기사 화면에 해당 정보가 표현된다. 따라서 유저는 각 기사의 남녀의 조회수와 비율을 알 수 있다. 또한, 본문의 내용을 전부 노출 시키지 않아 사용자들의 호기심을 유발하고, 해당 사이트에 직접 연결해 주어 사용자에게 칼럼 본문을 볼 수 있도록 한다.  
 
 ### 1.2 주제 선정 배경 및 필요성  
 현재, 포탈 사이트에 존재하는 대부분의 뉴스는 메인 홈페이지에 무작위로 노출되는 것이 대부분이다. 사용자들에게 기사의 인기 척도를 제공하는 것은 크게 존재하지 않는다. 대부분의 포탈사이트에서 스포츠, 연예, 정치 등 테마에만 댓글이 활성화 되어 있을 뿐 나머지 테마들은 댓글 시스템이 크게 활성화 되지 않았다. 또한 성별로 해당 기사의 조회수를 알 수 있는 프로그램은 존재하지 않는다. 뉴스바다는 성별로 조회수를 알려줘 해당 기사에 대한 성별 관심도를 쉽게 알 수 있다. 남성과 여성간의 뉴스 기사 및 주제 관심도를 파악하는데 도움이 된다.  
![alt_text](https://github.com/Juhee-Maeng/Team2Project/blob/master/images/figure1.png)

### 1.3 독창성 및 차별성  
 기존의 글 관련 큐레이션 서비스들이나 뉴스RSS 서비스들은 정보를 얻는 걸을 목적으로 둔다. 또한, 기존의 포탈사이트에서는 신문사 별 혹은 날짜 별로만 분류하여 칼럼을 제공하고 있다. 따라서 사실에 기반한 글이 대부분을 이루며, 정보를 얻는 것에서 서비스는 그친다. 본 서비스의 차별성은 성별로 조회수를 같이 알려줘 남, 여간의 관심사 파악을 하는 자료로 활용 가능하다.  
 내용 전체를 직접 가져오지 않고 일부분만 노출 시켜 해당 언론사에 접근 하기 위한 호기심을 유발 시킨다. 오프라인에서 직접 들고 다니며 각 신문사 별 신문을 구매할 필요 없이 다양한 신문사의 칼럼을 모두 보여준다. 또한, 관심 기사 및 언론사에 쉽게 접근을 유도해 사용자에게 많은 기사를 제공해 준다.  

## 2. 요구사항 분석  
### 2.1 기능적 요구사항
![alt_text](https://github.com/Juhee-Maeng/Team2Project/blob/master/images/table1.PNG)

### 2.2 비기능적 요구사항
![alt_text](https://github.com/Juhee-Maeng/Team2Project/blob/master/images/table2.PNG)

## 3. 개발 개요 및 환경 구축  
### 3.1 시스템 구조도  
![alt_text](https://github.com/Juhee-Maeng/Team2Project/blob/master/images/figure2.png)  
우선 신문사에 존재하는 다양한 기사 칼럼을 크롤링하여 이를 DB 서버에 저장한다. 신문사의 경우 주로 포탈사이트 기사 위주로 크롤링 작업을 거쳤다. 크롤링은 R 라이브러리를 사용하였고, DB는 MySQL 서버에 구축하였다. 그리고 DB와 JAVA GUI를 연결하여 서비스를 개발하였다. 사용자는 JAVA GUI를 통해 우리의 서비스를 사용한다.  

### 3.2 데이터베이스 스키마  
![alt_text](https://github.com/Juhee-Maeng/Team2Project/blob/master/images/figure3.png)  
- ARTICLE 테이블 : 기사에 대한 기본 정볼르 저장하고 있는 테이블이다. 해당 기사의 테마, 성별 조회수 등의 정보를 담고 있다. Primary Key는 기사 번호(=A_Number)이다.  

- ULR 테이블 : 기사에 해당하는 URL과 날짜, 제목, 본문 썸네일 이미지를 담고 있다. 해당 정보들은 칼럼 뷰 페이지를 노출 시키는데 사용한다. Url의 경우 ARTICLE 테이블의 기사 번호를 참조한다.  

- READ_ON 테이블 : 사용자가 글을 읽게 되면 사용자와 읽은 기사가 무엇인지 저장하는 테이블이다. USER와 ARTICLE 테이블과 서로 연관되어 있다.  

- USER 테이블 : 사용자에 대한 기본 정보를 저장하고 있는 테이블이다. Primary Key는 사용자의 ID이다.  

### 3.3 ER 다이어그램  
![alt_text](https://github.com/Juhee-Maeng/Team2Project/blob/master/images/figure4.png)  
우선 ARTICLE Entity를 살펴보면 URL_INFO Entity와 INFO Relation을 이루고있다. 두 Entity는 Url 정보를 Foreign Key로 서로 관계를 맺는다. ARTICLE의 경우 기사에 대한 성별 조회수, 테마에 대한 정보를 담고, URL_INFO의 경우 해당 기사의 날짜, 제목, 본문에 대한 정보를 담고 있는다. READ_ON Entity는 사용자가 해당 기사를 읽었는지 판단하기 위해 ARTICLE Entity와 연결되어 있고, Foreign Key는 A_Number이다. 그리고 READ_ON Entity와 USER Entity를 연결하여 사용자가 기사를 읽었는지 여부에 대한 정보를 저장한다. Foreign Key는 ID이다.  

### 3.4 개발 환경 구축
#### 개발 환경
  - 작성 언어 : JAva
  - 데이터베이스 : MySQL
  - DB 연결 : Java JDBC
  - 크롤링 언어 : R
  
#### 크롤링 과정
R의 'rvest' 패키지를 이용하여 각 뉴스마다 본문, 제목, url을 가져오기 위해 html node를 분석하였다. 그 결과 각 뉴스에 해당하는 node는 '#section_body li'이었다. 

- 기사 크롤링 과정 - MySQL  
![alt_text](https://github.com/Juhee-Maeng/Team2Project/blob/master/images/figure5.png)  

- 기사 크롤링 과정 - 썸네일 크롤링  
![alt_text](https://github.com/Juhee-Maeng/Team2Project/blob/master/images/figure6.png)  

- 기사 크롤링 과정 - HTML 코드  
![alt_text](https://github.com/Juhee-Maeng/Team2Project/blob/master/images/figure7.png)  

#### 데이터베이스 정규화 
![alt_text](https://github.com/Juhee-Maeng/Team2Project/blob/master/images/figure8.png) 
- 1NF는 값이 1개씩만 존재하므로 만족
- 키(=Key)에 속하지 않는 애트리뷰트 모두가 기본키에 완전 함수 종속이므로 2NF 만족
- 키(=Key)에 속하지 않은 모든 애트리뷰트들이 기본 키에 이행적 함수 종속이 아니므로 3NF 만족
- 릴레이션 R의 모든 결정자가 후보키 이므로, BCNF 만족

## 4. 구현 프로그램 주요 기능 
### 4.1 구현 프로그램 - 뉴스바다 
각종 테마 및 신문사의 기사 정보를 받고, 사용자에게 다양한 기사를 보여주는 종합 신문 기사 제공 프로그램 

### 4.2 주요 기능
#### 사용자 로그인 및 가입 
- NewsBada 로그인 화면  
![alt_text](https://github.com/Juhee-Maeng/Team2Project/blob/master/images/figure9.png)  

- NewsBada 가입하기  
![alt_text](https://github.com/Juhee-Maeng/Team2Project/blob/master/images/figure10.png)  

#### 뉴스 카드 패널 재공  
- NewsBada - 기사 패널 뷰  
![alt_text](https://github.com/Juhee-Maeng/Team2Project/blob/master/images/figure11.png)  

- 기사 제목 및 텍스트 화면  
![alt_text](https://github.com/Juhee-Maeng/Team2Project/blob/master/images/figure12.png)  

- 기사 검색 기능  
![alt_text](https://github.com/Juhee-Maeng/Team2Project/blob/master/images/figure13.png)  

## 5. 결론 및 향후 계획  
### 5.1 개발 일정  
- 세부 개발 일정  
![alt_text](https://github.com/Juhee-Maeng/Team2Project/blob/master/images/table4.png)  

- WEBS  
![alt_text](https://github.com/Juhee-Maeng/Team2Project/blob/master/images/table5.png)  

### 5.2 기대 효과  
- 신문사마다 성향과 시각이 다양한데, 서비스 이용자의 측면에서는 하나의 플랫폼에서 여러 신문사들의 칼럼을 볼 수 있으므로 한 주제에 대해 다양한 시각을 볼 수 있다.  
- 기존에 자신의 관심분야의 글 위주로 읽던 이용자들에게 새로운 주제의 칼럼을 제시하여 이요자로 하여금 관심분야 확장을 유도한다.  
- 기사에 대한 성별 조회수를 제공하여 기사에 대한 성별 관심도를 알 수 있다.  

### 5.3 향후 개선점  
- 테마가 현재 6개에 대해서 노출하고 있기 때문에 더 많은 테마 기사 DB 크롤링 개발이 필요
- 성별 조회수에 따른 좋아하는 기사 정렬 기능 추가  
- 댓글 기능을 통해 사용자간의 커뮤니케이션 및 의견 전달 기능 추가  

## 6. 참고 자료  
- 1) 송인근 (2002), 『신문산업 발전을 위한 공동배달제의 실증적 연구 : "A" 신문사 단독지국과 겸영지국 비교 중심으로』 서강대학교 언론대학원  
- 2) 강길홍 (2015) 『모바일뉴스 시대의 미디어 신뢰도에 관한 연구』 중앙대학교 신문방송대학원


