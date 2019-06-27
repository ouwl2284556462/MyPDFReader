import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class MyUI extends JFrame {


    private MyAction parent;

    private PDFConfigInfoBean config;

    private JTextField startPageTxt;

    private JTextField endPageTxt;

    private JTextField pdfPathTxt;

    private JTextField savePathTxt;

    public MyUI(MyAction parent){
        config = parent.getConfig();


        setSize(200, 400);
        setLocationRelativeTo(null);
        setVisible(true);

        JPanel content = new JPanel();
        setContentPane(content);

        JLabel startPageTitle = new JLabel("开始页");
        content.add(startPageTitle);
        startPageTxt = new JTextField();
        content.add(startPageTxt);
        startPageTxt.setText(config.getStartPage() + "");


        JLabel endPageTitle = new JLabel("结束页");
        content.add(endPageTitle);
        endPageTxt = new JTextField();
        content.add(endPageTxt);
        endPageTxt.setText(config.getEndPage() + "");


        JLabel pdfPathTitle = new JLabel("pdf路径");
        content.add(pdfPathTitle);
        pdfPathTxt = new JTextField();
        content.add(pdfPathTxt);
        pdfPathTxt.setText(config.getPdfPath());

        JLabel savePathTitle = new JLabel("保存路径");
        content.add(savePathTitle);
        savePathTxt = new JTextField();
        content.add(savePathTxt);
        savePathTxt.setText(config.getPdfTxtSavePath());

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        // 注册应用程序全局键盘事件, 所有的键盘事件都会被此事件监听器处理.
        toolkit.addAWTEventListener(event -> {
            if (event.getClass() != KeyEvent.class) {
                return;
            }

            KeyEvent kE = ((KeyEvent) event);
            if(kE.getID() != KeyEvent.KEY_PRESSED){
                return;
            }

            int code= kE.getKeyCode();
            if (code == KeyEvent.VK_ENTER) {
                goPage();
            } else if (code == KeyEvent.VK_ESCAPE) {
                MyUI.this.dispose();
            }else if(code == KeyEvent.VK_F1){
                int startPage = Integer.parseInt(startPageTxt.getText()) + 2;
                int endPage = Integer.parseInt(endPageTxt.getText()) + 2;
                startPageTxt.setText(startPage + "");
                endPageTxt.setText(endPage + "");
                goPage();
            }
        }, AWTEvent.KEY_EVENT_MASK);

        this.parent = parent;
    }

    private void goPage() {
        int startPage = Integer.parseInt(startPageTxt.getText());
        int endPage = Integer.parseInt(endPageTxt.getText());
        String pdfPath = pdfPathTxt.getText();
        String savePath = savePathTxt.getText();
        PDFUtil.savePdfText(startPage, endPage, pdfPath, savePath);

        config.setStartPage(startPage);
        config.setEndPage(endPage);
        config.setPdfPath(pdfPath);
        config.setPdfTxtSavePath(savePath);

        parent.saveConfig();
        MyUI.this.dispose();
    }
}
