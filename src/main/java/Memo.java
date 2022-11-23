import java.time.LocalDateTime;

public class Memo {
    //    메모 한 건에 대한 정보를 가진 클래스
    //    메모는 글 번호, 작성자 이름, 비밀번호, 게시글, 작성일(컴퓨터 시스템의 날짜와 시간을 자동으로 저장) 가지고 있다.
    //    글의 수정 시, 수정 시간으로 시간이 변경된다.
    int num;
    String name;
    String password;
    String content;

    LocalDateTime creteAt;
    public Memo(int num, String name, String password, String content) {
        this.num = num;
        this.name = name;
        this.password = password;
        this.content = content;
//        this.creteAt = LocalDateTime.now();
    }

    void update(String name) {
        this.num = num;
        this.name = name;
        this.password = password;
        this.content = content;
        this.creteAt= LocalDateTime.now();
    }

}
