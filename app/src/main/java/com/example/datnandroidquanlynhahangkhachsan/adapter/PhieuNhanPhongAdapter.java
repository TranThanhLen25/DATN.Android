package com.example.datnandroidquanlynhahangkhachsan.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.databinding.ItemPhieunhanphongBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.KhachHangDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.PhieuXuatDTO;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieunhan.Fragment_dsPhieuNhanPhong;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieuxuat.PhieuXuatActivity;
import com.example.datnandroidquanlynhahangkhachsan.utils.AppUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PhieuNhanPhongAdapter extends RecyclerView.Adapter<PhieuNhanPhongAdapter.PhieuNhanPhongViewHolder> {
    private List<PhieuNhanDTO> lsPhieuNhan;
    private List<KhachHangDTO> lsKhachHang;

    private List<PhieuXuatDTO> lsPhieuXuat;
    private AppUtils ac;
    private Context context;

    public PhieuNhanPhongAdapter(List<PhieuNhanDTO> lsPhieuNhan) {

        this.lsPhieuNhan = lsPhieuNhan;
    }

    public PhieuNhanPhongAdapter(Fragment_dsPhieuNhanPhong fragment_dsPhieuNhanPhong) {
    }

    public void setData(List<PhieuXuatDTO> lsPhieuXuat, List<PhieuNhanDTO> lsPhieuNhan, List<KhachHangDTO> lsKhachHang, Context context) {
      this.lsPhieuXuat=lsPhieuXuat;
        this.lsPhieuNhan = lsPhieuNhan;
        this.lsKhachHang = lsKhachHang;
        this.context = context;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PhieuNhanPhongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPhieunhanphongBinding phieunhanphongBinding = ItemPhieunhanphongBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PhieuNhanPhongViewHolder(phieunhanphongBinding);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull PhieuNhanPhongViewHolder holder, int position) {
        PhieuNhanDTO phieuNhanDTO = lsPhieuNhan.get(position);
        if (phieuNhanDTO == null) {
            return;
        }
        for (int i = 0; i < lsKhachHang.size(); i++) {
            if (phieuNhanDTO.getKhachHangId() == lsKhachHang.get(i).getKhachHangId()) {
                holder.phieunhanphongBinding.tvTenkhachhangPhieunhanphongData.setText(lsKhachHang.get(i).getTenKhachHang());
                holder.phieunhanphongBinding.tvSdtItemphieunhanphongData.setText(lsKhachHang.get(i).getSdt());
            }
        }

        holder.phieunhanphongBinding.tvSochungtuPhieunhanphongData.setText(String.valueOf(phieuNhanDTO.getSoChungTu()));
        holder.phieunhanphongBinding.tvThoigianlapphieuItemphieunhanphongData.setText(ac.formatDateToString(phieuNhanDTO.getNgayLap(), "dd/MM/yyyy HH:mm:ss"));
        holder.phieunhanphongBinding.tvPhongItemphieunhanphongData.setText(phieuNhanDTO.getSoChungTu());
        holder.phieunhanphongBinding.itemPhieuNhanPhong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences= context.getSharedPreferences("GET_PHONGID",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                for (int i = 0; i < lsKhachHang.size(); i++) {
                    if (phieuNhanDTO.getKhachHangId() == lsKhachHang.get(i).getKhachHangId()) {
                        editor.putString("TEN",lsKhachHang.get(i).getTenKhachHang());
                        editor.putString("CCCD",lsKhachHang.get(i).getCccd());
                        editor.putString("SDT",lsKhachHang.get(i).getSdt());
                        editor.putLong("KHID",lsKhachHang.get(i).getKhachHangId());
                    }
                }
//                for (int i=0;i<lsPhieuXuat.size();i++)
//                {
//                    if (lsPhieuXuat.get(i).getPhieuNhanId()== phieuNhanDTO.getPhieuNhanId())
//                    {
//                        editor.putLong("PXID",lsPhieuXuat.get(i).getPhieuXuatId());
//                    }
//                }
                editor.putString("SCT",phieuNhanDTO.getSoChungTu());
                DateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
                Date ngay=phieuNhanDTO.getNgayLap();
                editor.putString("NGAYLAP",String.valueOf(dateFormat.format(ngay)) );
                editor.putLong("PNID", phieuNhanDTO.getPhieuNhanId());
                editor.putInt("NGUOIDUNG",phieuNhanDTO.getNguoiDungId());
                editor.commit();
                Intent intent=new Intent(context, PhieuXuatActivity.class);
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

    class PhieuNhanPhongViewHolder extends RecyclerView.ViewHolder {
        private ItemPhieunhanphongBinding phieunhanphongBinding;

        public PhieuNhanPhongViewHolder(@NonNull ItemPhieunhanphongBinding itemView) {

            super(itemView.getRoot());
            this.phieunhanphongBinding = itemView;
        }
    }
}
