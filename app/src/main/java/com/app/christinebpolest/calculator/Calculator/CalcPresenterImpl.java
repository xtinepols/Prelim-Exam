package com.app.christinebpolest.calculator.Calculator;

/**
 * Created by christine B. Polesti on 7/17/2015.
 */
public class CalcPresenterImpl implements CalcPresenter {

    private CalcView calcView;
    private CalcInteractor calcInteractor;

    public CalcPresenterImpl(CalcView calcView) {
        this.calcView = calcView;
        this.calcInteractor = new CalcInteractorImpl();
    }

    @Override
    public boolean Validate(String firstNo, String secondNo) {
        String isValid = calcInteractor.validateNumber(firstNo, secondNo);
        if(isValid.equals("both")) {
            calcView.SetMessageError();
            return false;
        } else if (isValid.equals("first")) {
            calcView.SetFirstNoError();
            return false;
        } else if (isValid.equals("second")) {
            calcView.SetSecondNoError();
            return false;
        } else {
            calcView.NavigateToResult();
            return true;
        }
    }

    @Override
    public void Addition(String firstNo, String secondNo) {
        String f = calcInteractor.Format(firstNo);
        String s = calcInteractor.Format(secondNo);
        String add = calcInteractor.Compute(f, s, "add");
        calcView.GetResult(f, "+", s, add);
    }

    @Override
    public void Subtraction(String firstNo, String secondNo) {
        String f = calcInteractor.Format(firstNo);
        String s = calcInteractor.Format(secondNo);
        String sub = calcInteractor.Compute(f, s, "sub");
        calcView.GetResult(f, "-", s, sub);
    }

    @Override
    public void Product(String firstNo, String secondNo) {
        String f = calcInteractor.Format(firstNo);
        String s = calcInteractor.Format(secondNo);
        String prod = calcInteractor.Compute(f, s, "pro");
        calcView.GetResult(f, "*", s, prod);
    }

    @Override
    public void Division(String firstNo, String secondNo) {
        String f = calcInteractor.Format(firstNo);
        String s = calcInteractor.Format(secondNo);
        String div = calcInteractor.Compute(f, s, "qou");
        calcView.GetResult(f, "/", s, div);
    }

    @Override
    public void Clear() {
        calcView.Clear();
    }

    @Override
    public void Exit() {
        calcView.Exit();
    }
}
