package classes.tablemodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TextField;

public final class RowPBP {
    private final SimpleStringProperty period;
    private TextField inflow;
    private TextField outflow;
    private final SimpleStringProperty cumulativeCashFlow;

    public RowPBP(String period,
                  String inflows,
                  String outflows,
                  String cumulativeCashFlow)
    {
        this.period = new SimpleStringProperty(period);
        this.inflow = new TextField(inflows);
        this.outflow = new TextField(outflows);
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

    public TextField getInflow() {
        return inflow;
    }

    public void setInflow(TextField inflow){
        this.inflow = inflow;
    }

    public void setInflow(String inflows){
        this.inflow.setText(inflows);
    }

    public TextField getOutflow() {
        return outflow;
    }

    public void setOutflow(TextField outflow) {
        this.outflow = outflow;
    }

    public void setOutflow(String outflows){
        this.outflow.setText(outflows);
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

    public String getAllDataInRow(){
        return period.getValue()+" "+inflow.getText()+" "+outflow.getText()+" "+cumulativeCashFlow.getValue();
    }
}
