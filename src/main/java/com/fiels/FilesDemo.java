package com.fiels;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesDemo {

    public static void main(String[] args) {

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

        try {
            Files.createFile(DIRECTORY.resolve("test").resolve("test.txt"));
        } catch (IOException e) {
            System.out.println(e);
            System.out.println("이미 파일이 존재합니다. "+e.getMessage());
        }
    }
}
