package com.app.christinebpolest.calculator.Calculator;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * Created by christine B. Polesti on 7/18/2015.
 */
public class CalcInteractorImpl implements CalcInteractor {

    public CalcInteractorImpl() {}

    @Override
    public String validateNumber(String firstNo, String secondNo) {
        String validate = null;
        if (firstNo.equals("") && secondNo.equals("")) {
            validate = "both";
        } else if (!firstNo.equals("") && secondNo.equals("")) {
            validate = "first";
        } else if (firstNo.equals("") && !secondNo.equals("")) {
            validate ="second";
        }
        return validate;
    }

    @Override
    public String Compute(String firstNo, String secondNo, String operator) {
        try {
            double f = Double.parseDouble(firstNo);
            double s = Double.parseDouble(secondNo);
            switch (operator) {
                case "add": return (f+s)+"";
                case "sub": return (f-s)+"";
                case "pro": return (f*s)+"";
                case "qou": return (f/s)+"";
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } return "ERROR";
    }

    @Override
    public String Format(String num) {
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
        Number number = null;
        try {
            number = numberFormat.parse(num);
            return number.doubleValue() + "";
        } catch (ParseException e) {
            e.printStackTrace();
        } return num;
    }
}
