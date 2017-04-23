package classes.screening;

import classes.control.InputPBP;

import java.util.ArrayList;

import static java.lang.StrictMath.abs;

/**
 * Created by erikm on 18/04/2017.
 */
public class PBPEvaluation {

    public static PBPResult calculatePBP(InputPBP pbp, ArrayList<Float> outflow, ArrayList<Float> inflow) {
        PBPResult result = new PBPResult();
        float add;
        ArrayList<Float> cumulativeCashFlow = result.getCumulativeCashFlow();
        if (outflow.size() > 0 && inflow.size() > 0) {
            add = -pbp.getPrincipal() - outflow.get(0) + inflow.get(0);             //Initialize the add with the principal
            cumulativeCashFlow.add(add);

            if (pbp.getInterest() == 0) {
                for (int i = 1; i < pbp.getPeriods() + 1; i++) {                    //Calculate all periods
                    add = add - outflow.get(i) + inflow.get(i);                         //Get the Comulative cash flow for period i
                    cumulativeCashFlow.add(add);
                }
            } else {
                float interestAdd;
                for (int i = 1; i < pbp.getPeriods() + 1; i++) {                    //Calculate all periods
                    interestAdd = abs(add) * pbp.getInterest() / 100;                //Get the interest of the comulative cash flow
                    add = add - interestAdd - outflow.get(i) + inflow.get(i);       //Get the Comulative cash flow for period i
                    cumulativeCashFlow.add(add);
                }
            }

            for (int i = 0; i < cumulativeCashFlow.size(); i++) {                       //TODO: Examine the case in which there is no pbp
                if (cumulativeCashFlow.get(i) >= 0) {
                    result.setResultingPeriod(i);
                }
            }
            return result;
        }
        return null;
    }
}
