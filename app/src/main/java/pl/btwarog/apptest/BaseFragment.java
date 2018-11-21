package pl.btwarog.apptest;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public abstract class BaseFragment extends Fragment {

    protected abstract int getLayoutId();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("AppTest","Fragment Lifecycle #onAttach "+getClass().getSimpleName());
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("AppTest","Fragment Lifecycle #onCreate "+getClass().getSimpleName());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("AppTest","Fragment Lifecycle #onCreateView "+getClass().getSimpleName());
        return inflater.inflate(getLayoutId(), container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("AppTest","Fragment Lifecycle #onViewCreated "+getClass().getSimpleName());
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("AppTest","Fragment Lifecycle #onActivityCreated "+getClass().getSimpleName());
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("AppTest","Fragment Lifecycle #onStar "+getClass().getSimpleName());
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("AppTest","Fragment Lifecycle #onResume "+getClass().getSimpleName());
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("AppTest","Fragment Lifecycle #onPause "+getClass().getSimpleName());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("AppTest","Fragment Lifecycle #onDestroy "+getClass().getSimpleName());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("AppTest","Fragment Lifecycle #onDestroyView "+getClass().getSimpleName());
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("AppTest","Fragment Lifecycle #onDetach "+getClass().getSimpleName());
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("AppTest","Fragment Lifecycle #onSaveInstanceState "+getClass().getSimpleName());
    }
}
