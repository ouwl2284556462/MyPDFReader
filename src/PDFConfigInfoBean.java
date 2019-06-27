/**
 * @author owl
 * @Date 2019/6/26
 * @Description
 */

public class PDFConfigInfoBean {
    private int startPage;

    private int endPage;

    private String pdfPath = "E:\\pdf\\Manning.Groovy.in.Action.2nd.Edition.1935182447.pdf";

    private String pdfTxtSavePath= "C:\\Users\\Administrator\\Desktop\\test2.txt";



    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public String getPdfPath() {
        return pdfPath;
    }

    public void setPdfPath(String pdfPath) {
        this.pdfPath = pdfPath;
    }

    public String getPdfTxtSavePath() {
        return pdfTxtSavePath;
    }

    public void setPdfTxtSavePath(String pdfTxtSavePath) {
        this.pdfTxtSavePath = pdfTxtSavePath;
    }
}
