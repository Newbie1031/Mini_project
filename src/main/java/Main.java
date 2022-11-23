import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String select_Num;

        MemoList memoList = new MemoList();

        while (true) {
            System.out.println("--------------숫자를 입력해주세요.--------------");
            System.out.println("1. 입력");
            System.out.println("2. 목록 보기");
            System.out.println("3. 수정");
            System.out.println("4. 삭제");
            System.out.println("5. 종료");

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
                System.exit(0);
            } else {
                System.out.println("숫자를 다시 확인해주세요.");
            }
        }
    }
}