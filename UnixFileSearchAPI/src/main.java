// Design Unix File Search API to search file with different arguments as "extension", "name", "size" ...
// The design should be maintainable to add new contraints.
public class main {
    public static void main(String[] args) {
        new main().test();
    }

    private void test() {
        SearchParams params = new SearchParams();
        params.extension = "xml";
        params.minSize = 2;
        params.maxSize = 100;

        File xmlFile = new File();
        xmlFile.setContent("aaa.xml".getBytes());
        xmlFile.name = "aaa.xml";

        File txtFile = new File();
        txtFile.setContent("bbb.txt".getBytes());
        txtFile.name = "bbb.txt";

        File jsonFile = new File();
        jsonFile.setContent("ccc.json".getBytes());
        jsonFile.name = "ccc.json";

        Directory dir1 = new Directory();
        dir1.addEntry(txtFile);
        dir1.addEntry(xmlFile);

        Directory dir0 = new Directory();
        dir0.addEntry(jsonFile);
        dir0.addEntry(dir1);

        FileSearcher searcher = new FileSearcher();
        System.out.println(searcher.search(dir0, params));
    }
}