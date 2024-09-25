import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lastArticleId = 0;

        System.out.println("==텍스트 게시판 v 0.1==");
        System.out.println("==프로그램 시작==");

        while (true) {

            System.out.printf("명령)");
            String cmd = sc.nextLine();

            if (cmd.equals("/user/article/write")) {
                System.out.println("게시물 작성");

                System.out.println("제목)");
                String title = sc.nextLine();

                System.out.println("내용)");
                String body = sc.nextLine();

                int id = ++lastArticleId;
                System.out.printf("%d번 게시물이 생성되었습니다.\n", id);
            }

            if (cmd.equals("exit")) {
                System.out.println("게시판을 종료합니다.");
                break;
            }
            System.out.printf("입력받은 명령어 : %s\n", cmd);
        }
        sc.close();
    }
}