import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String select_Num;

        MemoList memoList = new MemoList();

        while (true) {
            System.out.println("숫자를 입력해주세요.");
            System.out.println("1. 입력");
            System.out.println("2. 목록 보기");
            System.out.println("3. 수정");
            System.out.println("4. 삭제");
            System.out.println("5. 종료");

            select_Num = sc.nextLine();

            if (select_Num.equals("1")) {
                System.out.println("메모를 입력합니다.");
                break;
            } else if (select_Num.equals("2")) {
                System.out.println("메모 목록을 확인합니다.");
                break;
            } else if (select_Num.equals("3")) {
                System.out.println("메모를 수정합니다.");
                break;
            } else if (select_Num.equals("4")) {
                System.out.println("메모를 삭제합니다.");
                memoList.delete();
                break;
            } else if (select_Num.equals("5")) {
                System.exit(0);
            } else {
                System.out.println("숫자를 다시 확인해주세요.");
            }
        }
    }
}