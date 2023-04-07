package com.example.datnandroidquanlynhahangkhachsan.ui.fragmentPhong;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;


import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;


import com.example.datnandroidquanlynhahangkhachsan.Fragment_dsPhong;
import com.example.datnandroidquanlynhahangkhachsan.R;


import com.example.datnandroidquanlynhahangkhachsan.databinding.ItemChonphongBinding;
import com.example.datnandroidquanlynhahangkhachsan.databinding.ItemDanhsachphongBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.LoaiPhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.PhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.ui.ChiTietPhongActivity;
import com.example.datnandroidquanlynhahangkhachsan.ui.ThemPhieuDoiPhongActivity;
import com.example.datnandroidquanlynhahangkhachsan.ui.ThemPhieuTraPhongActivity;
import com.example.datnandroidquanlynhahangkhachsan.ui.chonphong.LoaiPhongContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieudat.ThemPhieuDatphongActivity;
import com.example.datnandroidquanlynhahangkhachsan.ui.ThemPhieuNhanPhongActivity;

import java.util.ArrayList;
import java.util.List;


public class DsPhongAdapter extends RecyclerView.Adapter<DsPhongAdapter.PhongViewHolder> {
    private List<PhongDTO> lsPhong;

    private Context context;
    private List<LoaiPhongDTO> lsLoaiPhong;
    Fragment fragment = null;

    public DsPhongAdapter(List<PhongDTO> lsPhong) {
        this.lsPhong = lsPhong;
       // this.lsLoaiPhong=lsLoaiPhong;

    }

    public DsPhongAdapter(Fragment_dsPhong fragment_dsPhong) {

    }

    public void setData(List<PhongDTO> lsPhong, Context context) {
        this.lsPhong = lsPhong;
        this.context = context;
      //  this.lsLoaiPhong=lsLoaiPhong;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PhongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //hiện dialog

        ItemDanhsachphongBinding itemDanhsachphongBinding = ItemDanhsachphongBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        itemDanhsachphongBinding.itemDsphong.setOnClickListener(new View.OnClickListener() {
            @Override
            ///gọi dialog
            public void onClick(View view) {
                openDialog();
            }
        });


        return new PhongViewHolder(itemDanhsachphongBinding);
    }


    @Override
    public void onBindViewHolder(@NonNull PhongViewHolder holder, int position) {
        PhongDTO phong = lsPhong.get((position));
      //  LoaiPhongDTO loaiPhong=lsLoaiPhong.get(position);
        if (phong == null ) {
            return;
        }

        holder.itemDanhsachphongBinding.tvSophong.setText(String.valueOf(phong.getSoPhong()));
        holder.itemDanhsachphongBinding.tvGiatien.setText(String.valueOf(phong.getLoaiPhongId()));
        holder.itemDanhsachphongBinding.tvLoaiphong.setText(String.valueOf(phong.getLoaiPhongId()));


    }

    @Override
    public int getItemCount() {
        if ((lsPhong != null )) {
            return lsPhong.size();

        }
        return 0;
    }





    class PhongViewHolder extends RecyclerView.ViewHolder {

        private ItemDanhsachphongBinding itemDanhsachphongBinding;
        private ItemChonphongBinding chonphongBinding;

        public PhongViewHolder(@NonNull ItemDanhsachphongBinding dsPhong) {


            super(dsPhong.getRoot());
            this.itemDanhsachphongBinding = dsPhong;


        }
    }


    /// tạo dialog chức năng
    private void openDialog() {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.fragment_dialog);
        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }
        window.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        TextView nhanphong = dialog.findViewById(R.id.tv_dia_nhanphong);
        TextView datphong = dialog.findViewById(R.id.tv_dia_datphong);
        TextView traphong = dialog.findViewById(R.id.tv_dia_traphong);
        TextView chitiet = dialog.findViewById(R.id.tv_dia_chitietphong);
        TextView doiphong = dialog.findViewById(R.id.tv_dia_doiphong);
        TextView baotri = dialog.findViewById(R.id.tv_dia_baotri);

        // sự kiện khi nhấn vào text trong dialog
        nhanphong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(dialog.getContext(), ThemPhieuNhanPhongActivity.class);
                context.startActivity(intent);

                dialog.dismiss();

            }
        });
        datphong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(dialog.getContext(), ThemPhieuDatphongActivity.class);
                context.startActivity(intent);

                dialog.dismiss();

            }
        });
        chitiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(dialog.getContext(), ChiTietPhongActivity.class);
                context.startActivity(intent);

                dialog.dismiss();

            }
        });

        traphong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(dialog.getContext(), ThemPhieuTraPhongActivity.class);
                context.startActivity(intent);

                dialog.dismiss();

            }
        });
        doiphong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(dialog.getContext(), ThemPhieuDoiPhongActivity.class);
                context.startActivity(intent);

                dialog.dismiss();

            }
        });
        baotri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                dialog.dismiss();

            }
        });
        dialog.show();


    }


}

