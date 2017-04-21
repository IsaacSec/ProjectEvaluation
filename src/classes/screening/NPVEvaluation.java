package classes.screening;

import java.util.*;

public class NPVEvaluation {

  private NPVResult npvR = new NPVResult();

  public ArrayList<Float> calcNetCash(ArrayList<Float> inflows, ArrayList<Float> outflows, int periods){

    ArrayList<Float> answer = new ArrayList<Float>();

    for(int i = 0; i < periods; i++){
      answer.add(inflows.get(i) - outflows.get(i));
    }
    return answer;
  }

  public ArrayList<Float> cumCash(ArrayList<Float> netPresPeriod, int periods){

    ArrayList<Float> answer = new ArrayList<Float>();

    //Add the first value without any other operation
    answer.add(netPresPeriod.get(0));

    for(int i = 1; i<periods;i++){
      answer.add(answer.get(i-1) + netPresPeriod.get(i));
    }
    return answer;
  }

  public ArrayList<Float> calcNetPresValuePeriod(ArrayList<Float> netcash, float interest, float tax){

    ArrayList<Float> answer = new ArrayList<Float>();
    int i = 1;

    for(float net : netcash){
      Double divisor = Math.pow(1+interest,i);
      float result = (net*(1-tax))/divisor.floatValue();
      answer.add(result);
      i++;
    }
    return answer;
  }

  public float calcNPV(int period, float principal, ArrayList<Float> cumCash){

    return cumCash.get(period-1) - principal;
  }

  public NPVResult calculateNPV(int periods, float principal, float interest, float tax, float salvage, int periodSalvage, ArrayList<Float> inflows, ArrayList<Float> outflows){

  	interest = interest / 100;
  	tax = tax / 100;

    // Add Salvage Value to the corresponding period
    // inflows.add(periodSalvage, salvage);
    inflows.set(periodSalvage-1, inflows.get(periodSalvage-1) + salvage);

    // Calculate NetCashflow Values
    ArrayList<Float> netCashflowValues = calcNetCash(inflows,outflows, periods);

    // Calculate NetPresValue per Period
    ArrayList<Float> netPresValuePeriod = calcNetPresValuePeriod(netCashflowValues, interest, tax);

    // Calculate CumulativeCashflow Values
    ArrayList<Float> cumulativeCashflowValues = cumCash(netPresValuePeriod, periods);

    // Calculate NetPresentValue
    float npv = calcNPV(periods, principal, cumulativeCashflowValues);

    npvR.setNetCashFlowValues(netCashflowValues);
    npvR.setCumulativeCashFlowValues(cumulativeCashflowValues);
    npvR.setNetPresValuePeriod(netPresValuePeriod);
    npvR.setNetPresentValue(npv);

    return this.npvR;
  }

}
