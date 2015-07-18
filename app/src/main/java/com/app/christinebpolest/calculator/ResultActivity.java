package com.app.christinebpolest.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.app.christinebpolest.calculator.Result.ResultPresenter;
import com.app.christinebpolest.calculator.Result.ResultPresenterImpl;
import com.app.christinebpolest.calculator.Result.ResultView;

/**
 * Created by christine B. Polesti on 7/18/2015.
 */
public class ResultActivity extends AppCompatActivity implements ResultView {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.txtFirst)
    TextView txtFirst;
    @Bind(R.id.txtSecond)
    TextView txtSecond;
    @Bind(R.id.txtOperator)
    TextView txtOperator;
    @Bind(R.id.txtResult)
    TextView txtResult;
    private String first, second, operator, result;
    ResultPresenterImpl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        presenter = new ResultPresenterImpl(this);
        presenter.setText();
        presenter.setResultColor(result);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Nullable
    @Override
    public Intent getParentActivityIntent() {
        return  super.getParentActivityIntent().addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    }

    @Override
    public void setText() {
        Intent intent = getIntent();
        first = intent.getStringExtra("First");
        second = intent.getStringExtra("Second");
        operator = intent.getStringExtra("Operator");
        result = intent.getStringExtra("Result");

        txtFirst.setText(first);
        txtSecond.setText(second);
        txtOperator.setText(operator);
        txtResult.setText(result);
    }

    @Override
    public void setResultCheck() {
        txtResult.setBackgroundColor(getResources().getColor(R.color.colorSecondary));
    }

    @Override
    public void setResultError() {
        txtResult.setBackgroundColor(getResources().getColor(R.color.accentColor));
    }
}
