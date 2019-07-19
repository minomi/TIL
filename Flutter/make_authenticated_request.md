# 인증된 요청 만들기

웹 서비스에서 데이터를 가져 올 때 인증이 필요할 때가 있다. 많은 방법이 있겠지만 대부분의 경우는 **Authorication** HTTP 헤더를 사용한다.

### authorization header 추가 하기

**http** 패키지는 request 에 header 를 추가하는 편리한 방법들을 제공한다. dart:io 라이브러리에서 [HttpHeader](https://api.dart.dev/stable/2.4.0/dart-io/HttpHeaders-class.html) 를 사용해보자

```
Future<http.Response> fetchPost() {
	return http.get(
		headers: {HttpHeaders.authorizationHeader: "Basic your_api_token_here"},
	)
}
```

### authoration header 를 추가한 완성 코드

```
Future<Post> fetchPost() async {
	final response = await http.get(				headers: {HttpHeaders.authorizationHeader: "Basic your_api_token_here"},
	);
	
	final reponseJson = json.decode(response.body);
	
	return Post.fromJson(reponseJson);
}
```