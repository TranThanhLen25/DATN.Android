package com.example.datnandroidquanlynhahangkhachsan.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import androidx.annotation.NonNull;


import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.R;


import com.example.datnandroidquanlynhahangkhachsan.databinding.ItemDanhsachphongBinding;
import com.example.datnandroidquanlynhahangkhachsan.model.Phong;
import com.example.datnandroidquanlynhahangkhachsan.ui.ChiTietPhongActivity;
import com.example.datnandroidquanlynhahangkhachsan.ui.ThemPhieuDoiPhongActivity;
import com.example.datnandroidquanlynhahangkhachsan.ui.ThemPhieuTraPhongActivity;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieudat.ThemPhieuDatphongActivity;
import com.example.datnandroidquanlynhahangkhachsan.ui.ThemPhieuNhanPhongActivity;

import java.util.List;


public class DsPhongAdapter extends RecyclerView.Adapter<DsPhongAdapter.PhongViewHolder> {
    private List<Phong> lsPhong;
    private Context context;


    public DsPhongAdapter(List<Phong> lsPhong, Context context) {
        this.lsPhong = lsPhong;
        this.context = context;
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
        //        final Dialog mDialog = new Dialog(context);
//        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        mDialog.setContentView(R.layout.activity_dialog_chuc_nang_phong);
//        mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//
//        itemDanhsachphongBinding.itemDsphong.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mDialog.show();
//            }
//        });


        return new PhongViewHolder(itemDanhsachphongBinding);
    }


    @Override
    public void onBindViewHolder(@NonNull PhongViewHolder holder, int position) {
        Phong phong = lsPhong.get((position));
        if (phong == null) {
            return;
        }
        holder.itemDanhsachphongBinding.tvSophong.setText(String.valueOf(phong.getSoPhong()));
        holder.itemDanhsachphongBinding.tvGiaTien.setText(String.valueOf(phong.getLoaiPhongID()));
        holder.itemDanhsachphongBinding.tvGiuong.setText(String.valueOf(phong.getTang()));


    }

    @Override
    public int getItemCount() {
        if ((lsPhong != null)) {
            return lsPhong.size();
        }
        return 0;
    }

    class PhongViewHolder extends RecyclerView.ViewHolder {

        private final ItemDanhsachphongBinding itemDanhsachphongBinding;

        public PhongViewHolder(@NonNull ItemDanhsachphongBinding itemDanhsachphongBinding) {


            super(itemDanhsachphongBinding.getRoot());
            this.itemDanhsachphongBinding = itemDanhsachphongBinding;


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

