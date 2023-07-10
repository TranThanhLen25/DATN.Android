package com.example.datnandroidquanlynhahangkhachsan.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.Activity_Chitiet_PhieuThu;
import com.example.datnandroidquanlynhahangkhachsan.Fragment_PhieuThu;
import com.example.datnandroidquanlynhahangkhachsan.Fragment_nhanVien;
import com.example.datnandroidquanlynhahangkhachsan.databinding.ItemPhieuDatBanBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.PhieuThuDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.PhieuThuDTO;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class PhieuThuAdapter extends RecyclerView.Adapter<PhieuThuAdapter.PhieuThuViewHolder> {
    private List<PhieuThuDTO>lsPhieuThu;


    private Context context;

    public PhieuThuAdapter(Fragment_PhieuThu fragment_phieuThu) {
    }


    public void setData(Context context, List<PhieuThuDTO> lsPhieuThu) {
        this.context = context;
        this.lsPhieuThu = lsPhieuThu;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public PhieuThuAdapter.PhieuThuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPhieuDatBanBinding itemPhieuDatBanBinding = ItemPhieuDatBanBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PhieuThuAdapter.PhieuThuViewHolder(itemPhieuDatBanBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PhieuThuAdapter.PhieuThuViewHolder holder, int position) {
        PhieuThuDTO PhieuThu = lsPhieuThu.get(position);
        if (PhieuThu == null) {
            return;
        }
        DecimalFormat decimalFormat=new DecimalFormat("#,##0"+" đồng");
        SimpleDateFormat dateFormat=new SimpleDateFormat("HH:mm-dd/MM/yyyy");
        holder.itemPhieuDatBanBinding.tvTenkhachhangPhieudatbanData.setText(String.valueOf(dateFormat.format(PhieuThu.getNgayLap())) );

        holder.itemPhieuDatBanBinding.tvSdtItemphieudatbanData.setText(String.valueOf(decimalFormat.format(PhieuThu.getSoTienCanThanhToan()) ));
        holder.itemPhieuDatBanBinding.tvSdtItemphieudatbanData.setTextColor(Color.BLUE);
        holder.itemPhieuDatBanBinding.tvThoigianlapphieuItemphieudatban.setText("Ghi chú: ");

        holder.itemPhieuDatBanBinding.tvThoigianlapphieuItemphieudatbanData.setText(PhieuThu.getGhiChu());



        holder.itemPhieuDatBanBinding.tvSochungtuPhieudatbanData.setText(PhieuThu.getSoChungTu());

        holder.itemPhieuDatBanBinding.tvBanItemphieudatbanData.setVisibility(View.GONE);
        holder.itemPhieuDatBanBinding.itemPhieudatban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences= context.getSharedPreferences("TT_PHIEUTHU",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("SCT",PhieuThu.getSoChungTu());
                editor.putString("NGAY",dateFormat.format(PhieuThu.getNgayLap()));
                editor.putString("TIENNHAN",String.valueOf(decimalFormat.format(PhieuThu.getSoTienCanThanhToan())));
                editor.putString("DUA",String.valueOf(decimalFormat.format(PhieuThu.getSoTienKhachDua())));
                editor.putString("THOI",String.valueOf(decimalFormat.format(PhieuThu.getSoTienTraLaiKhach())));
                editor.putString("GHICHU",PhieuThu.getGhiChu());
                editor.putString("PT",PhieuThu.getPhuongThucThanhToan());
                editor.commit();
                Intent intent=new Intent(context, Activity_Chitiet_PhieuThu.class);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        if (lsPhieuThu != null) {
            return lsPhieuThu.size();
        }
        return 0;
    }

    public class PhieuThuViewHolder extends RecyclerView.ViewHolder {
        private ItemPhieuDatBanBinding itemPhieuDatBanBinding;

        public PhieuThuViewHolder(@NonNull ItemPhieuDatBanBinding itemView) {
            super(itemView.getRoot());
            this.itemPhieuDatBanBinding = itemView;
        }
    }

}
