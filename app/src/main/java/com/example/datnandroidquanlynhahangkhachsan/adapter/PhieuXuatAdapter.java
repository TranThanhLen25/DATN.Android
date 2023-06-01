package com.example.datnandroidquanlynhahangkhachsan.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.Fragment_dsLichSu;
import com.example.datnandroidquanlynhahangkhachsan.databinding.ItemPhieudatphongBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.KhachHangDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.PhieuXuatDTO;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieuxuat.PhieuXuatActivity;
import com.example.datnandroidquanlynhahangkhachsan.utils.AppUtils;

import java.text.DecimalFormat;
import java.util.List;

public class PhieuXuatAdapter extends RecyclerView.Adapter<PhieuXuatAdapter.PhieuXuatViewHolder> {

    private List<PhieuXuatDTO> phieuXuat;

    private List<KhachHangDTO> khachHang;
    private Context context;
    private AppUtils ac;
    private ItemPhieudatphongBinding phieuxuatBinding;
    private String tenKH;
    private String sdt;
    private String cccd;
    private long pxID;
    private String sct;

    private String ngay;


    public PhieuXuatAdapter(List<PhieuXuatDTO> phieuXuat) {
        this.phieuXuat = phieuXuat;

    }

    public PhieuXuatAdapter(Fragment_dsLichSu fragment_dsLichSu) {

    }

    public void setData(List<PhieuXuatDTO> phieuXuat, List<KhachHangDTO> khachHang, Context context) {

        this.context = context;
        this.khachHang = khachHang;
        this.phieuXuat = phieuXuat;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PhieuXuatAdapter.PhieuXuatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        phieuxuatBinding = ItemPhieudatphongBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PhieuXuatViewHolder(phieuxuatBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PhieuXuatAdapter.PhieuXuatViewHolder holder, int position) {
        PhieuXuatDTO px = phieuXuat.get((position));
        if (px == null) {
            return;
        }
        DecimalFormat decimalFormat = new DecimalFormat("#,##0");
        holder.phieuxuatBinding.tvSochungtuPhieudatphongData.setText(px.getSoChungTu());
        holder.phieuxuatBinding.tvThoigianlapphieuItemphieudatphongData.setText(AppUtils.formatDateToString(px.getNgayLap(), "dd/MM/yyyy HH:mm"));
        holder.phieuxuatBinding.tvPhongItemphieudatphongData.setText(decimalFormat.format(px.getTongThanhTien()));

        ngay = AppUtils.formatDateToString(px.getNgayLap(), "dd/MM/yyyy HH:mm");
        sct = px.getSoChungTu();
        for (int i = 0; i < khachHang.size(); i++) {
            if (px.getKhachHangId() == khachHang.get(i).getKhachHangId()) {
                holder.phieuxuatBinding.tvTenkhachhangPhieudatphongData.setText(khachHang.get(i).getTenKhachHang());
                holder.phieuxuatBinding.tvSdtItemphieudatphongData.setText(khachHang.get(i).getSdt());


            }
        }

        phieuxuatBinding.itemPhieudatphong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PhieuXuatActivity.class);

                pxID = px.getPhieuXuatId();

                for (int i = 0; i < khachHang.size(); i++) {
                    if (px.getKhachHangId() == khachHang.get(i).getKhachHangId()) {
                        holder.phieuxuatBinding.tvTenkhachhangPhieudatphongData.setText(khachHang.get(i).getTenKhachHang());
                        holder.phieuxuatBinding.tvSdtItemphieudatphongData.setText(khachHang.get(i).getSdt());
                        tenKH = khachHang.get(i).getTenKhachHang();
                        sdt = khachHang.get(i).getSdt();
                        cccd = khachHang.get(i).getCccd();


                    }
                }



                SharedPreferences sharedPreferences = context.getSharedPreferences("PHIEUXUAT", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("TENKH", tenKH);
                editor.putString("SDT", sdt);
                editor.putString("CCCD", cccd);
                editor.putLong("PXID", pxID);
                editor.putLong("PNID",px.getPhieuNhanId());
                editor.putString("SCT", sct);
                editor.putString("NGAYLAP", ngay);
                //editor.putFloat("TONGTIEN",px.getTongThanhTien());
                editor.commit();
                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        if ((phieuXuat != null)) {
            return phieuXuat.size();
        }
        return 0;
    }

    class PhieuXuatViewHolder extends RecyclerView.ViewHolder {

        private final ItemPhieudatphongBinding phieuxuatBinding;

        public PhieuXuatViewHolder(@NonNull ItemPhieudatphongBinding phieuXuat) {


            super(phieuXuat.getRoot());
            this.phieuxuatBinding = phieuXuat;


        }
    }

}
