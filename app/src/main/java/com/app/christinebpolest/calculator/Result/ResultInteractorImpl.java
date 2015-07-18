package com.app.christinebpolest.calculator.Result;

/**
 * Created by christine B. Polesti on 7/18/2015.
 */
public class ResultInteractorImpl implements ResultInteractor {

    public ResultInteractorImpl() {}

    @Override
    public boolean isCheck(String resultColor) {
        if (resultColor.equals("ERROR")) {
            return false;
        } else {
            return true;
        }
    }
}
