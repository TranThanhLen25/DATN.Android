package com.example.datnandroidquanlynhahangkhachsan.adapter;

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
import com.example.datnandroidquanlynhahangkhachsan.ui.phieunhan.Fragment_dsPhieuNhanPhong;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieunhan.PhieuNhanPhongChiTietActivity;
import com.example.datnandroidquanlynhahangkhachsan.utils.AppUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class PhieuNhanPhongAdapter extends RecyclerView.Adapter<PhieuNhanPhongAdapter.PhieuNhanPhongViewHolder> {
    private List<PhieuNhanDTO> lsPhieuNhan;
    private List<KhachHangDTO> lsKhachHang;
    private AppUtils ac;

    private ItemPhieunhanphongBinding phieunhanphongBinding;
    private Context context;

    public PhieuNhanPhongAdapter(List<PhieuNhanDTO> lsPhieuNhan) {

        this.lsPhieuNhan = lsPhieuNhan;
    }

    public PhieuNhanPhongAdapter(Fragment_dsPhieuNhanPhong fragment_dsPhieuNhanPhong) {
    }

    public void setData(List<PhieuNhanDTO> lsPhieuNhan, List<KhachHangDTO> lsKhachHang, Context context) {
        this.lsPhieuNhan = lsPhieuNhan;
        this.lsKhachHang = lsKhachHang;
        this.context=context;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PhieuNhanPhongAdapter.PhieuNhanPhongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        phieunhanphongBinding = ItemPhieunhanphongBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PhieuNhanPhongViewHolder(phieunhanphongBinding);
    }


    @Override
    public void onBindViewHolder(@NonNull PhieuNhanPhongAdapter.PhieuNhanPhongViewHolder holder, int position) {
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
        holder.phieunhanphongBinding.tvThoigianlapphieuItemphieunhanphongData.setText(ac.formatDateToString(phieuNhanDTO.getNgayLap(),"dd/MM/yyyy HH:mm:ss"));
        holder.phieunhanphongBinding.tvPhongItemphieunhanphongData.setText(phieuNhanDTO.getSoChungTu());
        phieunhanphongBinding.itemPhieuNhanPhong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences= context.getSharedPreferences("PHIEUNHAN",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                for (int i = 0; i < lsKhachHang.size(); i++) {
                    if (phieuNhanDTO.getKhachHangId() == lsKhachHang.get(i).getKhachHangId()) {
                       editor.putString("TEN",lsKhachHang.get(i).getTenKhachHang());
                        editor.putString("CCCD",lsKhachHang.get(i).getCccd());
                        editor.putString("SDT",lsKhachHang.get(i).getSdt());
                    }
                }
                editor.putString("SCT",phieuNhanDTO.getSoChungTu());
                DateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
                Date ngay=phieuNhanDTO.getNgayLap();
                editor.putString("NGAY",String.valueOf(dateFormat.format(ngay)) );
                editor.putLong("PNID", phieuNhanDTO.getPhieuNhanId());
                editor.commit();

                Intent intent=new Intent(context, PhieuNhanPhongChiTietActivity.class);
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
        private final ItemPhieunhanphongBinding phieunhanphongBinding;
        public PhieuNhanPhongViewHolder(@NonNull ItemPhieunhanphongBinding itemView) {

            super(itemView.getRoot());
      this.phieunhanphongBinding=itemView;
        }
    }
}
