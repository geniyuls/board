import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lastArticleId = 0;
        ArrayList<Article> articles = new ArrayList<>();

        // 테스트 게시물 작성 시작
        articles.add(new Article(1, "제목1", "내용1"));
        articles.add(new Article(2, "제목2", "내용2"));
        articles.add(new Article(3, "제목3", "내용3"));
        // 테스트 게시물 작성 끝

        System.out.println("==텍스트 게시판 v 0.1==");
        System.out.println("==프로그램 시작==");

        while (true) {
            System.out.printf("명령) ");
            String cmd = sc.nextLine();

            if (cmd.equals("/user/article/write")) {
                System.out.println("게시물 작성");
                System.out.println("제목)");
                String title = sc.nextLine();
                System.out.println("내용)");
                String body = sc.nextLine();

                int id = ++lastArticleId;
                Article article = new Article(id, title, body);
                articles.add(article);  // 게시물 추가
                System.out.println("생성된 게시물 객체 : " + article);
                System.out.printf("%d번 게시물이 생성되었습니다.\n", article.id);
            } else if (cmd.equals("/user/article/list")) {
                System.out.println("== 게시물 리스트 ==");
                System.out.println("번호 | 제목");
                for (Article article : articles) {
                    System.out.printf(" %d   | %s\n", article.id, article.title);
                }
            } else if (cmd.equals("/user/article/detail")) {
                System.out.println("게시물 번호를 입력하세요:");
                int id = sc.nextInt();
                sc.nextLine(); // Consume newline

                Article article = findArticleById(articles, id);
                if (article != null) {
                    System.out.println("== 게시물 상세 보기==");
                    System.out.printf("번호 : %d\n", article.id);
                    System.out.printf("제목 : %s\n", article.title);
                    System.out.printf("내용 : %s\n", article.body);
                } else {
                    System.out.println("게시물이 존재하지 않습니다.");
                }
            } else if (cmd.equals("/user/article/delete")) {
                System.out.println("삭제할 게시물 번호를 입력하세요:");
                int id = sc.nextInt();
                sc.nextLine(); // Consume newline

                Article articleToRemove = findArticleById(articles, id);
                if (articleToRemove != null) {
                    articles.remove(articleToRemove);
                    System.out.printf("%d번 게시물이 삭제되었습니다.\n", id);
                } else {
                    System.out.println("게시물이 존재하지 않습니다.");
                }
            }

            if (cmd.equals("exit")) {
                System.out.println("게시판을 종료합니다.");
                break;
            }
            System.out.printf("입력받은 명령어 : %s\n", cmd);
        }
        sc.close();
    }

    private static Article findArticleById(ArrayList<Article> articles, int id) {
        for (Article article : articles) {
            if (article.id == id) {
                return article;
            }
        }
        return null;
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