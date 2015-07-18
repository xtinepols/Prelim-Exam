package com.app.christinebpolest.calculator.Result;

/**
 * Created by christine B. Polesti on 7/18/2015.
 */
public class ResultPresenterImpl implements ResultPresenter {

    private ResultView resultView;
    private ResultInteractor resultInteractor;

    public ResultPresenterImpl(ResultView resultView) {
        this.resultView = resultView;
        this.resultInteractor = new ResultInteractorImpl();
    }

    @Override
    public void setText() {
        resultView.setText();
    }

    @Override
    public void setResultColor(String resultColor) {
        if (resultInteractor.isCheck(resultColor)) {
            resultView.setResultCheck();
        } else {
            resultView.setResultError();
        }
    }
}
