package pl.btwarog.apptest.ui.profile;

import android.os.Bundle;
import android.support.annotation.Nullable;

import pl.btwarog.apptest.BaseActivity;
import pl.btwarog.apptest.R;
import pl.btwarog.apptest.ui.main.DashboardFragment;

public class ProfileActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container,PreviewFragment.newInstance())
                    .commit();
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    public void goToEditFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, EditFragment.newInstance())
                .addToBackStack(null)
                .commit();
    }
}
