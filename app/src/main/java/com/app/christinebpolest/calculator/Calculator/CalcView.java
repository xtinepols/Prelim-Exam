package com.app.christinebpolest.calculator.Calculator;

/**
 * Created by christine B. Polesti on 7/17/2015.
 */
public interface CalcView {

    public void SetFirstNoError();
    public void SetSecondNoError();
    public void SetMessageError();
    public void NavigateToResult();
    public void Clear();
    public void Exit();
    public void GetResult(String first, String second, String operator, String result);
}
