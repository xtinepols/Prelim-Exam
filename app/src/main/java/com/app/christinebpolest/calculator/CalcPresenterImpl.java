package com.app.christinebpolest.calculator;

import java.math.BigDecimal;

/**
 * Created by christine B. Polesti on 7/17/2015.
 */
public class CalcPresenterImpl implements CalcPresenter, FinishedListener {

    private CalcView calcView;
    private CalcInteractor calcInteractor;

    public CalcPresenterImpl(CalcView calcView) {
        this.calcView = calcView;
        this.calcInteractor = new CalcInteractorImpl();
    }

    @Override
    public void getNumber(String firstNo, String secondNo) {
        calcInteractor.getData(firstNo, secondNo, this);
    }

    @Override
    public boolean isEmpty(String number) {
        boolean boo = false;
        if(number.isEmpty()) {
            boo = true;
        } else {
            boo = false;
        }
        return boo;
    }

    @Override
    public void onFirstNoError() {
        calcView.setFirstNoError();
    }

    @Override
    public void onSecondNoError() {
        calcView.setSecondNoError();
    }

    @Override
    public void setCursorFirst() {
        calcView.setCursorFirst();
    }
}
