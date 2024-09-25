import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int articleLastId = 0;

        System.out.println("== 텍스트 게시판 v 0.1==");
        System.out.println("프로그램 시작");

        while (true) {
            System.out.printf("명령)");
            String cmd = sc.nextLine();

            if (cmd.equals("on")) {
                System.out.println("== 게시물 작성 ==");
                System.out.printf("제목");
                String title = sc.nextLine();
                System.out.printf("내용");
                String body = sc.nextLine();

                int id = ++articleLastId;

                Article2 article = new Article2();
                article.id = id;
                article.title = title;
                article.body = body;
                System.out.printf("%d번 게시물이 생성되었습니다.\n", id);

            }

            else if (cmd.equals("exit")) {
                System.out.println("==게시판을 종료합니다.==");
                break;
            }
        }
        sc.close();
    }
}

class Article2{
    int id;
    String title;
    String body;
}