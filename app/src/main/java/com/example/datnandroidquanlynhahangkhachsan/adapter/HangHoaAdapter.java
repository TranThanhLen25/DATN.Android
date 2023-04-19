package com.example.datnandroidquanlynhahangkhachsan.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.R;
import com.example.datnandroidquanlynhahangkhachsan.databinding.ItemHanghoaDichvuBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.HangHoaDTO;


import com.example.datnandroidquanlynhahangkhachsan.tempData.lsChonPhong;
import com.example.datnandroidquanlynhahangkhachsan.tempData.tempData;
import com.example.datnandroidquanlynhahangkhachsan.ui.Menu.fragment_menu_dichvu;
import com.example.datnandroidquanlynhahangkhachsan.ui.Menu.fragment_menu_douong;
import com.example.datnandroidquanlynhahangkhachsan.ui.Menu.fragment_menu_goimon;
import com.example.datnandroidquanlynhahangkhachsan.utils.AppUtils;


import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

public class HangHoaAdapter extends RecyclerView.Adapter<HangHoaAdapter.HangHoaViewHolder> {
    private List<HangHoaDTO> lsHangHoa;
    private Context context;
    private AppUtils appUtils;

    public HangHoaAdapter(List<HangHoaDTO> lsHangHoa) {
        this.lsHangHoa = lsHangHoa;
    }

    public HangHoaAdapter(fragment_menu_dichvu fragment_menu_dichvu) {
    }

    public HangHoaAdapter(fragment_menu_douong fragment_menu_douong) {
    }

    public HangHoaAdapter(fragment_menu_goimon fragment_menu_goimon) {
    }

    public void setData(Context context, List<HangHoaDTO> lsHangHoa) {
        this.lsHangHoa = lsHangHoa;
        this.context = context;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HangHoaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemHanghoaDichvuBinding itemHanghoaDichvuBinding = ItemHanghoaDichvuBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new HangHoaViewHolder(itemHanghoaDichvuBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull HangHoaViewHolder holder, int position) {
        HangHoaDTO HangHoa = lsHangHoa.get((position));
        if (HangHoa == null) {
            return;
        }
        NumberFormat formatter = new DecimalFormat("#,###");
        holder.itemHanghoaDichvuBinding.tvTendichvu.setText(HangHoa.getTenHangHoa());
        holder.itemHanghoaDichvuBinding.tvDongiaHanghoaDichvu.setText(String.valueOf(formatter.format(HangHoa.getDonGia()) + " VNĐ"));
        holder.itemHanghoaDichvuBinding.ctlItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ColorDrawable viewColor = (ColorDrawable) holder.itemHanghoaDichvuBinding.ctlItem.getBackground();
                int colorId = viewColor.getColor();
                if (colorId == -1) {
                    tempData.lsDichVu.add(HangHoa.getHangHoaId());
                    holder.itemHanghoaDichvuBinding.ctlItem.setBackgroundColor(-12412);
                } else {
                    for (int i = 0; i < tempData.lsDichVu.size(); i++) {
                        if (tempData.lsDichVu.get(i) == HangHoa.getHangHoaId()) {
                            tempData.lsDichVu.remove(i);
                        }
                    }
                    holder.itemHanghoaDichvuBinding.ctlItem.setBackgroundColor(-1);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if ((lsHangHoa != null)) {
            return lsHangHoa.size();
        }
        return 0;
    }

    class HangHoaViewHolder extends RecyclerView.ViewHolder {

        private ItemHanghoaDichvuBinding itemHanghoaDichvuBinding;

        public HangHoaViewHolder(@NonNull ItemHanghoaDichvuBinding itemHanghoaDichvuBinding) {

            super(itemHanghoaDichvuBinding.getRoot());
            this.itemHanghoaDichvuBinding = itemHanghoaDichvuBinding;
        }
    }
}
