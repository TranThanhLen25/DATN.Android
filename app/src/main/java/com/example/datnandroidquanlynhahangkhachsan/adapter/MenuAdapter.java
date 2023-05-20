package com.example.datnandroidquanlynhahangkhachsan.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.databinding.ItemMenuBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.DichVu.DichVuDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.HangHoaDTO;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {
    private List<DichVuDTO> lsdichvu;
    private List<HangHoaDTO> lsHangHoa;
    private HangHoaDTO hangHoaDTO;

    public MenuAdapter(List<DichVuDTO> lsdichvu, List<HangHoaDTO> lsHangHoa) {
        this.lsdichvu = lsdichvu;
        this.lsHangHoa = lsHangHoa;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemMenuBinding itemMenuBinding = ItemMenuBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MenuViewHolder(itemMenuBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        NumberFormat formatter = new DecimalFormat("#,###");
        int index = position;
        DichVuDTO dichvu = lsdichvu.get((index));
        hangHoaDTO = new HangHoaDTO();
        int soLuong = lsdichvu.get(index).getSoLuong();
        if (dichvu == null) {
            return;
        }
        for (int i = 0; i < lsHangHoa.size(); i++) {
            if (dichvu.getHangHoaId() == lsHangHoa.get(i).getHangHoaId()) {
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
                if (lsdichvu.get(index).getSoLuong() >= 0) {
                    lsdichvu.get(index).setSoLuong(lsdichvu.get(index).getSoLuong() + 1);
                    int soLuong = lsdichvu.get(index).getSoLuong();
                    holder.itemMenuBinding.tvSoluongmenu.setText(" x" + String.valueOf(soLuong));
                    holder.itemMenuBinding.tvPrice.setText(String.valueOf(formatter.format(donGia * soLuong)) + " VNĐ");
                }
            }
        });
        holder.itemMenuBinding.btnMinusItemMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lsdichvu.get(index).getSoLuong() > 1) {
                    lsdichvu.get(index).setSoLuong(lsdichvu.get(index).getSoLuong() - 1);
                    int soLuong = lsdichvu.get(index).getSoLuong();
                    holder.itemMenuBinding.tvSoluongmenu.setText(" x" + String.valueOf(lsdichvu.get(index).getSoLuong()));
                    holder.itemMenuBinding.tvPrice.setText(String.valueOf(formatter.format(donGia * soLuong)) + " VNĐ");
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if ((lsdichvu.size() > 0)) {
            return lsdichvu.size();
        }
        return 0;
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder {
        private ItemMenuBinding itemMenuBinding;
        public LinearLayout linearLayout;

        public MenuViewHolder(@NonNull ItemMenuBinding itemMenuBinding) {

            super(itemMenuBinding.getRoot());
            this.itemMenuBinding = itemMenuBinding;
            linearLayout = itemMenuBinding.lnlItemmenu;
        }
    }


    public void removeItem(int index) {
        lsdichvu.remove(index);
        notifyItemRemoved(index);
    }
}
