/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.utils;



import java.util.StringTokenizer;

public class calculateStraightLine {

    int period;
    float principal, tax, salvageV, periodSalvage, porcentajeDepre;
    float depRate, annualDep, accDep, ledgersValues, taxPerYear;

    public calculateStraightLine() {
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
    }

    // Constructores
    public String calculo(String data) {

        float aux;
        float aux1;
        String datos = "";

        StringTokenizer st = new StringTokenizer(data, "_");

        this.principal = Float.parseFloat(st.nextToken());
        this.salvageV = Float.parseFloat(st.nextToken());
        this.period = Integer.parseInt(st.nextToken());
        this.tax = Float.parseFloat(st.nextToken());
        this.periodSalvage = Float.parseFloat(st.nextToken());

        aux = this.principal - this.salvageV;
        this.annualDep = aux / this.period;
        this.ledgersValues = this.principal;
        aux1=this.tax/100;
        for (int i = 0; i <= this.period; i++) {

            this.tax=aux1*this.ledgersValues;
            datos = datos + i + "  " + this.annualDep + "  " + this.accDep + "  " + this.ledgersValues +"  "+this.tax+ "\n";
             this.accDep = this.accDep + this.annualDep;
            this.ledgersValues = this.ledgersValues - this.annualDep;
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
