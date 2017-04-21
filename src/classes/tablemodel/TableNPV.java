package classes.tablemodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TextField;

public class TableNPV {
    private final SimpleStringProperty period;
    private TextField outflows;
    private TextField inflows;
    private final SimpleStringProperty netCashFlow;
    private final SimpleStringProperty cumulativeCashFlow;

    public TableNPV(String period,
                    String outflows,
                    String inflows,
                    String netCashFlow,
                    String cumulativeCashFlow) {

        this.period = new SimpleStringProperty(period);
        this.outflows = new TextField(outflows);
        this.inflows = new TextField(inflows);
        this.netCashFlow = new SimpleStringProperty(netCashFlow);
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

    public TextField getOutflows() {
        return outflows;
    }

    public TextField getInflows() {
        return inflows;
    }

    public void setInflows(TextField inflows){
        this.inflows = inflows;
    }

    public void setOutflows(TextField outflows) {
        this.outflows = outflows;
    }

    public String getNetCashFlow() {
        return netCashFlow.get();
    }

    public SimpleStringProperty netCashFlowProperty() {
        return netCashFlow;
    }

    public void setNetCashFlow(String netCashFlow) {
        this.netCashFlow.set(netCashFlow);
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
