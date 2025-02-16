package com.fiels;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileDemo {

    public static void main(String[] args) {
        Path path = Paths.get(System.getProperty("user.dir"));
        File DIRECTORY = new File(path.toUri());

        boolean result = DIRECTORY.mkdir();
        System.out.println("생성 결과 : " + result);

        boolean mkdirs = DIRECTORY.mkdirs();
        System.out.println("mkdirs 의 결과 = " + mkdirs);

        File createFile = new File(DIRECTORY, "test.txt");
        try {
            boolean newFile = createFile.createNewFile();
            System.out.println("파일의 생성 여부 = " + newFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
