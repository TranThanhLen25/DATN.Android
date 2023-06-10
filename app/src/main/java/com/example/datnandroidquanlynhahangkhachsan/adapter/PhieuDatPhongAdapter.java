package com.example.datnandroidquanlynhahangkhachsan.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.PhieuDatPhongChiTietActivity;
import com.example.datnandroidquanlynhahangkhachsan.databinding.ItemPhieudatphongBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.KhachHangDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.MutilTable.DatPhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.PhieuDatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.PhieuDatPhongChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.tempData.tempData;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieudat.DsPhieuDatPhongContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieudat.DsPhieuDatPhongPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieudat.Fragment_dsPhieuDatPhong;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieudat.ThemPhieuDatphongActivity;
import com.example.datnandroidquanlynhahangkhachsan.utils.AppUtils;

import java.util.List;

public class PhieuDatPhongAdapter extends RecyclerView.Adapter<PhieuDatPhongAdapter.PhieuDatPhongViewHolder> implements DsPhieuDatPhongContract.View {
    private List<PhieuDatDTO> lsPhieuDat;
    private AppUtils ac;
    private Context context;
    private DsPhieuDatPhongPresenter dsPhieuDatPhongPresenter = new DsPhieuDatPhongPresenter(this);
    private PhieuDatDTO phieuDatDTO;
    private List<KhachHangDTO> lsKhachHang;
    private KhachHangDTO khachHangDTO;


    public PhieuDatPhongAdapter(List<PhieuDatDTO> lsPhieuDat) {
        this.lsPhieuDat = lsPhieuDat;
    }

    public PhieuDatPhongAdapter(Fragment_dsPhieuDatPhong fragment_dsPhieuDatPhong) {
    }

    public PhieuDatPhongAdapter(ThemPhieuDatphongActivity themPhieuDatphongActivity) {
    }

    public void setData(Context context, List<PhieuDatDTO> lsPhieuDat, List<KhachHangDTO> lsKhachHang) {
        this.lsPhieuDat = lsPhieuDat;
        this.context = context;
        this.lsKhachHang = lsKhachHang;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PhieuDatPhongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ItemPhieudatphongBinding phieudatphongBinding = ItemPhieudatphongBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new PhieuDatPhongViewHolder(phieudatphongBinding);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull PhieuDatPhongViewHolder holder, int position) {
        PhieuDatDTO PhieuDat = lsPhieuDat.get((position));
        if (lsKhachHang.size() > 0) {
            for (int i = 0; i < lsKhachHang.size(); i++) {
                if (lsKhachHang.get(i).getKhachHangId() == PhieuDat.getKhachHangID()) {
                    khachHangDTO = lsKhachHang.get(i);
                }
            }
        }

        if (PhieuDat == null) {
            return;
        }
        if (khachHangDTO != null) {
            holder.phieudatphongBinding.tvTenkhachhangPhieudatphongData.setText(String.valueOf(khachHangDTO.getTenKhachHang()));
            holder.phieudatphongBinding.tvSdtItemphieudatphongData.setText(String.valueOf(khachHangDTO.getSdt()));
        }
        holder.phieudatphongBinding.tvSochungtuPhieudatphongData.setText(PhieuDat.getSoChungTu());
        holder.phieudatphongBinding.tvThoigianlapphieuItemphieudatphongData.setText(ac.formatDateToString(PhieuDat.getNgayLap(), "dd/MM/yyyy HH:mm:ss"));
        holder.phieudatphongBinding.tvPhongItemphieudatphongData.setText(String.valueOf(PhieuDat.getKhachHangID()));
        holder.phieudatphongBinding.itemPhieudatphong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PhieuDatPhongChiTietActivity.class);
                dsPhieuDatPhongPresenter.LayPhieuDatPhongChiTiet(PhieuDat);
                phieuDatDTO = PhieuDat;
                tempData.tempDatakhachHangDTO = khachHangDTO;
                if (tempData.datPhongDTO != null) {
                    //  do {
                    dsPhieuDatPhongPresenter.LayPhieuDatPhongChiTiet(PhieuDat);
                    phieuDatDTO = PhieuDat;
                    // } while (tempData.datPhongDTO != null && tempData.tempDatakhachHangDTO != null);
                }
                if (tempData.tempDatakhachHangDTO != null) {
                    tempData.tempDatakhachHangDTO = khachHangDTO;
                }
                try {
                    Thread.sleep(400);
                    context.startActivity(intent);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        if ((lsPhieuDat != null)) {
            return lsPhieuDat.size();
        }
        return 0;
    }

    @Override
    public void onLayDanhSachPhieuDatSuccess(List<PhieuDatDTO> list) {

    }

    @Override
    public void onLayDanhSachPhieuDatError(String error) {

    }

    @Override
    public void onThemPhieuDatPhongSuccess() {

    }

    @Override
    public void onThemPhieuDatPhongError(String error) {

    }

    @Override
    public void onThemPhieuDatPhongChiTietSuccess() {

    }

    @Override
    public void onThemPhieuDatPhongChiTietError(String error) {

    }

    @Override
    public void onLayPhieuDatPhongChiTietSuccess(List<PhieuDatPhongChiTietDTO> phieuDatPhongChiTietDTOList) {
        tempData.datPhongDTO = new DatPhongDTO(phieuDatDTO, phieuDatPhongChiTietDTOList);
        tempData.Check = true;
    }


    @Override
    public void onLayPhieuDatPhongChiTietError(String error) {

    }

    class PhieuDatPhongViewHolder extends RecyclerView.ViewHolder {
        private ItemPhieudatphongBinding phieudatphongBinding;


        public PhieuDatPhongViewHolder(@NonNull ItemPhieudatphongBinding itemView) {
            super(itemView.getRoot());
            this.phieudatphongBinding = itemView;

        }
    }
}
