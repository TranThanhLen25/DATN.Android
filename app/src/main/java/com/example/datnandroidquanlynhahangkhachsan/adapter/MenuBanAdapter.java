package com.example.datnandroidquanlynhahangkhachsan.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.databinding.ItemMenuBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.HangHoaDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.goiMon.GoiMonDTO;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

public class MenuBanAdapter extends RecyclerView.Adapter<MenuBanAdapter.MenuBanViewHolder> {
    private List<GoiMonDTO> lsGoiMon;
    private List<HangHoaDTO> lsHangHoa;
    private HangHoaDTO hangHoaDTO;

    public MenuBanAdapter(List<GoiMonDTO> lsGoiMon, List<HangHoaDTO> lsHangHoa, HangHoaDTO hangHoaDTO) {
        this.lsGoiMon = lsGoiMon;
        this.lsHangHoa = lsHangHoa;
        this.hangHoaDTO = hangHoaDTO;
    }

    @NonNull
    @Override
    public MenuBanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemMenuBinding itemMenuBinding = ItemMenuBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MenuBanAdapter.MenuBanViewHolder(itemMenuBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuBanViewHolder holder, int position) {
        NumberFormat formatter = new DecimalFormat("#,###");
        int index = position;
        GoiMonDTO goiMonDTO = lsGoiMon.get((index));
        hangHoaDTO = new HangHoaDTO();
        int soLuong = lsGoiMon.get(index).getSoLuong();
        if (goiMonDTO == null) {
            return;
        }
        for (int i = 0; i < lsHangHoa.size(); i++) {
            if (goiMonDTO.getHangHoaId() == lsHangHoa.get(i).getHangHoaId()) {
                hangHoaDTO = lsHangHoa.get(i);
            }
            //
        }
        holder.itemMenuBinding.tvTenmenu.setText(hangHoaDTO.getTenHangHoa());
        holder.itemMenuBinding.tvSoluongmenu.setText(" x" + String.valueOf(soLuong));
        holder.itemMenuBinding.tvGiamenu.setText(String.valueOf(formatter.format(hangHoaDTO.getDonGia())) + " VNĐ");
        holder.itemMenuBinding.tvPrice.setText(String.valueOf(formatter.format(hangHoaDTO.getDonGia() * soLuong)) + " VNĐ");
        int donGia = hangHoaDTO.getDonGia();
        holder.itemMenuBinding.btnAddItemMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lsGoiMon.get(index).getSoLuong() >= 0) {
                    lsGoiMon.get(index).setSoLuong(lsGoiMon.get(index).getSoLuong() + 1);
                    int soLuong = lsGoiMon.get(index).getSoLuong();
                    holder.itemMenuBinding.tvSoluongmenu.setText(" x" + String.valueOf(soLuong));
                    holder.itemMenuBinding.tvPrice.setText(String.valueOf(formatter.format(donGia * soLuong)) + " VNĐ");
                }
            }
        });
        holder.itemMenuBinding.btnMinusItemMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lsGoiMon.get(index).getSoLuong() > 1) {
                    lsGoiMon.get(index).setSoLuong(lsGoiMon.get(index).getSoLuong() - 1);
                    int soLuong = lsGoiMon.get(index).getSoLuong();
                    holder.itemMenuBinding.tvSoluongmenu.setText(" x" + String.valueOf(lsGoiMon.get(index).getSoLuong()));
                    holder.itemMenuBinding.tvPrice.setText(String.valueOf(formatter.format(donGia * soLuong)) + " VNĐ");
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if ((lsGoiMon.size() > 0)) {
            return lsGoiMon.size();
        }
        return 0;
    }

    public class MenuBanViewHolder extends RecyclerView.ViewHolder {
        private ItemMenuBinding itemMenuBinding;
        public LinearLayout linearLayout;

        public MenuBanViewHolder(@NonNull ItemMenuBinding itemMenuBinding) {

            super(itemMenuBinding.getRoot());
            this.itemMenuBinding = itemMenuBinding;
            linearLayout = itemMenuBinding.lnlItemmenu;
        }
    }
    public void removeItem(int index) {
        lsGoiMon.remove(index);
        notifyItemRemoved(index);
        notifyDataSetChanged();
    }
}
