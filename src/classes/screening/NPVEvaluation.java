package classes.screening;

import classes.control.InputNPV;

import java.util.*;

public class NPVEvaluation {

  public static ArrayList<Float> calcNetCash(ArrayList<Float> inflows, ArrayList<Float> outflows, float principal ,int periods){

    ArrayList<Float> answer = new ArrayList<Float>();

    for(int i = 0; i <= periods; i++){
        if(i == 0){
            answer.add(inflows.get(i) - outflows.get(i) - principal);
        }else{
            answer.add(inflows.get(i) - outflows.get(i));
        }
    }
    return answer;
  }

  public static ArrayList<Float> cumCash(ArrayList<Float> netPresPeriod, int periods){

    ArrayList<Float> answer = new ArrayList<Float>();

    //Add the first value without any other operation
    answer.add(netPresPeriod.get(0));

    for(int i = 1; i<= periods;i++){
      answer.add(answer.get(i-1) + netPresPeriod.get(i));
    }
    return answer;
  }

  public static ArrayList<Float> calcNetPresValuePeriod(ArrayList<Float> netcash, float interest, float tax){

    ArrayList<Float> answer = new ArrayList<Float>();
    int i = 0;

    for(float net : netcash){
      if (i==0){
        float result = net + net*(tax);
        answer.add(result);
      }else{
        Double divisor = Math.pow(1+interest,i);
        float result = (net*(1-tax))/divisor.floatValue();
        answer.add(result);
      }
      i++;
    }
    return answer;
  }

  public static float calcNPV(int period, ArrayList<Float> cumCash){

    return cumCash.get(period);
  }

  public static NPVResult calculateNPV(InputNPV input, ArrayList<Float> inflows, ArrayList<Float> outflows){

    int periods = input.getPeriods();
    float principal = input.getPrincipal();
    float interest = input.getInterest();
    float tax = input.getTax();
    float salvage = input.getSalvage();
    int periodSalvage = input.getSalvagePeriod();

  	interest = interest / 100;
  	tax = tax / 100;

    // Add Salvage Value to the corresponding period
    // inflows.add(periodSalvage, salvage);
    inflows.set(periodSalvage, inflows.get(periodSalvage) + salvage);

    // Calculate NetCashflow Values
    ArrayList<Float> netCashflowValues = calcNetCash(inflows,outflows,principal,periods);

    // Calculate NetPresValue per Period
    ArrayList<Float> netPresValuePeriod = calcNetPresValuePeriod(netCashflowValues, interest, tax);

    // Calculate CumulativeCashflow Values
    ArrayList<Float> cumulativeCashflowValues = cumCash(netPresValuePeriod, periods);

    // Calculate InputNPV
    float npv = calcNPV(periods, cumulativeCashflowValues);

    NPVResult npvR = new NPVResult();

    npvR.setNetCashFlowValues(netCashflowValues);
    npvR.setCumulativeCashFlowValues(cumulativeCashflowValues);
    npvR.setNetPresValuePeriod(netPresValuePeriod);
    npvR.setNetPresentValue(npv);

    return npvR;
  }

}
