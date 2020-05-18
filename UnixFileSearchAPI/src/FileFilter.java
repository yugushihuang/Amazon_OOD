import java.util.ArrayList;
import java.util.List;

public class FileFilter {
    private final List<IFilter> filters = new ArrayList<>();

    public FileFilter(){
        filters.add(new NameFilter());
        filters.add(new MaxSizeFilter());
        filters.add(new MinSizeFilter());
        filters.add(new ExtensionFilter());
    }

    public boolean isValid(SearchParams params, File file){
        for(IFilter filter: filters){
            if(!filter.isValid(params,file)){
                return false;
            }
        }

        return true;
    }
}
