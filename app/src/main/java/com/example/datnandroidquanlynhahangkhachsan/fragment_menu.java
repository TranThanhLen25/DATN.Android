package com.example.datnandroidquanlynhahangkhachsan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;


import com.example.datnandroidquanlynhahangkhachsan.ui.fragmentMenu.FragmentMenuPagerAdapter;
import com.example.datnandroidquanlynhahangkhachsan.ui.fragmentMenu.fragment_menu_dichvu;
import com.example.datnandroidquanlynhahangkhachsan.ui.fragmentMenu.fragment_menu_douong;
import com.example.datnandroidquanlynhahangkhachsan.ui.fragmentMenu.fragment_menu_goimon;

import com.example.datnandroidquanlynhahangkhachsan.databinding.FragmentMenuBinding;


import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_menu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_menu extends Fragment {

    TabLayout tabLayout;
    ViewPager viewPager;
    FragmentMenuPagerAdapter viewPageAdapter;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    FragmentMenuBinding menuBinding;

    public fragment_menu() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_menu.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_menu newInstance(String param1, String param2) {
        fragment_menu fragment = new fragment_menu();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_menu, container, false);
//        View btnView=view.findViewById(R.id.icl_appbackpdp_menu);
//        Button btn_back=btnView.findViewById(R.id.ic_back);
//        btn_back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                getActivity().onBackPressed();
//            }
//        });
        viewPager = view.findViewById(R.id.viewPager);
        tabLayout = view.findViewById(R.id.tabLayout);

        menuBinding=FragmentMenuBinding.inflate(inflater,container,false);



        viewPager =menuBinding.viewPager;
        tabLayout =menuBinding.tabLayout;


        setupViewPager();
        return menuBinding.getRoot();
    }
    private void setupViewPager() {
        int tabCount = 3;

        viewPageAdapter = new FragmentMenuPagerAdapter(getContext(), getActivity().getSupportFragmentManager());
        viewPager.setOffscreenPageLimit(tabCount);

        viewPageAdapter.addFragment(new fragment_menu_dichvu(),
                getResources().getString(R.string.fragment_menu_page1_title), 0);

        viewPageAdapter.addFragment(new fragment_menu_goimon(),
                getResources().getString(R.string.fragment_menu_page2_title), 1);

        viewPageAdapter.addFragment(new fragment_menu_douong(),
                getResources().getString(R.string.fragment_menu_page3_title), 2);


        viewPager.setAdapter(viewPageAdapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}