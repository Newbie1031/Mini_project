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


        System.out.print("이름을 입력하세요.\n→");
        name_input = sc.nextLine();
        System.out.print("비밀번호를 입력하세요.\n→");
        password_input = sc.nextLine();
        System.out.print("메모를 입력하세요.\n→");
        content_input = sc.nextLine();
        memoDate.add(new Memo(memoDate.size() + 1, name_input, password_input, content_input));
    }


        @Override
        public void read() {

            System.out.println("번호와 내용이 출력됩니다.");
            // 모두 출력
            for (int i = 0; i < memoDate.size(); i++) {
                System.out.println("-----" + (i + 1) + "번 메모" + "-----");
                System.out.println("번호: " + memoDate.get(i).getNum());
                System.out.println("내용: " + memoDate.get(i).getContent());
                System.out.println();
            }

        }

        @Override
        public void delete() {
            int searchId;
            String password;

            ArrayList<Memo> memoData = new ArrayList<Memo>();
            Memo memo1 = new Memo(1, "이재원", "1234", "내용");
            Memo memo2 = new Memo(2, "이재원2", "1234", "내용2");
            Memo memo3 = new Memo(3, "이재원3", "1234", "내용3");
            memoData.add(memo1);
            memoData.add(memo2);
            memoData.add(memo3);

            Scanner sc = new Scanner(System.in);
            System.out.print("글 번호 입력 : ");
            searchId = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < memoData.size(); i++) {
                if (searchId == memoData.get(i).num) {
                    int itemNum = memoData.get(i).num;
                    System.out.println("✨" + itemNum + "번 글을 찾았습니다.");
                    System.out.println("내용 : " + memoData.get(i).content);
                    System.out.print("삭제하려면 비밀번호 입력 : ");
                    password = sc.nextLine();

                    if (memoData.get(i).password.equals(password)) {
                        memoData.remove(i);
                        System.out.println("✨" + itemNum + "번 글을 삭제했습니다");
                        System.out.println("✨남은 메모리스트 ======================");
                        // 메모 삭제 후 num을 앞당겨주는 기능
                        for (int j = 0; j < memoData.size(); j++) {
                            if (j < i) {
                                memoData.set(j, new Memo(memoData.get(j).num, memoData.get(j).name, memoData.get(j).password, memoData.get(j).content));
                            } else {
                                memoData.set(j, new Memo(memoData.get(j).num - 1, memoData.get(j).name, memoData.get(j).password, memoData.get(j).content));
                            }

                            System.out.println("num : " + memoData.get(j).num + ", name : " + memoData.get(j).name + ", content : " + memoData.get(j).content);
                        }
                        System.out.println("====================================");
                        System.out.println("입력 끝");
                    } else {
                        System.out.println("비밀번호가 틀렸습니다.");
                    }
                }
            }

        }

    public void update() {
        ArrayList<Memo> memoData = new ArrayList<Memo>();
        Memo memo1 = new Memo(1, "이재원", "1234", "내용");
        Memo memo2 = new Memo(2, "이재원2", "1234", "내용2");
        Memo memo3 = new Memo(3, "이재원3", "1234", "내용3");
        memoData.add(memo1);
        memoData.add(memo2);
        memoData.add(memo3);

        System.out.println("");
        Scanner scanner = new Scanner(System.in);

        System.out.println("수정하실 글 번호를 입력해주세요");
        int selectNumber = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < memoData.size(); i++) {
            if (selectNumber != memoData.get(i).num) {
                System.out.println("존재하지 않는 메모입니다");
            } else {
                System.out.println("비밀번호를 입력해 주세요");
                String selectPassword = scanner.nextLine();

                for (int j = 0; j < memoData.size(); j++) {
                    if (selectPassword != memoData.get(j).password) {
                        System.out.println("비밀번호가 일치하지 않습니다.");
                    } else {
                        System.out.println("본문을 작성해주세요");
                        String content = scanner.nextLine();

                        System.out.println("메모가 수정되었습니다");
                        System.out.println("");
                    }
                }
            }
        }
    }
    }

