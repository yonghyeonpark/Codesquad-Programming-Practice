public class Controller {

    /**
     * CreaTe TaBLe billboard (singer String, year Numeric, song String)
     * INSERT INTO billboard (singer, year, song) VALUES ("BTS", 2020, "Dynamite")
     * INSERT INTO billboard (singer, year, song) VALUES ("BFS", 2015, "최단경로")
     * INSERT INTO billboard (singer, year, song) VALUES ("DFS", 2013, "미로탈출")
     * DELETE FROM billboard WHERE id = 1
     * DELETE FROM billboard WHERE song = "Dynamite"
     *
     * CREATE TABLE movie (name String, year Numeric, genre String)
     * insert into movie (name, year, genre) VALUES ("엘리멘탈", 2023, "애니메이션")
     * INSERT INTO movie (name, year, genre) VALUES ("소울", 2021, "애니메이션")
     * INSERT INTO movie (name, year, genre) VALUES ("범죄도시", 2017, "액션")
     * DELETE FROM movie WHERE genre = "애니메이션"
     * DELETE FROM movie WHERE genre = "코미디"
     *
     * !잘못된 입력 예시
     * INSERT INTO movie (name, year, genre) VALUES ("엘리멘탈", 2023)
     * INSERT INTO movie (name, year) VALUES ("엘리멘탈", 2023)
     * INSERT INTO movie (name, year, genreeeeee) VALUES ("엘리멘탈", 2023, "애니메이션")
     */

    private final InputView inputView;
    private final SqlProcessor sqlProcessor;

    public Controller(InputView inputView) {
        this.inputView = inputView;
        this.sqlProcessor = new SqlProcessor(new Database(), new FileManager());
    }

    public void run() {
        while (true) {
            try {
                while (true) {
                    String sql = inputView.readSql();
                    if (sql.equals("exit")) {
                        sqlProcessor.deleteFiles();
                        break;
                    }
                    sqlProcessor.process(sql);
                    System.out.println();
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + "\n");
            }
        }
    }
}
