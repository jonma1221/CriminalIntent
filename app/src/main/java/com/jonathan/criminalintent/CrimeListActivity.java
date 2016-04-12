package com.jonathan.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by Jonathan on 4/10/2016.
 */
public class CrimeListActivity extends SingleFragmentActivity {
    protected Fragment createFragment(){
        return new CrimeListFragment();
    }
}
