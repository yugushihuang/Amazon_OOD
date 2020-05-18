public class File extends Entry {
    private byte[] content;

    public String getExtension(){
        return name.substring(name.indexOf(".")+1);
    }

    public void setContent(byte[] content){
        this.content = content;
    }

    public byte[] getContent(){
        return content;
    }

    public int getSize(){
        return content.length;
    }

    public boolean isDirectory(){
        return false;
    }

    public String toString(){
        return "File{" +
                "name='" + name + '\''+
                '}';
    }
}
