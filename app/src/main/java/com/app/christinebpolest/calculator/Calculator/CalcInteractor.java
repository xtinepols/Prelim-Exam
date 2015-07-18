package com.app.christinebpolest.calculator.Calculator;

/**
 * Created by christine B. Polesti on 7/18/2015.
 */
public interface CalcInteractor {

    public String validateNumber(String firstNo, String secondNo);
    public String Compute(String firstNo, String secondNo, String operator);
    public String Format(String num);
}
