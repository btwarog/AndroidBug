package pl.btwarog.apptest.ui.profile;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;

import pl.btwarog.apptest.BaseFragment;
import pl.btwarog.apptest.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EditFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EditFragment extends BaseFragment {

    String mainTitle = "NotSetted";


    public EditFragment() {
        setRetainInstance(true);
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment PreviewFragment.
     */
    public static EditFragment newInstance() {
        EditFragment fragment = new EditFragment();
        fragment.mainTitle = "Setted";
        return fragment;
    }



    @Override
    protected int getLayoutId() {
        return R.layout.fragment_edit;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("AppTest","Fragment Lifecycle #onResume "+ mainTitle+ " "+getClass().getSimpleName());
    }
}
