### URLSession Tutorial

URLSession - HTTP를 통해 content를 업로드, 다운로드 하기 위한 Apple 이 제공하는 networking API


#### URLSession 관련 클래스

![URLSessionSimpleClass](https://koenig-media.raywenderlich.com/uploads/2017/06/url_session_diagram_1.png)

* URLSession - HTTP requests 를 보내고 받는 걸 책임지는 Key object
* URLSessionConfiguration - session 프로퍼티들을 설정하는 객체 3가지 설정이 있다.
  * .default - disk-persisted 전역 캐시, 자격 증명 및 쿠키 저장소 개체를 사용하는 기본 설정
  * .ephemeral - session 과 관련된 데이터를 메모리에 저장하는 것을 제외하고 default 설정이랑 비슷
  * .background - 세션이 업로드, 다운로드 테스크를 백그라운ㄷ에서 수행할 수 있게 한다. 앱이 시스템에 의해서 멈추거나, 종료되어도 계속 진행된다.
* USLSessionTask - task 객체를 나타내는 추상 클래스, 세션은 로드, 업로드, 데이터 fetching 을 하는 하나 이상의 테스크를 만든다. 세 가지 유형의 구제적인 task가 있다.
  * URLSessionDataTask - 데이터를 서버에서 메모리로 가져오는 HTTP GET requests를 하기 위해 사용
  * URLSessionUploadTask - 통 HTTP POST 나 PUT 메서드를 통해서 disk에서 web service로 파일 업로드 하기 위해 사용
  * URLSessionDownloadTask - remote service에서 temporary file location 으로 파일 다운로드 할때 사용

  ![URLSessionTask](https://koenig-media.raywenderlich.com/uploads/2017/06/url_session_diagram_2.png)

> URLSession data task 의 default request method 는 GET 이고, POST,PUT 또는 DELETE dataTask 를 하려면 URL을 사용해서 URLRequest 를 만들고 적절한 HTTPMethod를 세팅해야 한다. 그리고 URL 대신 URLRequest을 사용해서 data task 를 생성하자.

> background 에서 다운로드 작업을 하기 위해서, URLSessionConfiguration.default 대신 init(withIdentifier:) 이니셜라이져로 새로운 URLSessionConfiguration을 생성해야 한다.
필요한 경우 여기에 앱에서 새 백그라운드 세션을 만들수 있기 때문이다. 그리고 background configuration 에 하나 이상의 세션을 만들면 안된다, 시스템에서 configuration의 identifier를 사용하여 세션과 task를 연관시키기 때문이다. background 에서 작업이 완료되면 앱이 재시작 되는데 AppDelegate의 application(_:handleEventsForBackgroundURLSession:) 메서드가 앱을 깨우고, URLSessionDelegate 에서 인자로 넘어온 completionHandler를 처리할 수 있다.


reference : https://www.raywenderlich.com/158106/urlsession-tutorial-getting-started
