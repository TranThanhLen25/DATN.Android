package com.example.datnandroidquanlynhahangkhachsan.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.PhieuDatBanChiTietActivity;
import com.example.datnandroidquanlynhahangkhachsan.databinding.ItemPhieuxuatchitietBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.Ban.BanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.Ban.LoaiBanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.PhieuDatBanChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.ui.Ban.BanContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.Ban.BanPresenter;

import java.util.List;

public class PhieuDatBanChiTietAdapter extends RecyclerView.Adapter<PhieuDatBanChiTietAdapter.PhieuXuatChiTietViewHolder> implements BanContract.View {
    private ItemPhieuxuatchitietBinding phieuXuatChiTietBinding;
    private List<PhieuDatBanChiTietDTO> phieuDatBanChiTietDTOList;
    private List<BanDTO> banDTOList;
    private List<LoaiBanDTO> loaiBanDTOList;
    private BanPresenter banPresenter;

    public PhieuDatBanChiTietAdapter(PhieuDatBanChiTietActivity phieuDatBanChiTietActivity) {
        banPresenter = new BanPresenter(this);
        banPresenter.LayDanhSachBan();
        banPresenter.LayDanhSachLoaiBan();
    }


    public void setData(List<PhieuDatBanChiTietDTO> phieuDatBanChiTietDTOList) {
        this.phieuDatBanChiTietDTOList = phieuDatBanChiTietDTOList;
    }

    public void setData(List<PhieuDatBanChiTietDTO> phieuDatBanChiTietDTOList, List<BanDTO> banDTOList, List<LoaiBanDTO> loaiBanDTOList) {
        this.phieuDatBanChiTietDTOList = phieuDatBanChiTietDTOList;
        this.banDTOList = banDTOList;
        this.loaiBanDTOList = loaiBanDTOList;
    }

    @NonNull
    @Override
    public PhieuXuatChiTietViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        phieuXuatChiTietBinding = ItemPhieuxuatchitietBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new PhieuDatBanChiTietAdapter.PhieuXuatChiTietViewHolder(phieuXuatChiTietBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PhieuXuatChiTietViewHolder holder, int position) {
        int index = position;
        PhieuDatBanChiTietDTO phieuDatBanChiTietDTO = phieuDatBanChiTietDTOList.get(index);
        if (phieuDatBanChiTietDTO == null) {
            return;
        }
        BanDTO banDTO = new BanDTO();
        if (banDTOList==null){
            banPresenter.LayDanhSachBan();
        }
        for (int i = 0; i < banDTOList.size(); i++) {
            if (phieuDatBanChiTietDTO.getBanId() == banDTOList.get(i).getBanId())
                banDTO = banDTOList.get(i);
        }
        if (banDTO.getBanId() > 0) {

        } else {
            return;
        }
        LoaiBanDTO loaiBanDTO = new LoaiBanDTO();
        if (loaiBanDTOList==null){
            banPresenter.LayDanhSachLoaiBan();
        }
        for (int i = 0; i < loaiBanDTOList.size(); i++) {
            if (banDTO.getLoaiBanId() == loaiBanDTOList.get(i).getLoaiBanId()) {
                loaiBanDTO = loaiBanDTOList.get(i);
            }
        }
        if (loaiBanDTO.getLoaiBanId() > 0) {

        } else {
            return;
        }

        holder.phieuXuatChiTietBinding.tvPhong.setText("Bàn:");
        holder.phieuXuatChiTietBinding.tvSo.setText(String.valueOf(banDTO.getTenBan()));
        holder.phieuXuatChiTietBinding.tvMenu.setText("Loại Bàn:");
        holder.phieuXuatChiTietBinding.tvTongtien.setText(String.valueOf(loaiBanDTO.getTenLoaiBan()));
        holder.phieuXuatChiTietBinding.tvTrangthai.setVisibility(View.GONE);
        holder.phieuXuatChiTietBinding.tvGia.setVisibility(View.GONE);
        holder.phieuXuatChiTietBinding.tvSongay.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        if ((phieuDatBanChiTietDTOList != null)) {
            return phieuDatBanChiTietDTOList.size();
        }
        return 0;
    }

    @Override
    public void onLayDanhSachBanSuccess(List<BanDTO> lsDanhSachBan) {
        banDTOList = lsDanhSachBan;
    }

    @Override
    public void onLayDanhSachBanError(String error) {

    }

    @Override
    public void onLayDanhSachLoaiBanSuccess(List<LoaiBanDTO> list) {
        loaiBanDTOList = list;
    }

    @Override
    public void onLayDanhSachLoaiBanError(String error) {

    }

    @Override
    public void onCapNhatTrangThaiBanSuccess(){}

    @Override
    public void onCapNhatTrangThaiBanError(String error){}

    @Override
    public void onDoiBanSuccess() {

    }

    @Override
    public void onDoiBanError(String error) {

    }

    class PhieuXuatChiTietViewHolder extends RecyclerView.ViewHolder {
        private ItemPhieuxuatchitietBinding phieuXuatChiTietBinding;

        public PhieuXuatChiTietViewHolder(@NonNull ItemPhieuxuatchitietBinding phieuXuatChiTietBinding) {
            super(phieuXuatChiTietBinding.getRoot());
            this.phieuXuatChiTietBinding = phieuXuatChiTietBinding;
        }

    }
}
