import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;

public class PDFUtil {



    public static void main(String[] args) {
       // pdfTest(171, 172, "E:\\pdf\\Manning.Groovy.in.Action.2nd.Edition.1935182447.pdf", "C:\\Users\\Administrator\\Desktop\\test2.txt");
    }

    public static void savePdfText(int startPage, int endPage, String pdfPath, String targetPath) {
        try {
            //输出txt文本路径
            PDDocument document = PDDocument.load(new File(pdfPath));
            PDFTextStripper pts = new PDFTextStripper();
            pts.setStartPage(startPage);
            pts.setEndPage(endPage);
            FileUtil.saveTextToFile(targetPath, pts.getText(document));

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("OK!!");
    }
}
