package com.example.yiliaoyinian.views;//package com.example.yiliaoyinian.views;


import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.yiliaoyinian.ui.fragmengmain.Fragment3;
import com.example.yiliaoyinian.ui.fragmengmain.Fragment3_1;
import com.example.yiliaoyinian.ui.fragmengmain.Fragment3_2;

import org.jetbrains.annotations.NotNull;

public class RenWuFragmentPagerAdapter extends FragmentPagerAdapter {

    private Fragment3_1 myFragment1 = null;
    private Fragment3_2 myFragment2 = null;


    public RenWuFragmentPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        myFragment1 = new Fragment3_1();
        myFragment2 = new Fragment3_2();


    }

    @Override
    public int getCount() {
        return 2;
    }

    @NotNull
    @Override
    public Object instantiateItem(@NotNull ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(@NotNull ViewGroup container, int position, @NotNull Object object) {
        super.destroyItem(container, position, object);
    }

    @NotNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case Fragment3.PAGE_ONE:
                fragment = myFragment1;
                break;
            case Fragment3.PAGE_TWO:
                fragment = myFragment2;
                break;
        }
        return fragment;
    }
}
