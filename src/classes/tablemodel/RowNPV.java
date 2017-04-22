package classes.tablemodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TextField;

public class RowNPV {
    private final SimpleStringProperty period;
    private TextField outflow;
    private TextField inflow;
    private final SimpleStringProperty netCashFlow;
    private final SimpleStringProperty cumulativeCashFlow;

    public RowNPV(String period,
                  String outflows,
                  String inflows,
                  String netCashFlow,
                  String cumulativeCashFlow) {

        this.period = new SimpleStringProperty(period);
        this.outflow = new TextField(outflows);
        this.inflow = new TextField(inflows);
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

    public TextField getOutflow() {
        return outflow;
    }

    public TextField getInflow() {
        return inflow;
    }

    public void setInflow(TextField inflow){
        this.inflow = inflow;
    }

    public void setInflow(String inflow){
        this.inflow.setText(inflow);
    }

    public void setOutflow(TextField outflow) {
        this.outflow = outflow;
    }

    public void setOutflow(String outflow) {
        this.outflow.setText(outflow);
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
