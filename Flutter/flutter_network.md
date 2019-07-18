# Fetch data from th internet

대부분 앱에서 Web 을 통해 데이터를 가져오는건 필수기능 이다. 다행히 Dart 와 Flutter 는 `http` package 같은 도구를 제공한다.

이번 장에서는 
1. `http` 패키지 를 추가하고
2. `http` 패키지 를 통해 요청을 만들고
3. 응답을 Dart object 로 변경하고
4. Flutter 를 통해 데이터를 화면에 보여주는 것을 할 것이다.

### 1. http package 추가하기

`http` 패키지를 이용하면 인터넷에서 데이터를 간단하게 가져올 수 있다.

http 패키지를 다운받으려면 `pubspec.yaml` 에 다음 코드를 추가해라.

```Dart
dependencis:
	http: <latest_version> 
```

latest_version 을 [http package](https://pub.dev/packages/http#-installing-tab-) 에서 찾을 수 있다.

### 2. 네트워크 요청 만들기

```Dart
Future<http.Response> fetchPost() {
	return http.get('https://jsonplacehloder.typicode.com/posts/1')
}
```

샘플 포스트를 JSONPlaceholder 에서 가져오는 예이다.

http.get() 메서드는 Response의 Future 를 반환한다.

* Future 은 비동기 작업을 할때 쓰이는 core Dart class 이다. Future 객체는 어떤 값이나 에러를 가지고 있고, 이 값은 미래에 사용가능합니다.
* http.Response 클래스는 성공적인 http 요청에 대한 데이터를 포함하고 있습니다.

### 3. 응답을 Dart 객체로 바꾸기

http 요청을 쉽게 만들수 있지만 `Future<http.Response>` 를 그대로 사용하기에는 좀 불편하다. `http.Response` 를 더 쉽게 Dart 객체로 바꾸어보자

Post Dart 객체 

```
class Post {
	final int userId;
	final int id;
	final String title;
	final String body;
	
	Post({this.userId, this.id, this.title, this.body});
	
	factory Post.fromJson(Map<String, dynamic> json) {
		return Post(
			userId: json['userId'],
			id: json['id'],
			title: json['title'],
			body: json['body']
		);
	}
}
```

`fetchPost()` 함수를  `Future<Post>` 를 리턴하도록 바꾸어 보자

1. dart:convert 패키지를 사용해서 response body 를 JSON Map 으로 바꾸자.
2. 서버에서 200 을 응답하면, JSON Map 을 `fromJson()` 팩토리 메서드를 사용해 Post 객체로 변환하자
3. 서버가 예기치 못한 응답을 하면 error 를 던지자.

```
Future<Post> fetchPost() async {
	final response = await http.get('https://jsonplacehloder.typicode.com/posts/1');
	
	if (response.statusCode == 200) {
		return Post.fromJson(json.decode(response.body));
	} else {
		throw Exception('Failed to load post');
	}
}
```

### 4. 데이터 가져오고 화면에 보여주기

가져온 데이터를 화면에 보여주기 위해 `FutureBuilder` 를 사용할 것이다. `FutureBuilder` 는 Fultter 와 함께 제공되고, 비동기 데이터를 다룰때 유용하다.


2개의 파라미터가 필요하다.

1. Future 객체
2. Future 의 상태에 따라 무엇을 그릴지 정하는 `builder function` 

```
FutureBuilder<Post>(
	future: fetchPost(),
	builder: (context, snapshot) {
		if(snapshot.hasData) {
			return Text(snapshot.data.title);
		} else if (snapshot.hasError) {
			return Text("${snapshot.error}");
		}
		
		return CircularProgressIndicator();
	}
)
```

5. build() 메서드 밖에서 fetch 메서드를 빼기

편하긴 하지만 build() 메서드 안에서 API 를 호출하는것을 권하지 않는다.

build() 메서드는 Flutter 가 view 안에 변화가 있으면 매번 호출하기 때문이다. 
build() 메서드 안에 fetch API 가 있다면, 불필요한 API 요청 때문에 app 이 느려질 것이다.
