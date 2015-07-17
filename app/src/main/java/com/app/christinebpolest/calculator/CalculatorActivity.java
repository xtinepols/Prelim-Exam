package com.app.christinebpolest.calculator;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CalculatorActivity extends AppCompatActivity implements CalcView {

    @Bind(R.id.first)
    EditText first;
    @Bind(R.id.second)
    EditText second;
    @Bind(R.id.btnAdd)
    Button Add;
    @Bind(R.id.btnSub)
    Button Subtract;
    @Bind(R.id.btnMulti)
    Button Multiply;
    @Bind(R.id.btnDivide)
    Button Divide;
    @Bind(R.id.btnClear)
    Button Clear;
    @Bind(R.id.btnExit)
    Button Exit;
    private CalcPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new CalcPresenterImpl(this);
    }

    @OnClick ({R.id.btnAdd, R.id.btnSub, R.id.btnMulti, R.id.btnDivide})
    public void compute(Button view) {
        String firstNo = this.first.getText().toString();
        String secondNo = this.second.getText().toString();
        String operate = view.getText().toString();

        if (!presenter.isEmpty(firstNo) && !presenter.isEmpty(secondNo)) {
            presenter.getNumber(firstNo, secondNo);
            Toast.makeText(this,"add", Toast.LENGTH_LONG).show();
        } else {
            if(presenter.isEmpty(firstNo)) {
                setFirstNoError();
            }
            if (presenter.isEmpty(secondNo)) {
                setSecondNoError();
            }
        }
    }



    @Override
    public void setFirstNoError() {
        first.setError(getString(R.string.messageFirst));
    }

    @Override
    public void setSecondNoError() {
        second.setError(getString(R.string.messageSecond));
    }

    @Override
    public void setCursorFirst() {
        first.setSelection(0);
    }
}
