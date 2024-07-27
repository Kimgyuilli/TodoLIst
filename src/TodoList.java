import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class TodoList {
    public static void main(String[] args) {
        System.out.println("Todo List");
        boolean plag = true;
        while(plag) {
            System.out.println("1.일정 확인 2.일정 추가 3.일정 삭제 4.저장");
            Scanner scanner = new Scanner(System.in);
            List<String> todoList = new ArrayList<String>();
            todoList.add("a");
            todoList.add("c");
            todoList.add("b");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    /*목록 확인 구현*/
                    for (String work : todoList) {
                        System.out.println("1. " + work);
                    }
                case 2:

                    /*일정 추가 구현*/
                    break;
                case 3:

                    /*일정 삭제 구현*/

                    break;

                case 4:
                    plag = false;
                    System.out.println("저장 완료");
                    /*저장 기능 구현*/
                default:

                    System.out.println("올바르지 않은 입력입니다.");
                    break;
        }


        }
    }
}