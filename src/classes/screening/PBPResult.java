package classes.screening;

import java.util.ArrayList;

public class PBPResult {
    private ArrayList<Float> cumulativeCashFlow;
    private int resultingPeriod;

    public PBPResult(){
        setCumulativeCashFlow(new ArrayList<>());
    }

    public PBPResult(ArrayList<Float> cumulativeCashFlow, int resultingPeriod) {
        this.cumulativeCashFlow = cumulativeCashFlow;
        this.resultingPeriod = resultingPeriod;
    }

    public ArrayList<Float> getCumulativeCashFlow() {
        return cumulativeCashFlow;
    }

    public void setCumulativeCashFlow(ArrayList<Float> cumulativeCashFlow) {
        this.cumulativeCashFlow = cumulativeCashFlow;
    }

    public int getResultingPeriod() {
        return resultingPeriod;
    }

    public void setResultingPeriod(int resultingPeriod) {
        this.resultingPeriod = resultingPeriod;
    }
}
