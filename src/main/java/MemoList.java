import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class MemoList implements Memo_input, Memo_read,  Memo_delete {

    //    여러 건의 메모를 저장하는 클래스 이다.
//    메모 전체를 조회할 수 있다. (Getter/Setter 존재)
//    작성 최신 순으로 메모를 출력한다.
//    1건의 글을 메모 리스트에 추가할 수 있다.
//    글의 수정 또는 삭제 시 글 번호를 넘겨 받고 리스트에서 글 번호에 해당하는  글 1건을 얻어와 리턴 시키는 메소드가 있다.
//    해당되는 글 1건을 수정하는 메소드가 있다.
//    글 1건을 삭제하는 메소드가 있다.
//    글 삭제 후 글 번호를 다시 붙여준다.
//    글이 삭제된 후 새 글이 입력될 때 idx가 기존 idx값에 이어서 1씩 증가할 수 있도록 count의 값을 수정한다.
    int memoSize = 0;
    ArrayList<Memo> memoDate = new ArrayList<>();

    @Override
    public void input() {

        Scanner sc = new Scanner(System.in);

        String name_input;
        String password_input;
        String content_input;

        int num = 0;


        System.out.print("\n✨ 이름을 입력하세요.\n→ ");
        name_input = sc.nextLine();
        System.out.print("\n✨ 비밀번호를 입력하세요.\n→ ");
        password_input = sc.nextLine();
        System.out.print("\n✨ 메모 내용을 입력하세요.\n→ ");
        content_input = sc.nextLine();
        memoDate.add(new Memo(memoDate.size() + 1, name_input, password_input, content_input));
        System.out.println("\n✨ 메모가 저장되었습니다.\n");
    }


        @Override
        public void read() {

            System.out.println("\n✨ 메모 번호와 내용을 출력합니다.\n");
            // 모두 출력
            for (int i = 0; i < memoDate.size(); i++) {
                System.out.println("---------- " + (i + 1) + "번 메모" + " ----------");
                System.out.println("✨ 번호 : " + memoDate.get(i).getNum());
                System.out.println("✨ 내용 : " + memoDate.get(i).getContent());
            }
            System.out.println("---------- 출력 완료 ----------\n");
        }

        @Override
        public void delete() {
            int searchId;
            String password;

            Scanner sc = new Scanner(System.in);
            System.out.print("\n✨ 메모 번호를 입력하세요.\n→ ");
            searchId = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < memoDate.size(); i++) {
                if (searchId == memoDate.get(i).num) {
                    int itemNum = memoDate.get(i).num;
                    System.out.println("\n✨ " + itemNum + "번 메모를 찾았습니다.\n");
                    System.out.println("✨ 내용 : " + memoDate.get(i).content);
                    System.out.print("\n✨ 삭제하려면 비밀번호를 입력하세요.\n→ ");
                    password = sc.nextLine();

                    if (memoDate.get(i).password.equals(password)) {
                        memoDate.remove(i);
                        System.out.println("\n✨ " + itemNum + "번 메모를 삭제했습니다.\n");
                        System.out.println("========== 현재 저장된 메모 리스트 ==========");
                        // 메모 삭제 후 num을 앞당겨주는 기능
                        for (int j = 0; j < memoDate.size(); j++) {
                            if (j < i) {
                                memoDate.set(j, new Memo(memoDate.get(j).num, memoDate.get(j).name, memoDate.get(j).password, memoDate.get(j).content));
                            } else {
                                memoDate.set(j, new Memo(memoDate.get(j).num - 1, memoDate.get(j).name, memoDate.get(j).password, memoDate.get(j).content));
                            }

                            System.out.println("✨ 번호 : " + memoDate.get(j).num + ", 이름 : " + memoDate.get(j).name + ", 내용 : " + memoDate.get(j).content + "\n");
                        }
                    } else {
                        System.out.println("\n✨ 비밀번호를 잘못 입력하셨습니다.\n");
                    }
                }
            }

        }

    public void getCreteAt() {
        LocalDateTime now = LocalDateTime.now();

        // 현재 날짜/시간 출력
        System.out.println(now);

        // 포맷팅
        String creteAt = now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초"));

        // 포맷팅 현재 날짜/시간 출력
        System.out.println(creteAt);

    }
    public void update() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("\n✨ 수정하실 메모 번호를 입력하세요.\n→ ");
        int selectNumber = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < memoDate.size(); i++) {
            if (selectNumber == memoDate.get(i).num) {
                System.out.print("\n✨ 비밀번호를 입력하세요.\n→ ");
                String selectPassword = scanner.nextLine();
                if (memoDate.get(i).password.equals(selectPassword)) {
                    System.out.print("\n✨ 내용을 작성하세요.\n→ ");
                    String content = scanner.nextLine();
                    memoDate.set(i, new Memo(memoDate.get(i).num, memoDate.get(i).name, memoDate.get(i).password, content));

                    System.out.println("\n✨ 메모가 수정되었습니다.");
                    getCreteAt();
                    return;
                } else {
                    System.out.println("비밀번호가 정확하지 않습니다. \n다시 시도해 주세요\n");
                }
            }
        }
    }
}

