package com.example.datnandroidquanlynhahangkhachsan.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.Fragment_danhSachPhieuDatBan;
import com.example.datnandroidquanlynhahangkhachsan.PhieuDatBanChiTietActivity;
import com.example.datnandroidquanlynhahangkhachsan.databinding.ItemPhieuDatBanBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.KhachHangDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.MutilTable.DatBanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.PhieuDatBanChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.PhieuDatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.PhieuDatPhongChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.tempData.tempData;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieudat.DsPhieuDatPhongContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieudat.DsPhieuDatPhongPresenter;
import com.example.datnandroidquanlynhahangkhachsan.utils.AppUtils;

import java.util.List;

public class PhieuDatBanAdapter extends RecyclerView.Adapter<PhieuDatBanAdapter.PhieuDatBanViewHolder> implements DsPhieuDatPhongContract.View{

    private Context context;
    private List<KhachHangDTO> lsKhachHang;
    private List<PhieuDatDTO> lsPhieuDat;
    private KhachHangDTO khachHangDTO;
    private AppUtils ac;
    private DsPhieuDatPhongPresenter dsPhieuDatPhongPresenter = new DsPhieuDatPhongPresenter(this);
    private PhieuDatDTO phieuDatDTO;

    public PhieuDatBanAdapter(Fragment_danhSachPhieuDatBan fragment_danhSachPhieuDatBan) {
    }


    public void setData(Context context, List<PhieuDatDTO> lsPhieuDat, List<KhachHangDTO> lsKhachHang) {
        this.lsPhieuDat = lsPhieuDat;
        this.context = context;
        this.lsKhachHang = lsKhachHang;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public PhieuDatBanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPhieuDatBanBinding itemPhieuDatBanBinding = ItemPhieuDatBanBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PhieuDatBanViewHolder(itemPhieuDatBanBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PhieuDatBanViewHolder holder, int position) {
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
        if (khachHangDTO!=null){
            holder.itemPhieuDatBanBinding.tvTenkhachhangPhieudatbanData.setText(String.valueOf(khachHangDTO.getTenKhachHang()));
            holder.itemPhieuDatBanBinding.tvSdtItemphieudatbanData.setText(String.valueOf(khachHangDTO.getSdt()));
        }
        holder.itemPhieuDatBanBinding.tvSochungtuPhieudatbanData.setText(PhieuDat.getSoChungTu());
        holder.itemPhieuDatBanBinding.tvThoigianlapphieuItemphieudatbanData.setText(ac.formatDateToString(PhieuDat.getNgayLap(), "dd/MM/yyyy HH:mm:ss"));
        holder.itemPhieuDatBanBinding.tvBanItemphieudatbanData.setText(String.valueOf(PhieuDat.getKhachHangID()));

        holder.itemPhieuDatBanBinding.itemPhieudatban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PhieuDatBanChiTietActivity.class);
                dsPhieuDatPhongPresenter.LayPhieuDatBanChiTiet(PhieuDat);
                phieuDatDTO = PhieuDat;
                tempData.tempDatakhachHangDTO = khachHangDTO;
                if (tempData.datBanDTO != null) {
                    //  do {
                    dsPhieuDatPhongPresenter.LayPhieuDatBanChiTiet(PhieuDat);
                    phieuDatDTO = PhieuDat;
                    // } while (tempData.datBanDTO != null && tempData.tempDatakhachHangDTO != null);
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
        if (lsPhieuDat != null) {
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

    }

    @Override
    public void onLayPhieuDatPhongChiTietError(String error) {

    }

    @Override
    public void onThemPhieuDatBanSuccess() {

    }

    @Override
    public void onThemPhieuDatBanError(String error) {

    }

    @Override
    public void onLayPhieuDatBanChiTietSuccess(List<PhieuDatBanChiTietDTO> phieuDatPhongChiTietDTOList) {
        tempData.datBanDTO = new DatBanDTO(phieuDatDTO, phieuDatPhongChiTietDTOList);
        tempData.Check = true;
    }

    @Override
    public void onLayPhieuDatBanChiTietError(String error) {

    }

    @Override
    public void onCapNhatPhieuDatSuccess() {

    }

    @Override
    public void onCapNhatPhieuDatError(String error) {

    }

    public class PhieuDatBanViewHolder extends RecyclerView.ViewHolder {
        private ItemPhieuDatBanBinding itemPhieuDatBanBinding;

        public PhieuDatBanViewHolder(@NonNull ItemPhieuDatBanBinding itemView) {
            super(itemView.getRoot());
            this.itemPhieuDatBanBinding = itemView;
        }
    }
}
