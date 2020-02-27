package com.bignerdranch.android.criminalintent.activity;

import com.bignerdranch.android.criminalintent.fragment.CrimeListFragment;

import androidx.fragment.app.Fragment;

public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
