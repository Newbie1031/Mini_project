import java.util.Scanner;

public interface Memo_update {
//    수정할 글 번호를 입력 받는다.
//    수정할 글이 존재하면 글을 수정하고 존재하지 않으면 존재하지 않는다고 메시지를 출력한다.
//    수정할 글의 비밀번호를 입력 받는다.
//    글을 수정하기 위해 입력한 비밀번호와 수정할 글의 비밀번호가 일치하면 글을 수정하고 일치하지 않으면 비밀번호가 일치하지 않는다는 메시지를 출력한다.
//    비밀번호가 일치할 시 : 수정 내용 업데이트
//    비밀번호 불일치 시 : 비밀번호가 일치하지 않는다는 메시지 출력

    public default void updateNote() {
        System.out.println("");
        Scanner scanner = new Scanner(System.in);
        Memo[] memoData = new Memo[30];

        System.out.println("비밀번호를 입력해 주세요");
        int selectPassword = Integer.parseInt(scanner.nextLine());

        if (selectPassword!=memoData[]){
            System.out.println("비밀번호가 일치하지 않습니다.");
        }else{
            System.out.println("수정하실 메모의 번호를 입력해주세요");
            int selectedNumber = Integer.parseInt(scanner.nextLine());

            System.out.println("본문을 작성해주세요");
            String content = scanner.nextLine();

            Memo noteEntity = memoData[selectedNumber];

            if (null == noteEntity) {
                System.out.println("존재하지 않는 메모입니다");
                return;
            }
            noteEntity.update(content);

            System.out.println("메모가 수정되었습니다");
            System.out.println("");
        }
    }
}

