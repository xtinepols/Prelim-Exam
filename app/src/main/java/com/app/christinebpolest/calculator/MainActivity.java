package com.app.christinebpolest.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;

import com.app.christinebpolest.calculator.Calculator.CalcPresenterImpl;
import com.app.christinebpolest.calculator.Calculator.CalcView;

public class MainActivity extends AppCompatActivity implements CalcView, View.OnClickListener {

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
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    CalcPresenterImpl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        Add.setOnClickListener(this);
        Subtract.setOnClickListener(this);
        Multiply.setOnClickListener(this);
        Divide.setOnClickListener(this);
        Clear.setOnClickListener(this);
        Exit.setOnClickListener(this);


        presenter = new CalcPresenterImpl(this);
    }

    @Override
    public void Exit() {
        finish();
    }

    @Override
    public void onClick(View view) {
        if (view != Exit && view != Clear) {
            String f = first.getText().toString();
            String s = second.getText().toString();

            if(presenter.Validate(f, s)) {//validate
                switch (view.getId()) {
                    case R.id.btnAdd:
                        presenter.Addition(f, s);
                        break;
                    case R.id.btnSub:
                        presenter.Subtraction(f, s);
                        break;
                    case R.id.btnMulti:
                        presenter.Product(f, s);
                        break;
                    case R.id.btnDivide:
                        presenter.Division(f, s);
                        break;
                    default:
                        break;
                }
            }
        } else if (view == Clear) {
            presenter.Clear();
        } else {
            presenter.Exit();
        }
    }

    @Override
    public void GetResult(String first, String second, String operator, String result) {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("First", first);
        intent.putExtra("Second", second);
        intent.putExtra("Operator", operator);
        intent.putExtra("Result", result);
        startActivity(intent);
    }

    @Override
    public void SetFirstNoError() {
        first.setText(R.string.messageError);
    }

    @Override
    public void SetSecondNoError() {
        second.setText(R.string.messageError);
    }

    @Override
    public void SetMessageError() {
        first.setText("Data must not be empty");
        second.setText("Data must not be empty");
    }

    @Override
    public void NavigateToResult() {
    }

    @Override
    public void Clear() {
        first.setText("");
        second.setText("");
        first.requestFocus();
    }
}
