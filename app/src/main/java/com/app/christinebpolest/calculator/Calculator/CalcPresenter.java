package com.app.christinebpolest.calculator.Calculator;

/**
 * Created by christine B. Polesti on 7/17/2015.
 */
public interface CalcPresenter {

    public boolean Validate(String firstNo, String secondNo);
    public void Addition(String firstNo, String secondNo);
    public void Subtraction(String firstNo, String secondNo);
    public void Product(String firstNo, String secondNo);
    public void Division(String firstNo, String secondNo);
    public void Clear();
    public void Exit();
}
