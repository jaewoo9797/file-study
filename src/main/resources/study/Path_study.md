파일을 읽고 쓰는데 디렉터리 위치를 내 프로젝트 내부에서 작업을 진행하기 위해서 경로를 설정하는 방법에 대해서 알아보자.

# Path

`Path`는 `Comparable`, `Iterable`, `Watchable`을 상속받은 인터페이스이다. 파일 시스템에서
파일을 찾는 데 사용할 수 있는 객체로 시스템에 따라 달라지는 파일 경로를 나타냅니다.

`Path`는 `java.nio.file`에 존재하며, `Path` API는 Java7과 함께 제공된 주요한 새로운 기능입니다.
`Path`객체는 파일 시스템의 경로를 대표합니다. 경로는 파일이나 디렉토리를 가리킬 수 있습니다.

## 1. Path Operation

`Path` 객체는 경로를 구성하는 데 사용되는 파일 이름과 디렉터리 목록을 포함하여 파일을 검사, 위치 확인 및
조작하는 데 사용합니다.

도우미 클래스인 `Paths`는 경로 객체를 생성하는 공식적인 방법입니다. 경로 문자열에서 경로를 생성하는 두 가지 정적 방법이 있습니다.

참고

```java
public final class Paths {
    private Paths() {
    }

    public static Path get(String first, String... more) {...}

    public static Path get(URI uri) {...}
}
```

`Paths` 에는 `Path`를 반환하는 두 가지 정적메서드만 존재한다.

## 2. Creating a Path

문자열로부터 Path 객체를 얻는 방법

```java
Paths.get("/articles/baeldung");
```

articles 에 baeldung 패키지를 문자열로 `Path`를 얻어냈습니다.

```java
Paths.get("/articles","baeldung");
```

가변인수로 생성할 경우 변수 인수 부분에 구분자(/)를 포함할 필요가 없이 `Path`를 얻어내었습니다.

## Retrieving Path Information

"C:\\baeldung\\article\\java" 와 같은 경로 문자열은 세가지 이름 요소, `baeldung`, `article`, `java` 로 구성됩니다.
디렉터리 구조에서 가장 높은 요소는 인덱스 0에 위치하는 `baeldung`입니다.

```java
// given
Path path = Paths.get("/articles/baeldung/logs");
// when
Path fileName = path.getFileName();

// then
assertEquals("logs",fileName.toString());
```

각 요소를 개별적으로 인덱스를 이용해 탐색할 수 있습니다.

```java
Path path = Paths.get("/articles/baeldung/logs");
// when
Path name0 = path.getName(0);
Path name1 = path.getName(1);
Path name2 = path.getName(2);

// then
assertEquals("articles",name0.toString());

assertEquals("baeldung",name1.toString());

assertEquals("logs",name2.toString());
```

이에 추가적으로 인덱스 범위를 이용하여 가져오는 방법과 부모 경로를 가져오는 방법 또한 존재합니다.
하지만 스프린트 미션의 범위에서 벗어난다고 생각하여 추가적인 정리는 하지 않겠습니다. 추가로 더 알고 싶은 분들은 아래 참조의 사이트를 이용해서
학습하시면 좋을것같습니다.

참조

- [docs.oracle-Path](https://docs.oracle.com/javase/8/docs/api/java/nio/file/Path.html)
- [Baeldung-path](https://www.baeldung.com/java-nio-2-path)
