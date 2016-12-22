import java.io.File;

/**
 * Created by vig on 12/19/16.
 */

//рекурсивное удаление файлов в папках
public class Files {
    public static void main(String[] args) {
        String extension = ".txt";
        String rootDir = "/home/vig/IdeaProjects/Source_IT-L20/Lesson 20/Deletion";
        File dir = new File(rootDir);
        File[] files = dir.listFiles();
        deleteRec(extension, files);
    }

    private static void deleteRec(String extension, File[] files) {
        for (File f: files) {
            if(f.isDirectory()){
                deleteRec(extension, f.listFiles());
            }else if(f.getName().endsWith(extension)){
                f.delete();
            }
        }
    }
}
