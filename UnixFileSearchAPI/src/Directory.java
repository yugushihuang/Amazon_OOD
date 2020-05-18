import java.util.ArrayList;
import java.util.List;

public class Directory extends Entry{
    public List<Entry> entries = new ArrayList<>();

    public int getSize(){
        int size=0;
        for(Entry entry:entries){
            size+=entry.getSize();
        }
        return size;
    }

    public boolean isDirectory(){
        return true;
    }

    public void addEntry(Entry entry){
        this.entries.add(entry);
    }
}
