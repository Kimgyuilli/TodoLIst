package main.todolist;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileHandler {
    private final File file;
    public FileHandler(String path) {
        file = new File(path);
    }

    public List<String> loadFile() {
        List<String> todoList = new ArrayList<>();
        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                todoList.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("TodoList.txt 파일을 찾을 수 없습니다.");
        }
        return todoList;
    }

    public void SaveFile(List<String> todoList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String task : todoList) {
                writer.write(task);
                writer.newLine();
            }
            System.out.println("저장 완료");
        } catch (IOException e) {
            System.out.println("파일 저장 중 오류가 발생했습니다.");
        }
    }

}
