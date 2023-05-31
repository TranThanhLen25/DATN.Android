package com.example.datnandroidquanlynhahangkhachsan.ui.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.datnandroidquanlynhahangkhachsan.R;
import com.example.datnandroidquanlynhahangkhachsan.databinding.ActivityDanhsachmenuBinding;
import com.google.android.material.tabs.TabLayout;

public class DanhSachMenuActivity extends AppCompatActivity {

    ActivityDanhsachmenuBinding danhsachmenuBinding;
    Fragment fragment = null;
    FragmentMenuPagerAdapter viewPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        danhsachmenuBinding = ActivityDanhsachmenuBinding.inflate(getLayoutInflater());
        setContentView(danhsachmenuBinding.getRoot());
        danhsachmenuBinding.incluMenu.icBack.setOnClickListener(view -> onBackPressed());
        setupViewPager();
    }

    private void setupViewPager() {
        int tabCount = 3;

        viewPageAdapter = new FragmentMenuPagerAdapter(this, getSupportFragmentManager());
        danhsachmenuBinding.viewPager.setOffscreenPageLimit(tabCount);

        viewPageAdapter.addFragment(new fragment_menu_dichvu(),
                getResources().getString(R.string.fragment_menu_page1_title), 0);

        viewPageAdapter.addFragment(new fragment_menu_goimon(),
                getResources().getString(R.string.fragment_menu_page2_title), 1);

        viewPageAdapter.addFragment(new fragment_menu_douong(),
                getResources().getString(R.string.fragment_menu_page3_title), 2);


        danhsachmenuBinding.viewPager.setAdapter(viewPageAdapter);
        danhsachmenuBinding.tabLayout.setupWithViewPager(danhsachmenuBinding.viewPager);
        danhsachmenuBinding.viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(danhsachmenuBinding.tabLayout));
    }
}