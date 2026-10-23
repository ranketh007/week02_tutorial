package lk.ac.iit.tut1;

public class DigitalProduct extends Product{
    private String downloadURL;
    private double fileSize;

    public DigitalProduct(){}

    public DigitalProduct(Long id, String name, double Price, String downloadURL, double fileSize){
        super(id, name, Price);
        this.downloadURL = downloadURL;
        this.fileSize = fileSize;
    }

    public String getDownloadURL() {
        return downloadURL;
    }

    public double getFileSize() {
        return fileSize;
    }

}
