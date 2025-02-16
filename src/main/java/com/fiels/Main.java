package com.fiels;

import java.io.File;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {

        Path path = Paths.get(System.getProperty("user.dir"));
        System.out.println(path);

        File file = new File(path.toFile(), "test.txt");
        System.out.println(file.toString());

        System.out.println("file.getPath() = " + file.getPath());

        System.out.println("file.getAbsolutePath() = " + file.getAbsolutePath());
        System.out.println("file.exists() = " + file.exists());

        Path resolve = path.resolve("test");
        try {
            if (!Files.exists(resolve)) {
                Files.createDirectory(resolve);
                System.out.println("디렉터리 생성완료");
            }

            Files.deleteIfExists(resolve);
            System.out.println("디렉터리 삭제");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
