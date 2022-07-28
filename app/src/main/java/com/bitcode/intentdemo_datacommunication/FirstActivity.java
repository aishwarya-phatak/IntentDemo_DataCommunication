package com.bitcode.intentdemo_datacommunication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class FirstActivity extends Activity {

    TextView txtInfo;
    EditText edtInfo;
    Button btnNext;

    String result;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);

        initViews();
        initListeners();
    }

    private void initViews(){
        txtInfo = findViewById(R.id.txtInfo);
        edtInfo = findViewById(R.id.edtInfo);
        btnNext = findViewById(R.id.btnNext);
    }

    private void initListeners(){
        btnNext.setOnClickListener(new BtnNextClickListener());
    }

    private class BtnNextClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(
                    FirstActivity.this,
                    SecondActivity.class
            );

            intent.putExtra("name", edtInfo.getText().toString());
            intent.putExtra("rollNumber",10);

            startActivityForResult(intent,1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data == null){
            return;
        }

        Bundle bundle = data.getExtras();
        result = bundle.getString("result");
        txtInfo.setText(result);
    }
}
