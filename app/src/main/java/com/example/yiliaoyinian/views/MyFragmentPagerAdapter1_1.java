//package com.example.yiliaoyinian.views;
//
//
//import android.view.ViewGroup;
//
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentManager;
//import androidx.fragment.app.FragmentPagerAdapter;
//import com.example.yiliaoyinian.Beans.SaveInfoBean;
//import com.example.yiliaoyinian.MyApplication;
//import com.example.yiliaoyinian.ui.fragmengmain.Fragment1;
//import com.example.yiliaoyinian.ui.fragments1.fuwu.Fragment1_1;
//import com.example.yiliaoyinian.ui.fragments1.huanzhe.Fragment1_2;
//import org.jetbrains.annotations.NotNull;
//
//public class MyFragmentPagerAdapter1_1 extends FragmentPagerAdapter {
//
//    public Fragment1_1 myFragment1 = null;
//    public Fragment1_2 myFragment2 = null;
//
//    private SaveInfoBean saveInfoBean=null;
//
//    public MyFragmentPagerAdapter1_1(FragmentManager fragmentManager) {
//        super(fragmentManager,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
//        myFragment1 = new Fragment1_1();
//        myFragment2 = new Fragment1_2();
//        saveInfoBean= MyApplication.myApplication.getSaveInfoBeanBox().get(123456);
//    }
//
//    @Override
//    public int getCount() {
//        return 2;
//    }
//
//    @NotNull
//    @Override
//    public Object instantiateItem(@NotNull ViewGroup container, int position) {
//        return super.instantiateItem(container, position);
//    }
//
//    @Override
//    public void destroyItem(@NotNull ViewGroup container, int position, @NotNull Object object) {
//        super.destroyItem(container, position, object);
//    }
//
//    @NotNull
//    @Override
//    public Fragment getItem(int position) {
//        Fragment fragment = null;
//        switch (position) {
//            case Fragment1.PAGE_ONE:
//                fragment = myFragment1;
//                break;
//            case Fragment1.PAGE_TWO:
//                fragment = myFragment2;
//                break;
//        }
//        return fragment;
//    }
//}
//
