Kanna 라는 라이브러리를 쓰다 XPath 라는 용어가 나옴 XPath?????

> XPath
XML 문서의 구조를 통해 경로 위에 지정한 구문을 사용하여 항목을 배치하고 처리하는 방법을 기술하는 언어.

```XML
<?xml version="1.0" encoding="utf-8"?>
<wikimedia>
  <projects>
    <project name="Wikipedia" launch="2001-01-05">
      <editions>
        <edition language="English">en.wikipedia.org</edition>
        <edition language="German">de.wikipedia.org</edition>
        <edition language="French">fr.wikipedia.org</edition>
        <edition language="Polish">pl.wikipedia.org</edition>
      </editions>
    </project>
    <project name="Wiktionary" launch="2002-12-12">
      <editions>
        <edition language="English">en.wiktionary.org</edition>
        <edition language="French">fr.wiktionary.org</edition>
        <edition language="Vietnamese">vi.wiktionary.org</edition>
        <edition language="Turkish">tr.wiktionary.org</edition>
      </editions>
    </project>
  </projects>
</wikimedia>

```

이런 XML 파일이 있을때

```
/wikimedia/projects/project/@name
```

이란 XPath식은 모든 project란 요소의 name 속성을 선택한다.

```
/wikimedia/projects/project/editions/edition[@language="English"]/text()
```

이 XPath 식은 language속성이 English인 모든 edition 요소의 문자열(주소값)을 선택한다.

```
/wikimedia/projects/project[@name="Wikipedia"]/editions/edition/text()
```

이 XPath 식은 project 이름이 Wikipedia인 edtion 요소의 문자열들을 선택한다.
