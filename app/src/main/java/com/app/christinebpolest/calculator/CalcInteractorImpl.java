package com.app.christinebpolest.calculator;

import android.text.TextUtils;

import org.w3c.dom.Text;

/**
 * Created by christine B. Polesti on 7/18/2015.
 */
public class CalcInteractorImpl implements CalcInteractor {

    @Override
    public void getData(String firstNo, String secondNo, FinishedListener listener) {
        boolean error = false;
        if (TextUtils.isEmpty(firstNo)) {
            listener.onFirstNoError();
        }
        if (TextUtils.isEmpty(secondNo)) {
            listener.onSecondNoError();
        }
        if (!error) {
            listener.setCursorFirst();
        }
    }
}
