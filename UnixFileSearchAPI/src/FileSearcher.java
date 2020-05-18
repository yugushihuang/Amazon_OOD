import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FileSearcher {
    private FileFilter filter = new FileFilter();

    public List<File> search(Directory dir, SearchParams params){
        List<File> files = new ArrayList<>();

        Queue<Directory> dirs = new LinkedList<>();

        ((LinkedList<Directory>) dirs).add(dir);

        while(!dirs.isEmpty()){
            Directory currDir = dirs.poll();
            for(IEntry entry:currDir.entries){
                if(entry.isDirectory()){
                    ((LinkedList<Directory>) dirs).add((Directory) entry);
                }else{
                    File file = (File) entry;
                    if(filter.isValid(params, file)) files.add(file);
                }
            }
        }

        return files;


    }
}
