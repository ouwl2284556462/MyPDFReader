import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

public class MyAction extends AnAction {
    private final static String PAGE_HIS_PATH = "c:/pageHis";

    private PDFConfigInfoBean config;
    public MyAction(){
        config = JsonUtil.getObjectFromJsonFile(PAGE_HIS_PATH, PDFConfigInfoBean.class);

        if(null == config){
            config = new PDFConfigInfoBean();
        }
    }

    @Override
    public void actionPerformed(AnActionEvent e) {
        new MyUI(this);
    }

    public void saveConfig(){
        JsonUtil.saveObjToJsonFile(config, PAGE_HIS_PATH);
    }

    public PDFConfigInfoBean getConfig(){
        return config;
    }

}
