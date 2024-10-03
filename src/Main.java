import java.net.SocketOption;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Main {
    static void makeTestData(List<Article> articles){
        articles.add(new Article(1, "제목1", "내용1"));
        articles.add(new Article(2, "제목2", "내용2"));
        articles.add(new Article(3, "제목3", "내용3"));

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int articleLastId = 0;
//        Article lastArticle = null; 코드변경
        ArrayList<Article> articles = new ArrayList<Article>();

        makeTestData(articles);

        if(articles.size() > 0) {
            articleLastId = articles.get(articles.size() - 1).id;
        }

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

                Article article = new Article(id, title, body);
//                lastArticle = article; 코드변경

                articles.add(article); // 게시물 추가

                System.out.println("생성된 게시물 객체 : " + article);

                System.out.printf("%d번 게시물이 생성되었습니다.\n", article.id);
            } else if(cmd.equals("lists")) {
                System.out.println("== 게시물 리스트 ==");
                System.out.println("번호 | 제목");

                for(int i = articles.size() - 1; i >= 0; i--) {
                    Article article = articles.get(i);
                    System.out.printf(" %d  | %s\n", article.id, article.title);
                }
            }
            else if (cmd.equals("content")) {
                if (articles.isEmpty()) {
                    System.out.println("게시물이 존재하지 않습니다.");
                    continue;
                }
                Article article = articles.get(articles.size() - 1); //마지막 게시물 보이기

                System.out.println("== 게시물 상세보기 ==");
                System.out.printf("번호 : %d\n", article.id);
                System.out.printf("제목 : %s\n", article.title);
                System.out.printf("내용 : %s\n", article.body);

            } else if (cmd.equals("exit")) {
                System.out.println("==게시판을 종료합니다.==");
                break;
            }
        }
        sc.close();
    }
}

class Article {
    int id;
    String title;
    String body;

    Article(int id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    @Override
    public String toString() {
        return String.format("{id : %d, title : \"%s\", body : \"%s\"}", id, title, body);
    }

}

