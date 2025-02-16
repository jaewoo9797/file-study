# File 객체로 파일과 디렉터리를 만드는 방법

## 디렉터리를 만들기
File 클래스 안의 `mkdir` 메서드를 이용하여 디렉터리를 만들 수 있습니다.
```java
Path path = Paths.get(System.getProperty("user.dir"));
File DIRECTORY = new File(path.toUri());

boolean result = DIRECTORY.mkdir();
System.out.println("생성 결과 : " + result);
```
<br/>

디렉터리를 생성하기위해서 사용했던 `mkdir` 메서드는 다음과 같은 특징이 있습니다.
- File 클래스의 midkr()을 사용하면, 디렉터리를 생성할 수 있습니다.
  - 디렉터리가 존재하면, 디렉터리를 생성하지 않고, false를 리턴합니다. (예외가 발생하지 않습니다)
  - 중첩된 디렉터리를 생성할 때, 부모 디렉터리가 존재하지 않으면, false를 리턴합니다. (예외가 발생하지 않습니다.)

<br/>

`File` 클래스의 `midirs` 메서드를 사용하여 디렉터리를 생성할 수 있습니다.
```java
boolean mkdirs = DIRECTORY.mkdirs();
System.out.println("mkdirs 의 결과 = " + mkdirs);
```

<br/>

디렉터리를 생성하는 `midirs` 메서드는 다음과 같은 특징이 있습니다.
- `mkdirs` 메서드를 사용하여 디렉터리를 생성하면 중첩된 디렉터리를 생성할 때, 부모 디렉터리가 없으면 자동으로 부모 디렉터리를 생성해줍니다.
  - 디렉터리가 존재하면 디렉터리를 생성하지 않고, false를 리턴합니다. (예외가 발생하지 않습니다.)
  - 중첩된 디렉터리를 생성할 때, 부모 디렉터리가 존재하지 않으면, 부모 디렉터리를 생성하고, true를 리턴합니다 (예외가 발생하지 않습니다.)

## 파일 만들기
`File` 클래스의 `createNewFile` 메서드를 이용하여 파일을 만들 수 있습니다.
```java
public boolean createNewFile() throws IOException 
```
해당 메서드의 시그니처 입니다. 해당 메서드는 IOException 을 처리해주어야 합니다.

```java
File createFile = new File(DIRECTORY, "test.txt");
try {
    boolean newFile = createFile.createNewFile();
    System.out.println("파일의 생성 여부 = " + newFile);
} catch (IOException e) {
  System.out.println(e.getMessage());
}
```

<br/>
파일이 이미 존재할 경우 해당 메서드는 false를 반환합니다. (예외를 발생시키지 않습니다.)



## _System.getProperty_
> 자바를 실행할 때, 실행되는 곳의 저옵를 얻어오거나 운영체제의 정보가 필요할 때가 있습니다.
> 
> 실행 위치에 있는 파일을 읽어 오거나 현재 위치를 알 수 있는 방법 등 시스템 정보를 가져올 때 
> System.getProperty() 를 사용합니다.

|검색어|뜻|
|-----|--|
|java.home|Java를 설치한 디렉터리|
|java.class.path|Java 클래스 경로|
|user.name|사용자 계정|
|user.home|사용자 홈 디렉터리|
|user.dir|현재 디렉토리|


# Files 객체로 디렉터리를 만드는 방법
`Files` 클래스의 `createDirectory` 메서드를 이용해서, 디렉터리를 생성할 수 있습니다.
```java
public static Path createDirectory(Path dir, FileAttribute<?>... attrse) throws IOException
```
메서드의 시그니처입니다. 해당 메서드의 특징은 다음과 같습니다.
- 디렉터리가 존재하면, FileAlreadyExistsException이 발생합니다.
- 중첩된 디렉터리를 생성할 때, 부모 디렉터리가 존재하지 않으면, NoSuchFileException 이 발생합니다.
```java
        Path DIRECTORY = Paths.get(System.getProperty("user.dir"));
        try {
            Files.createDirectory(DIRECTORY);
            System.out.println(DIRECTORY + "디렉터리가 생성되었습니다.");
        } catch (FileAlreadyExistsException exception) {
            System.out.println("디렉터리가 이미 존재합니다");
        } catch (NoSuchFileException exception) {
            System.out.println("디렉터리 경로가 존재하지 않습니다.");
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
```

`Files`의 `createDirectories` 메서드의 특징
- 디렉터리가 존재하더라도, 예외가 발생하지 않습니다.
- 중첩된 디렉터리를 생성할 때, 부모 디렉터리가 존재하지 않으면 자동으로 부모 디렉터리를 만들어 줍니다. (예외는 발생하지 않습니다.)

## Files 객체로 파일 만들기
`Files`의 `createFile` 메서드를 이용하여 파일을 생성할 수 있습니다.
```java
        try {
        Files.createFile(DIRECTORY.resolve("test.txt"));
        } catch (IOException e) {
            System.out.println(e);
        }
```
만약 파일이 이미 존재하고 있다면 예외가 발생합니다.
`java.nio.file.FileAlreadyExistsException: C:\sutdy\files_demo\test.txt`

생성하려는 파일의 디렉터리가 존재하지 않으면 예외가 발생합니다.
`java.nio.file.NoSuchFileException: C:\sutdy\files_demo\test\test.txt`
