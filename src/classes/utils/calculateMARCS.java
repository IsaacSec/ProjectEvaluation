
package classes.utils;

import java.util.StringTokenizer;

public class calculateMARCS {

    int period;
    float principal, tax, salvageV, periodSalvage, porcentajeDepre;
    float depRate, annualDep, accDep, ledgersValues, taxPerYear;
    String category;

    public calculateMARCS() {
        this.principal = 0;
        this.salvageV = 0;
        this.period = 0;
        this.tax = 0;
        this.periodSalvage = 0;

        ///////
        this.accDep = 0;
        this.annualDep = 0;
        this.depRate = 0;
        this.ledgersValues = 0;
        this.taxPerYear = 0;
        this.category = "";

    }

    public String calculo(String data) {

        float aux = 0;
        float aux1 =0;
        String datos = "";

        /*float array3[]=new float [20];
         array3[1]=(float) 33.33; array3[2]=(float) 44.45; array3[3]=(float) 14.81; array3[4]=(float) 7.41;
         float array5[]=new float [20];
         array5[1]=(float) 20;  array5[2]=(float) 32;  array5[3]=(float) 19.20;  array5[4]=(float) 11.52;  array5[5]=(float) 11.52;  array5[6]=(float) 5.76;
         float array7[]=new float [20];
         array7[1]=(float) 14.29;  array7[2]=(float) 24.49;  array7[3]=(float) 17.49;  array7[4]=(float) 12.49;  array7[5]=(float) 8.93;  array7[6]=(float) 8.92;  array7[7]=(float) 8.93;  array7[8]=(float) 4.46;
         float aray10[]=new float [20];
         float array15[]=new float [20];
         float aray20[]=new float [22];*/
        StringTokenizer st = new StringTokenizer(data, "_");

        this.principal = Float.parseFloat(st.nextToken());
        this.salvageV = Float.parseFloat(st.nextToken());
        this.period = Integer.parseInt(st.nextToken());
        this.tax = Float.parseFloat(st.nextToken());
        this.periodSalvage = Float.parseFloat(st.nextToken());
        this.category = st.nextToken();

        float array[] = new float[25];

        if (this.category.equals("3 YEARS")) {
            array[1] = (float) 33.33;
            array[2] = (float) 44.45;
            array[3] = (float) 14.81;
            array[4] = (float) 7.41;
        }
        if (this.category.equals("5 YEARS")) {
            array[1] = (float) 20;
            array[2] = (float) 32;
            array[3] = (float) 19.20;
            array[4] = (float) 11.52;
            array[5] = (float) 11.52;
            array[6] = (float) 5.76;
        }
        if (this.category.equals("7 YEARS")) {
            array[1] = (float) 14.29;
            array[2] = (float) 24.49;
            array[3] = (float) 17.49;
            array[4] = (float) 12.49;
            array[5] = (float) 8.93;
            array[6] = (float) 8.92;
            array[7] = (float) 8.93;
            array[8] = (float) 4.46;
        }
        if (this.category.equals("10 YEARS")) {
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
        if (this.category.equals("15 YEARS")) {
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
        if (this.category.equals("20 YEARS")) {
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

        this.ledgersValues = this.principal;
        aux1 = this.tax / 100;

        for (int i = 0; i <= this.period; i++) {
                
            
            if (i == 0) {
                this.tax=aux1*this.ledgersValues;
                datos = datos + i + "    " + array[i] + "%" + "    " + this.annualDep + "       " + this.accDep + "       " + this.ledgersValues + "    "+this.tax+"\n";

            }
            if (i >= 1) {
                
                aux = array[i] / 100;
                this.annualDep = aux * this.ledgersValues;
                this.accDep = this.accDep + this.annualDep;
                //this.annualDep=aux*this.ledgersValues;
                this.ledgersValues = this.ledgersValues - this.annualDep;
                this.tax=aux1*this.ledgersValues;
                datos = datos + i + "  " + array[i] + "%" + "  " + this.annualDep + "  " + this.accDep + "  " + this.ledgersValues +"  "+this.tax+"\n";

            }

        }

        //return this.principal+"_"+this.salvageV+"_"+this.period+"_"+this.tax+"_"+this.periodSalvage;
        return datos;

    }

    public float getAccDep() {
        return this.accDep;
    }

    public float getAnnualDep() {
        return this.annualDep;
    }

    public float getDepRate() {
        return this.depRate;
    }

    public float getLedgers() {
        return this.ledgersValues;
    }

    public float getTaxPerYear() {
        return this.taxPerYear;
    }

    public void setAccDep(float accD) {
        this.accDep = accD;
    }

    public void setAnnualDep(float annualDe) {
        this.annualDep = annualDe;
    }

    public void setDepRate(float depRa) {
        this.depRate = depRa;
    }

    public void setLedgers(float ledgers) {
        this.ledgersValues = ledgers;
    }

    public void setTaxPerYear(float taxYear) {
        this.taxPerYear = taxYear;
    }

}
