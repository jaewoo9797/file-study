# File
스프린트 미션의 주요 학습할 부분 중 한 가지는 File을 생성 저장, 삭제 하는 것의 숙달이라고 생각한다.
각각의 객체를 파일로 만들어 객체의 정보를 저장하고, 읽어와서 데이터를 객체로 역직렬화하여 데이터를 핸들링한다.

아직 File에 대해서 제대로 학습을 진행해보지 않았고, 사용경험이 적어 이번 기회에 스프린트 미션에 필요한 만큼 정리해두자 한다.

코드잇에서 제공해준 베이스 코드를 살펴보면 다음과 같다.

1. `Paths`를 이용하여 Path 객체를 생성한다.
    - 매개변수로 사용자의 루트 디렉터리와 application.yaml 파일에서 설정한 경로와 각각의 객체 파일의 클래스파일의 이름을 매개변수로 넣는다.
    - 루트 디렉터리는 다음과 같은 방법으로 얻어온다. `System.getProperty("user.dir)`;
    - 여기서 말하는 루트 디렉터리는 현재 우리 프로젝트의 경로의 제일 부모인 디렉터리이다.
2. `Files` 객체의 정적 메소드 `notExists` 를 이용하여 해당 Path에 존재하는 지 검사한다.
3. 존재하지 않는다면 `Files`객체의 `creteDirectories` 메소드를 이용하여 생성한다.

위의 로직은 해당 객체의 `FileRepository`를 생성하는 생성자에서 진행되는 로직이다.

첫 번째로 `Files` 와 `File` 의 차이를 살펴보자.

## File, Files

### File
```java
public class File extends Serializable, Comparable
```
`File` 객체는 파일 및 디렉터리 경로 이름의 추상적 표현입니다. 이런 파일 객체를 생성하는 방법에는 4가지 생성자가 존재합니다.
- File(File parent, String child)
- File(String pathname)
- File(String parent, String child)
- FIle(URI uri)


<br/>

`File` 클래스에는 파일 시스템에서 파일을 작업하고 조작할 수 있는 여러 가지 메서드가 있습니다. 
`File` 클래스는 자신이 나타내는 파일의 **내용을 수정하거나 엑세스할 수 없다**는 점을 유의하는 것이 중요합니다.

`File` 클래스에는 디렉터리와 파일을 생성하고 삭제하는 인스턴스 메서드가 있습니다. 디렉터리와 파일은 각각
_mkdir_ 및 _createNewFile_ 메서드를 사용하여 생성됩니다.

디렉토리와 파일은 `delete` 메서드를 사용하여 삭제 됩니다.


다음으로 코드로 디렉토리와 파일을 생성하고 삭제해보도록 하겠습니다.
```java

    @Test
    void givenDir_whenMkdir_thenDirIsDeleted() {
        // given
        File directory = new File("dir");
        // then
        assertTrue(directory.mkdir());
        assertTrue(directory.delete());
    }

    @Test
    void givenFile_whenCreateNewFile_thenFileIsDeleted() {
        // given
        File file = new File("file.txt");
        // then
        try {
            assertTrue(file.createNewFile());
        } catch (IOException exception) {
            fail("Could not create " + "file.txt");
        }
        assertTrue(file.delete());
    }
```

<br/>

또한 `File`의 메서드 `isDirectory` 메서드로 제공된 이름으로 표시된 파일이 디렉터리인지 테스트 할 수 있고,
`isFile` 메서드는 제공된 이름으로 표시된 파일이 파일인지 테스트하는 데 사용할 수 있습니다. 그리고 `exists` 메서드를 사영하여
디렉터리나 파일이 이미 존재하는지 테스트 할 수 있습니다.

### Files
package java.nio.file.files 는 java **가상 머신(jvm)이 파일, 파일 속성 및 파일 시스템에 엑세스하기 위한 인터페이스와 클래스를
정의합니다**. 
```java
public final calss Files
```
`Files` 클래스는 파일, 디렉토리 또는 기타 유형의 파일에서 작동하는 **정적 메서드로만 구성**됩니다. 


출처
- [oracle.docs](https://docs.oracle.com/javase/7/docs/api/java/io/File.html)
- [File vs Files](https://velog.io/@ejjang2030/Stackoverflow-%EB%A6%AC%EB%B7%B0-java.io.File-%ED%81%B4%EB%9E%98%EC%8A%A4%EC%99%80-java.nio.Files-%ED%81%B4%EB%9E%98%EC%8A%A4)
- [File 과 Files 성능 비교](https://taes-k.github.io/2021/01/06/java-nio/)
