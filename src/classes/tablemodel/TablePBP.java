package classes.tablemodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TextField;

public final class TablePBP {
    private final SimpleStringProperty period;
    private TextField inflows;
    private TextField outflows;
    private final SimpleStringProperty cumulativeCashFlow;

    public TablePBP(String period,
                    String inflows,
                    String outflows,
                    String cumulativeCashFlow)
    {
        this.period = new SimpleStringProperty(period);
        this.inflows = new TextField(inflows);
        this.outflows = new TextField(outflows);
        this.cumulativeCashFlow = new SimpleStringProperty(cumulativeCashFlow);
    }



    public String getPeriod() {
        return period.get();
    }

    public SimpleStringProperty periodProperty() {
        return period;
    }

    public void setPeriod(String period) {
        this.period.set(period);
    }

    public TextField getInflows() {
        return inflows;
    }

    public void setInflows(TextField inflows){
        this.inflows = inflows;
    }

    public void setInflows(String inflows){
        this.inflows.setText(inflows);
    }

    public TextField getOutflows() {
        return outflows;
    }

    public void setOutflows(TextField outflows) {
        this.outflows = outflows;
    }
    public void setOutflows(String outflows){
        this.outflows.setText(outflows);
    }

    public String getCumulativeCashFlow() {
        return cumulativeCashFlow.get();
    }

    public SimpleStringProperty cumulativeCashFlowProperty() {
        return cumulativeCashFlow;
    }

    public void setCumulativeCashFlow(String cumulativeCashFlow) {
        this.cumulativeCashFlow.set(cumulativeCashFlow);
    }
}
