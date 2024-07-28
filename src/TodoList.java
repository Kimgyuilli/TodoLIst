import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class TodoList {
    private static List<String> todoList = new ArrayList<>();
    private static final File note = new File("TodoList.txt");
    public static void main(String[] args) {
        boolean plag = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Todo List");

        // 파일에서 todo 리스트 불러오기
        LoadFile();

        while (plag) {
            System.out.println("1.일정 확인 2.일정 추가 3.일정 삭제 4.저장");
            String choice = scanner.nextLine();
            System.out.println("----------------------------------------------------");
            switch (choice) {
                case "1":
                    /*목록 확인*/
                    DisplayTodolist();
                    break;
                case "2":
                    /*일정 추가*/
                    PushWork(scanner);
                    break;
                case "3":
                    /*일정 삭제*/
                    DeleteWork(scanner);
                    break;
                case "4":
                    /*저장 기능*/
                    SaveFile();
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

    private static void LoadFile() {
        try (Scanner fileScanner = new Scanner(note)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                todoList.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("TodoList.txt 파일을 찾을 수 없습니다.");
        }
    }

    private static void DisplayTodolist() {
        int num = 1;
        for (String work : todoList) {
            System.out.println(num + ". " + work);
            num++;
        }
    }

    private static void  PushWork(Scanner scanner) {
        System.out.print("추가할 일정 입력: ");
        String push = scanner.nextLine();
        todoList.add(push);
    }

    private static void DeleteWork(Scanner scanner) {
        System.out.print("삭제할 일정 번호 입력(돌아가려면 \"0\"입력): ");
        String input = scanner.nextLine();
        int pop;
        try {
            pop = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("잘못된 입력입니다");
            return;
        }
        if (pop <= todoList.size() && pop > 0) {
            todoList.remove(pop - 1);
        } else if (pop != 0) {
            System.out.println("잘못된 입력입니다");
        }
    }

    private static void SaveFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(note))) {
            for (String task : todoList) {
                writer.write(task);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("파일 저장 중 오류가 발생했습니다.");
        }
        System.out.println("저장 완료");
    }
}