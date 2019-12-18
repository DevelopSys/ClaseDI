import javax.swing.*;
import java.util.List;

public class MiWorker extends SwingWorker<Boolean,Integer> {


    PanelPrimos panelPrimos;

    public MiWorker(PanelPrimos panelPrimos) {
        this.panelPrimos = panelPrimos;
        this.panelPrimos.getBarra().
                setMaximum(Integer.valueOf(panelPrimos.gettTPrimos().getText()));
    }

    @Override
    protected Boolean doInBackground() throws Exception {
        for(int i=0;i<Integer.valueOf(panelPrimos.gettTPrimos().getText());i++){
            publish(i);
            Thread.sleep(100);
        }
        return true;
    }


    @Override
    protected void process(List<Integer> chunks) {
        super.process(chunks);
        panelPrimos.getBarra().setValue(chunks.get(0));
        panelPrimos.gettAPrimos().append(chunks.get(0).toString()+"\n");
    }

    @Override
    protected void done() {
        super.done();
        JOptionPane.showMessageDialog(panelPrimos,"mensaje");
    }
}
