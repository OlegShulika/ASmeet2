package ru.olegshulika.asmeet2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InfoActivity extends AppCompatActivity {
    private static final String TAG = "4_InfoAct";
    private EditText mInfoDataText;
    private Button mPrevActButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        initViews();
        initExtra();
        initListeners();
        Log.d(TAG, this.getLocalClassName()+" onCreate");
    }

    void initViews(){
        mInfoDataText = findViewById(R.id.info_textView);
        mPrevActButton = findViewById(R.id.info_button_Prev);
        mInfoDataText.setText("/"+TAG);
        this.setTitle(getString(R.string.app_name)+"---"+TAG);
    }

    void initExtra() {
        String newText = getIntent().getStringExtra(getString(R.string.info_data_key));
        Log.d(TAG, "load EXTRA "+newText);

        if (newText!=null)
            mInfoDataText.setText(newText+"/"+TAG);
    }

    void initListeners(){
        mPrevActButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = saveSharedData(getString(R.string.detail_data_key));
                setResult(RESULT_OK, data);
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.d(TAG, this.getLocalClassName()+" onBackPressed");
        Intent data = saveSharedData(getString(R.string.detail_data_key));
        setResult(RESULT_OK, data);
        finish();
    }

    private Intent saveSharedData (String key) {
        String savedText = mInfoDataText.getText().toString();
        Log.d(TAG, "save EXTRA "+savedText);
        Intent dataInt = new Intent();
        dataInt.putExtra(key,savedText);
        return dataInt;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, this.getLocalClassName()+" onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, this.getLocalClassName()+" onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, this.getLocalClassName()+" onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, this.getLocalClassName()+" onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, this.getLocalClassName()+" onDestroy");
    }

}
