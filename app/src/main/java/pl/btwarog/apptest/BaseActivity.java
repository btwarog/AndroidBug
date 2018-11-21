package pl.btwarog.apptest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseActivity extends AppCompatActivity {

    protected abstract int getLayoutId();

    private boolean shouldKillBundle() {
        return false;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("AppTest","Activity Lifecycle #onCreate "+getClass().getSimpleName());
        setContentView(getLayoutId());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("AppTest","Activity Lifecycle #onStart "+getClass().getSimpleName());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("AppTest","Activity Lifecycle #onResume "+getClass().getSimpleName());
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("AppTest","Activity Lifecycle #onRestart "+getClass().getSimpleName());
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("AppTest","Activity Lifecycle #onPause "+getClass().getSimpleName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("AppTest","Activity Lifecycle #onDestroy "+getClass().getSimpleName());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("TestString","Test");
        if(shouldKillBundle()) {
            killBundleWithTooLargeData(outState);
        }
        Log.d("AppTest","Activity Lifecycle #onSaveInstanceState "+getClass().getSimpleName());
    }

    private void killBundleWithTooLargeData(Bundle outState) {
        Map<Integer, Map<Integer,String>> oversizedMap = new HashMap<>();

        for(int i = 0; i < 10; i++ ) {
            Map<Integer, String> nestedMap = new HashMap<>();
            for(int j = 0; j < 500; j++ ) {
                nestedMap.put(j,"POG3A:{accountType:2,periodRequired:false,vat:false}");
            }
            oversizedMap.put(i, nestedMap);
        }
        outState.putSerializable("Test", new HashMap<>(oversizedMap));
    }
}
