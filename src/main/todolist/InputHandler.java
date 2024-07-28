package main.todolist;

import java.util.Scanner;

public class InputHandler {

    public String GetChoice(Scanner scanner) {
        System.out.println("1. 일정 확인 2. 일정 추가 3. 일정 삭제 4. 저장 5. 종료");
        return scanner.nextLine();
    }
    public String getInput(String massage, Scanner scanner) {
        System.out.println(massage);
        return scanner.nextLine();
    }
}
