package classes.screening;

import classes.control.InputDEP;

import java.util.ArrayList;

/**
 * Created by isaac on 4/22/17.
 */
public class DEPEvaluation {

    public static DEPResult calculateStraightLine(InputDEP input){
        ArrayList<Float> depreciationRate = new ArrayList<>();
        ArrayList<Float> annualDepreciation = new ArrayList<>();
        ArrayList<Float> accumulatedDepreciation = new ArrayList<>();
        ArrayList<Float> ledgerValues = new ArrayList<>();
        ArrayList<Float> taxPerYear = new ArrayList<>();

        float aux, annualDep = 0, ledgerValue, accDep, taxYear = 0, depRate = 0;

        int periods = input.getPeriods();
        float principal = input.getPrincipal();
        float tax = input.getTax();
        float salvageV = input.getSalvage();
        int periodSalvage = input.getPeriodSalvage();

        aux = principal - salvageV;
        ledgerValue = principal;
        tax = tax/100;
        accDep = 0;

        for (int i = 0; i <= periods; i++) {
            taxYear = tax * ledgerValue;

            depreciationRate.add(depRate);
            annualDepreciation.add(annualDep);
            accumulatedDepreciation.add(accDep);
            ledgerValues.add(ledgerValue);
            taxPerYear.add(taxYear);

            annualDep = aux / periods;
            depRate = annualDep/ledgerValue * 100;
            accDep = accDep + annualDep;
            ledgerValue = ledgerValue - annualDep;
        }

        depreciationRate.add(depRate);
        annualDepreciation.add(annualDep);
        accumulatedDepreciation.add(accDep);
        ledgerValues.add(ledgerValue);
        taxPerYear.add(taxYear);

        return new DEPResult(depreciationRate, annualDepreciation, accumulatedDepreciation, ledgerValues, taxPerYear);
    }

    public static DEPResult calculateMACRS(InputDEP input){
        ArrayList<Float> depreciationRate = new ArrayList<>();
        ArrayList<Float> annualDepreciation = new ArrayList<>();
        ArrayList<Float> accumulatedDepreciation = new ArrayList<>();
        ArrayList<Float> ledgerValues = new ArrayList<>();
        ArrayList<Float> taxPerYear = new ArrayList<>();

        float aux = 0;
        float aux1 = 0;

        float principal = input.getPrincipal();
        float salvageV = input.getSalvage();
        int periods = input.getPeriods();
        float tax = input.getTax();
        int periodSalvage = input.getPeriodSalvage();
        String category = input.getCategory();

        float array[] = new float[25];

        if (category.equals("3 Years")) {
            array[1] = (float) 33.33;
            array[2] = (float) 44.45;
            array[3] = (float) 14.81;
            array[4] = (float) 7.41;
        }
        if (category.equals("5 Years")) {
            array[1] = (float) 20;
            array[2] = (float) 32;
            array[3] = (float) 19.20;
            array[4] = (float) 11.52;
            array[5] = (float) 11.52;
            array[6] = (float) 5.76;
        }
        if (category.equals("7 Years")) {
            array[1] = (float) 14.29;
            array[2] = (float) 24.49;
            array[3] = (float) 17.49;
            array[4] = (float) 12.49;
            array[5] = (float) 8.93;
            array[6] = (float) 8.92;
            array[7] = (float) 8.93;
            array[8] = (float) 4.46;
        }
        if (category.equals("10 Years")) {
            array[1] = (float) 10;
            array[2] = (float) 18;
            array[3] = (float) 14.40;
            array[4] = (float) 11.52;
            array[5] = (float) 9.22;
            array[6] = (float) 7.37;
            array[7] = (float) 6.55;
            array[8] = (float) 6.55;
            array[9] = (float) 6.56;
            array[10] = (float) 6.55;
            array[11] = (float) 3.28;
        }
        if (category.equals("15 Years")) {
            array[1] = (float) 5;
            array[2] = (float) 9.5;
            array[3] = (float) 8.55;
            array[4] = (float) 7.70;
            array[5] = (float) 6.93;
            array[6] = (float) 6.23;
            array[7] = (float) 5.90;
            array[8] = (float) 5.90;
            array[9] = (float) 5.91;
            array[10] = (float) 5.90;
            array[11] = (float) 5.91;
            array[12] = (float) 5.90;
            array[13] = (float) 5.91;
            array[14] = (float) 5.90;
            array[15] = (float) 5.91;
            array[16] = (float) 2.95;
        }
        if (category.equals("20 Years")) {
            array[1] = (float) 3.750;
            array[2] = (float) 7.219;
            array[3] = (float) 6.677;
            array[4] = (float) 6.177;
            array[5] = (float) 5.713;
            array[6] = (float) 5.285;
            array[7] = (float) 4.888;
            array[8] = (float) 4.522;
            array[9] = (float) 4.462;
            array[10] = (float) 4.461;
            array[11] = (float) 4.462;
            array[12] = (float) 4.461;
            array[13] = (float) 4.462;
            array[14] = (float) 4.461;
            array[15] = (float) 4.462;
            array[16] = (float) 4.461;
            array[17] = (float) 4.462;
            array[18] = (float) 4.461;
            array[19] = (float) 4.462;
            array[20] = (float) 4.461;
            array[21] = (float) 2.231;
        }

        float ledgersValues = principal;
        float depRate, annualDep=0, accDep=0, taxYear=0;
        tax = tax / 100;

        for (int i = 0; i <= periods; i++) {

            if (i == 0) {
                depRate = 0;
                taxYear = tax * ledgersValues;

                depreciationRate.add(depRate);
                annualDepreciation.add(annualDep);
                accumulatedDepreciation.add(accDep);
                ledgerValues.add(ledgersValues);
                taxPerYear.add(taxYear);
            }
            if (i >= 1) {
                depRate = array[i]/100;
                annualDep = depRate * ledgersValues;
                accDep = accDep + annualDep;
                ledgersValues = ledgersValues - annualDep;
                taxYear = tax * ledgersValues;

                depreciationRate.add(depRate * 100);
                annualDepreciation.add(annualDep);
                accumulatedDepreciation.add(accDep);
                ledgerValues.add(ledgersValues);
                taxPerYear.add(taxYear);
            }

        }

        return new DEPResult(depreciationRate, annualDepreciation, accumulatedDepreciation, ledgerValues, taxPerYear);
    }
}
