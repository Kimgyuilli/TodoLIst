package main.todolist;
import java.util.List;
import java.util.Scanner;


public class TodoManager {
    private final List<String> todoList;
    private final InputHandler inputHandler;

    public TodoManager(List<String> todoList, InputHandler inputHandler) {
        this.todoList = todoList;
        this.inputHandler = inputHandler;
    }

    public void DisplayTodolist() {
        if (todoList.isEmpty()) {
            System.out.println("There are no todolist");
            return;
        }
        int num = 1;
        for (String todo : todoList) {
            System.out.println(num + ". " + todo);
            num++;
        }
    }

    public void PushWork(Scanner scanner) {
        String item = inputHandler.getInput("추가할 일정 입력: ", scanner);
        todoList.add(item);
    }
    
    public void DeleteWork(Scanner scanner) {
        int index = Integer.parseInt(inputHandler.getInput("삭제할 일정 번호 입력(돌아가려면 \"0\" 입력): ", scanner));
        if(index == 0) {
            return;
        } else if (index <= todoList.size() && index > 0) {
            todoList.remove(index - 1);
        } else {
            System.out.println("잘못된 입력입니다");
        }
    }
    
}

