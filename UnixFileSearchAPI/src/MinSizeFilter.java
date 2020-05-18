public class MinSizeFilter implements IFilter {
    public boolean isValid(SearchParams params, File file){
        if(params.minSize==null) return true;
        return file.getSize()>=params.minSize;
    }
}
