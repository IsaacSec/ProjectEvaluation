package classes.screening;

import classes.control.PBPInput;

import java.util.ArrayList;

import static java.lang.StrictMath.abs;

/**
 * Created by erikm on 18/04/2017.
 */
public class PBPEvaluation {

    public  ArrayList<Float> calculatePBP(PBPInput pbp, ArrayList<Float> outflow, ArrayList<Float> inflow) {
        ArrayList<Float> comulativeCashFlow = new ArrayList<>();
        float add = - pbp.getPrincipal() - outflow.get(0) + inflow.get(0);                                       //Initialize the add with the principal
        comulativeCashFlow.add(add);
        if(pbp.getInterest() == 0) {
            for (int i = 1; i < pbp.getPeriods() + 1; i++) {                    //Calculate all periods
            add = add - outflow.get(i) + inflow.get(i);                         //Get the Comulative cash flow for period i
                comulativeCashFlow.add(add);
            }
            return comulativeCashFlow;
        }else{
            float interestAdd;
            for (int i = 1; i < pbp.getPeriods() + 1; i++) {                    //Calculate all periods
                interestAdd = abs(add) * pbp.getInterest()/ 100;                //Get the interest of the comulative cash flow
                add = add - interestAdd - outflow.get(i) + inflow.get(i);       //Get the Comulative cash flow for period i
                comulativeCashFlow.add(add);
            }
            return comulativeCashFlow;
        }
    }
}
