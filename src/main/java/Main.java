import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String select_Num;

        MemoList memoList = new MemoList();

        while (true) {
            System.out.println("--- 해당하는 메뉴의 숫자를 입력하세요. ---");
            System.out.println("1 : 메모 입력");
            System.out.println("2 : 메모 목록");
            System.out.println("3 : 메모 수정");
            System.out.println("4 : 메모 삭제");
            System.out.print("5 : 메모장 종료\n→ ");

            select_Num = sc.nextLine();

            if (select_Num.equals("1")) {
                memoList.input();
            } else if (select_Num.equals("2")) {
                memoList.read();
            } else if (select_Num.equals("3")) {
                memoList.update();
            } else if (select_Num.equals("4")) {
                memoList.delete();
            } else if (select_Num.equals("5")) {
                System.out.println("\n✨ 메모장을 종료합니다.");
                System.exit(0);
            } else {
                System.out.println("✨ 해당 숫자의 메뉴가 존재하지 않습니다.");
            }
        }
    }
}