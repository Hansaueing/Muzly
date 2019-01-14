package com.payne.muzly;

import android.app.Activity;
import android.os.Bundle;

import com.muzly.panye.muzlylib.Test;
import com.muzly.panye.muzlyres.Test1;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Test.show();
        Test1.show();
    }
}
