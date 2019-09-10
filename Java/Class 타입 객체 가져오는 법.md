### Class 타입 객체 가져오는 법

```JAVA
Class<Book> bookClass = Book.class;

Book book = new Book();
Class<? extends Book> bookClass2 = book.getClass();

String bookClassFQCN = "me.minho.Book";
Class<?> bookClass3 = Class.forName(bookClassFQCN);
```

Class 타입 객체는 클래스 로더가 로딩 시점에 객체 만들어서 힙에 넣는거 알고있제? 



