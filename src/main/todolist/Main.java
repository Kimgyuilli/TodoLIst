package main.todolist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean plag = true;
        String FilePath = "Todolist.txt";

        // 파일에서 todo 리스트 불러오기
        FileHandler fileHandler = new FileHandler(FilePath);
        List<String> todoList = fileHandler.loadFile();
        InputHandler inputHandler = new InputHandler();
        TodoManager todoManager = new TodoManager(todoList, inputHandler);

        System.out.println("Todo List");
        while (plag) {
            String choice = inputHandler.GetChoice(scanner);
            System.out.println("----------------------------------------------------");
            switch (choice) {
                case "1":
                    /*목록 확인*/
                    todoManager.DisplayTodolist();
                    break;

                case "2":
                    /*일정 추가*/
                    todoManager.PushWork(scanner);
                    break;
                case "3":
                    /*일정 삭제*/
                    todoManager.DeleteWork(scanner);
                    break;
                case "4":
                    /*저장 기능*/
                    fileHandler.SaveFile(todoList);
                    break;

                case "5":
                    /*종료*/
                    plag = false;
                    break;

                default:
                    System.out.println("올바르지 않은 입력입니다.");
                    break;
                }
            System.out.println("----------------------------------------------------");
        }
        scanner.close();
    }
}
