package com.example.datnandroidquanlynhahangkhachsan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.Fragment_dsLichSu;
import com.example.datnandroidquanlynhahangkhachsan.databinding.ItemPhieudatphongBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.KhachHangDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.LoaiPhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.PhieuXuatDTO;
import com.example.datnandroidquanlynhahangkhachsan.utils.AppUtils;

import java.util.List;

public class PhieuXuatAdapter extends RecyclerView.Adapter<PhieuXuatAdapter.PhieuXuatViewHolder> {

    private List<PhieuXuatDTO> phieuXuat;
    private List<LoaiPhongDTO> loaiPhong;
    private List<KhachHangDTO> khachHang;
    private Context context;
    private AppUtils ac;
    private ItemPhieudatphongBinding phieuxuatBinding;

    public PhieuXuatAdapter(List<PhieuXuatDTO> phieuXuat) {
        this.phieuXuat = phieuXuat;

    }

    public PhieuXuatAdapter(Fragment_dsLichSu fragment_dsLichSu) {

    }

    public void setData(List<PhieuXuatDTO> phieuXuat, Context context) {

        this.context = context;
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

        holder.phieuxuatBinding.tvSochungtuPhieudatphongData.setText(px.getSoChungTu());
        holder.phieuxuatBinding.tvThoigianlapphieuItemphieudatphongData.setText(AppUtils.formatDateToString(px.getNgayLap(), "dd/MM/yyyy HH:mm:ss"));
        holder.phieuxuatBinding.tvPhongItemphieudatphongData.setText(String.valueOf(px.getTongThanhTien()));
        for (int i = 0; i < khachHang.size(); i++) {
            if (px.getKhachHangId() == khachHang.get(i).getKhachHangId()) {
                holder.phieuxuatBinding.tvTenkhachhangPhieudatphongData.setText(khachHang.get(i).getTenKhachHang());
                holder.phieuxuatBinding.tvSdtItemphieudatphongData.setText(khachHang.get(i).getSdt());

            }
        }



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
