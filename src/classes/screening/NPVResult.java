package classes.screening;

import java.util.*;

public class NPVResult{

  private float netPresentValue;
  private ArrayList<Float> netCashFlowValues;
  private ArrayList<Float> cumulativeCashFlowValues;
  private ArrayList<Float> netPresValuePeriod;

  public NPVResult(){
  }

  public ArrayList<Float> getCumulativeCashFlowValues(){
    return this.cumulativeCashFlowValues;
  }

  public void setCumulativeCashFlowValues(ArrayList<Float> values){
    this.cumulativeCashFlowValues = values;
  }

  public float getNetPresentValue(){
    return this.netPresentValue;
  }

  public void setNetPresentValue(float value){
    this.netPresentValue = value;
  }

  public ArrayList<Float> getNetCashFlowValues(){
    return this.netCashFlowValues;
  }

  public void setNetCashFlowValues(ArrayList<Float> values){
    this.netCashFlowValues = values;
  }

  public ArrayList<Float> getNetPresValuePeriod(){
    return this.netPresValuePeriod;
  }

  public void setNetPresValuePeriod(ArrayList<Float> values){
    this.netPresValuePeriod = values;
  }
}
