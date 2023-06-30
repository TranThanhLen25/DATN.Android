package com.example.datnandroidquanlynhahangkhachsan.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.datnandroidquanlynhahangkhachsan.Activity_ChiTiet_NhanVien;
import com.example.datnandroidquanlynhahangkhachsan.Fragment_nhanVien;
import com.example.datnandroidquanlynhahangkhachsan.databinding.ItemPhieuDatBanBinding;

import com.example.datnandroidquanlynhahangkhachsan.entities.NguoiDungDTO;
import com.example.datnandroidquanlynhahangkhachsan.tempData.tempData;
import com.example.datnandroidquanlynhahangkhachsan.utils.AppUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class NguoiDungAdapter extends RecyclerView.Adapter<NguoiDungAdapter.NguoiDungViewHolder> {
    
    private List<NguoiDungDTO> lsNguoiDung;
    private Context context;

    public NguoiDungAdapter(Fragment_nhanVien fragment_nhanVien) {
    }


    public void setData(Context context, List<NguoiDungDTO> lsNguoiDung) {
        this.context = context;
        this.lsNguoiDung = lsNguoiDung;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public NguoiDungAdapter.NguoiDungViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPhieuDatBanBinding itemPhieuDatBanBinding = ItemPhieuDatBanBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new NguoiDungAdapter.NguoiDungViewHolder(itemPhieuDatBanBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull NguoiDungAdapter.NguoiDungViewHolder holder, int position) {
        NguoiDungDTO nguoiDung = lsNguoiDung.get(position);
        if (nguoiDung == null) {
            return;
        }
        holder.itemPhieuDatBanBinding.tvTenkhachhangPhieudatbanData.setText(nguoiDung.getTenNguoiDung());
        holder.itemPhieuDatBanBinding.tvSdtItemphieudatbanData.setText(nguoiDung.getSdt());
        holder.itemPhieuDatBanBinding.tvThoigianlapphieuItemphieudatbanData.setText(nguoiDung.getDiaChi());
        holder.itemPhieuDatBanBinding.tvThoigianlapphieuItemphieudatban.setText("Địa chỉ: ");
        holder.itemPhieuDatBanBinding.tvSochungtuPhieudatbanData.setText(nguoiDung.getCccd());
        holder.itemPhieuDatBanBinding.tvBanItemphieudatbanData.setText(nguoiDung.getTaiKhoan());

        holder.itemPhieuDatBanBinding.itemPhieudatban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences= context.getSharedPreferences("TT_NHANVIEN",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                DateFormat format=new SimpleDateFormat("dd/MM/yyyy");
                editor.putString("TEN", nguoiDung.getTenNguoiDung());
                editor.putString("SDT", nguoiDung.getSdt());
                editor.putString("CCCD", nguoiDung.getCccd());
                editor.putString("GT", nguoiDung.getGioiTinh());
                editor.putString("DC", nguoiDung.getDiaChi());
                editor.putString("CV", nguoiDung.getLoaiTaiKhoan());
                editor.putString("TK",nguoiDung.getTaiKhoan());
                if(nguoiDung.getLoaiTaiKhoan().toString().equals("Quản lý"))
                {
                    editor.putString("MK","Không được phép xem");
                }
                else
                {
                    editor.putString("MK",nguoiDung.getMatKhau());
                }

                editor.commit();
                Intent intent=new Intent(context, Activity_ChiTiet_NhanVien.class);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        if (lsNguoiDung != null) {
            return lsNguoiDung.size();
        }
        return 0;
    }

    public class NguoiDungViewHolder extends RecyclerView.ViewHolder {
        private ItemPhieuDatBanBinding itemPhieuDatBanBinding;

        public NguoiDungViewHolder(@NonNull ItemPhieuDatBanBinding itemView) {
            super(itemView.getRoot());
            this.itemPhieuDatBanBinding = itemView;
        }
    }
}
