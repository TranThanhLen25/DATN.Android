package com.example.datnandroidquanlynhahangkhachsan.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.Fragment_danhSachPhieuNhanBan;
import com.example.datnandroidquanlynhahangkhachsan.databinding.ItemPhieunhanphongBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.KhachHangDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanDTO;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieuxuat.PhieuXuatBanActivity;
import com.example.datnandroidquanlynhahangkhachsan.utils.AppUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PhieuNhanBanAdapter extends RecyclerView.Adapter<PhieuNhanBanAdapter.PhieuNhanBanViewHolder> {

    private List<PhieuNhanDTO> lsPhieuNhan;
    private List<KhachHangDTO> lsKhachHang;
    private AppUtils ac;
    private KhachHangDTO khachHangDTO;
    private Context context;

    public PhieuNhanBanAdapter(List<PhieuNhanDTO> lsPhieuNhan) {

        this.lsPhieuNhan = lsPhieuNhan;
    }

    public PhieuNhanBanAdapter(Fragment_danhSachPhieuNhanBan fragment_danhSachPhieuNhanBan) {
    }

    public void setData(List<PhieuNhanDTO> lsPhieuNhan, List<KhachHangDTO> lsKhachHang, Context context) {
        this.lsPhieuNhan = lsPhieuNhan;
        this.lsKhachHang = lsKhachHang;
        this.context = context;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PhieuNhanBanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPhieunhanphongBinding phieunhanphongBinding = ItemPhieunhanphongBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PhieuNhanBanViewHolder(phieunhanphongBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PhieuNhanBanViewHolder holder, int position) {
        PhieuNhanDTO phieuNhanDTO = lsPhieuNhan.get(position);
        if (lsKhachHang.size() > 0) {
            for (int i = 0; i < lsKhachHang.size(); i++) {
                if (lsKhachHang.get(i).getKhachHangId() == phieuNhanDTO.getKhachHangId()) {
                    khachHangDTO = lsKhachHang.get(i);
                }
            }
        }
        if (phieuNhanDTO == null) {
            return;
        }
        if (khachHangDTO == null) {
            return;
        }
        holder.phieunhanphongBinding.tvTenkhachhangPhieunhanphongData.setText(khachHangDTO.getTenKhachHang());
        holder.phieunhanphongBinding.tvSdtItemphieunhanphongData.setText(khachHangDTO.getSdt());

        holder.phieunhanphongBinding.tvSochungtuPhieunhanphongData.setText(String.valueOf(phieuNhanDTO.getSoChungTu()));
        holder.phieunhanphongBinding.tvThoigianlapphieuItemphieunhanphongData.setText(ac.formatDateToString(phieuNhanDTO.getNgayLap(), "dd/MM/yyyy HH:mm:ss"));
        holder.phieunhanphongBinding.tvPhongItemphieunhanphongData.setText(phieuNhanDTO.getSoChungTu());
        holder.phieunhanphongBinding.itemPhieuNhanPhong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences= context.getSharedPreferences("GET_PHONGID",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();

                SharedPreferences sharedPreferences1= context.getSharedPreferences("GET_BANID",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor1=sharedPreferences1.edit();

                for (int i = 0; i < lsKhachHang.size(); i++) {
                    if (phieuNhanDTO.getKhachHangId() == lsKhachHang.get(i).getKhachHangId()) {
                        editor.putString("TEN",lsKhachHang.get(i).getTenKhachHang());
                        editor.putString("CCCD",lsKhachHang.get(i).getCccd());
                        editor.putString("SDT",lsKhachHang.get(i).getSdt());
                        editor.putLong("KHID",lsKhachHang.get(i).getKhachHangId());
                        /// su cho ban

                        editor1.putString("TEN",lsKhachHang.get(i).getTenKhachHang());
                        editor1.putString("CCCD",lsKhachHang.get(i).getCccd());
                        editor1.putString("SDT",lsKhachHang.get(i).getSdt());
                        editor1.putLong("KHID",lsKhachHang.get(i).getKhachHangId());
                    }
                }

                DateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
                Date ngay=phieuNhanDTO.getNgayLap();

                editor.putString("SCT",phieuNhanDTO.getSoChungTu());
                editor.putString("NGAYLAP",String.valueOf(dateFormat.format(ngay)) );
                editor.putLong("PNID", phieuNhanDTO.getPhieuNhanId());
                editor.putInt("NGUOIDUNG",phieuNhanDTO.getNguoiDungId());
                editor.commit();
                /// sử dụng cho bàn

                editor1.putString("SCT",phieuNhanDTO.getSoChungTu());
                editor1.putString("NGAYLAP",String.valueOf(dateFormat.format(ngay)) );
                editor1.putLong("PNID", phieuNhanDTO.getPhieuNhanId());
                editor1.putInt("NGUOIDUNG",phieuNhanDTO.getNguoiDungId());
                editor1.commit();



                Intent intent=new Intent(context, PhieuXuatBanActivity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        if ((lsPhieuNhan != null)) {
            return lsPhieuNhan.size();
        }
        return 0;
    }

    class PhieuNhanBanViewHolder extends RecyclerView.ViewHolder {
        private ItemPhieunhanphongBinding phieunhanphongBinding;

        public PhieuNhanBanViewHolder(@NonNull ItemPhieunhanphongBinding itemView) {
            super(itemView.getRoot());
            this.phieunhanphongBinding = itemView;
        }
    }
}
