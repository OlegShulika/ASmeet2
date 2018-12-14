package ru.olegshulika.asmeet2;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SplashActivity extends AppCompatActivity {
    private static final String TAG = "1_SplashAct";
    private EditText mSplashDataText;
    private Button mNextActButton;
    public static final int REQUEST_CODE_MAIN = 1301;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initViews();
        initListeners();
        Log.d(TAG, " onCreate");
    }

    private void initViews(){
        mNextActButton = findViewById(R.id.splash_button_Next);
        mSplashDataText = findViewById((R.id.splash_textView));
        mSplashDataText.setText("/"+TAG);
        this.setTitle(getString(R.string.app_name)+"---"+TAG);
    }

    void initExtra() {
        String newText = getIntent().getStringExtra(getString(R.string.splash_data_key));
        Log.d(TAG, "load EXTRA "+newText);

        if (newText!=null)
            mSplashDataText.setText(newText+"/"+TAG);
    }

    private void initListeners(){
        mNextActButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startMain = newIntent(SplashActivity.this, MainActivity.class,
                        getString(R.string.main_data_key), mSplashDataText.getText().toString());
                startActivityForResult(startMain, REQUEST_CODE_MAIN);
            }
        });
    }

    public static final Intent newIntent (Context context, Class<?> cls, String key, String extra){
        Intent intent = new Intent(context, cls);
        Log.d(TAG, "save EXTRA "+extra);
        intent.putExtra(key, extra);
        return intent;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, this.getLocalClassName()+" onActivityResult, req="+requestCode+" res="+resultCode+" data="+data);
        if (requestCode==REQUEST_CODE_MAIN){
            if (data==null)
                return;
            String newText = data.getStringExtra(getString(R.string.splash_data_key));
            if (newText!=null)
                mSplashDataText.setText(newText+"/"+TAG);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, " onStart");
    }

    @Override
    protected void onResume() {
        initExtra();
        super.onResume();
        Log.d(TAG, " onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, " onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, " onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, " onDestroy");
    }
}
