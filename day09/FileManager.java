import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileManager {

    private static final String STORE_FOLDER_PATH = "C:\\Users\\pyh\\Desktop\\codesquad\\day09\\files\\";
    private static final String FILE_EXTENSION = ".txt";

    public void createFile(String fileName, List<String> columns) {
        try {
            String path = STORE_FOLDER_PATH + fileName + FILE_EXTENSION;

            BufferedWriter bw = new BufferedWriter(new FileWriter(path, true));
            bw.write(listToStringWithComma(columns));
            bw.newLine();
            bw.write("---------------------");
            bw.newLine();
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addData(String fileName, List<Object> row) {
        try {
            String path = STORE_FOLDER_PATH + fileName + FILE_EXTENSION;

            BufferedWriter bw = new BufferedWriter(new FileWriter(path, true));
            bw.write(listToStringWithComma(row));
            bw.newLine();
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteData(String fileName, List<Object> row) {
        try {
            String path = STORE_FOLDER_PATH + fileName + FILE_EXTENSION;
            String replacement = "===deleted data===";
            List<String> lines = Files.readAllLines(Paths.get(path));

            for (String line : lines) {
                if (line.equals(listToStringWithComma(row))) {
                    lines.set(lines.indexOf(line), replacement);
                    break;
                }
            }
            Files.write(Paths.get(path), lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 리스트를 콤마 기준으로 나열
    private <T> String listToStringWithComma(List<T> list) {
        StringBuilder sb = new StringBuilder();
        for (Object element : list) {
            sb.append(element)
                    .append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public void deleteFile(String fileName) {
        File file = new File(STORE_FOLDER_PATH + fileName + FILE_EXTENSION);
        if (file.exists()) {
            file.delete();
        }
    }
}
