public class MaxSizeFilter implements IFilter {
    public boolean isValid(SearchParams params, File file){
        if(params.maxSize==null) return true;
        return file.getSize()<=params.maxSize;
    }
}
