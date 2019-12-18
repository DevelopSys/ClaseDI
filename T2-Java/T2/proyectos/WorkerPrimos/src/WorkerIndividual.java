import javax.swing.*;
import java.util.List;

public class WorkerIndividual extends SwingWorker<Boolean, Integer> {

    PanelPrimos panelPrimos;

    public WorkerIndividual(PanelPrimos panelPrimos) {
        this.panelPrimos = panelPrimos;
        panelPrimos.getBarra().setMaximum(Integer.valueOf(panelPrimos.gettTPrimos().getText()));
    }

    @Override
    protected Boolean doInBackground() throws Exception {
        for (int i=1;i<Integer.valueOf(panelPrimos.gettTPrimos().getText());i++){
            publish(i);
            Thread.sleep(100);
        }
        return true;
    }

    @Override
    protected void process(List<Integer> chunks) {
        super.process(chunks);
        panelPrimos.getBarra().setValue(chunks.get(0));
        panelPrimos.gettAPrimos().append(chunks.get(0)+"\n");
    }

    @Override
    protected void done() {
        super.done();
        JOptionPane.showMessageDialog(panelPrimos,"Terminado",
                "Titulo",JOptionPane.INFORMATION_MESSAGE);
    }
}















