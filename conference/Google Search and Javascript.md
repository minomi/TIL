### 현대의 웹 사이트
콘텐츠를 통 JS 로 생성한다. => 구글봇이 크롤링 할 html 이 없는 거 아냐??? =>  응 아냐

#### Puppeteer
Headliss Chrome 을 더 잘 구동시키기 위한 node api

구글봇은 Puppeteer 를 이용해서 페이지를 렌더링해 크롤링 한다. => SPA 가 검색에 영향을 미치지 않는다.

#### Robot.txt

Googlebot 이 어디까지 수집을 할 것인가에 대해서 정의한 파일, 굳이 추가 안해도 된다.

##### 만약 검색되지 않아야 한다면

* 도메인을 아예 분리한 후 해당 도메인을 통째로 차단한다.
* 검색되지 않아야 하는 내부페이지등은 인증을 거쳐야지 볼 수 있도록 한다.

### 어떻게 해야 상단에 노출될까?

#### \<title> 잘 사용하기

적절하게 콘텐츠를 설명하는 제목을 사용하면서, 사이트를 잘 설정하고 있는 경우

#### 올바른 description 사용

* 아예 description 태그를 사용하지 않은 경우 (x)
* og:description 만 선언해놓은 경우 (x)
* description 태그도 선언하고, og:description 도 선언해야 (o)

#### 올바른 HTML Tag 사용

> 페이지 이동할때는 a tag, 제목은 h1 tag

#### 반응형 웹 디자인
구글은 모바일을 지원하는 페이지를 우선적으로 노출시킨다.

#### Structured Data 쓰기
schema.org 에 정의되어 있는 데이터 중 입맛에 맞는거 가져온다. <br>
google search structed data 검색 ㄱㄱ


#### LightHouse 활용

웹 페이지 종합 검사기

web.dev 참조

#### 그 외에도
* 속도가 빨라야 한다. (1초, 아무리 네트워크가 느려도 3초 안에는 페이지 렌더링이 끝나야 한다.)
* 모바일을 지원해야 한다
* 이런 항목이 100개가 넘게 있음, 다 연구 못함

#### 국내에서 되게 잘한 케이스
* 나무위키
* 망고플레이트

#### 질문

* 모바일은 지원하냐? 안하냐? 는 어떻게 아냐
	* puppeteer 가 모바일 픽셀로 렌더링 해서, 페이지가 깨지는 정도? 를 체크하는듯