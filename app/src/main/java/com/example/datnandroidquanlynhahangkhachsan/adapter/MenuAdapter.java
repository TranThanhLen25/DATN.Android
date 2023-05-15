package com.example.datnandroidquanlynhahangkhachsan.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.R;
import com.example.datnandroidquanlynhahangkhachsan.model.DichVu;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {
    private List<DichVu> lsdichvu;

    public MenuAdapter(List<DichVu> lsdichvu) {
        this.lsdichvu = lsdichvu;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu, parent, false);
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        DichVu dichvu = lsdichvu.get((position));
        if (dichvu == null) {
            return;
        }
        holder.tvtenmenu.setText(dichvu.getTenHangHoa());
        holder.tvsoluongmenu.setText(dichvu.getSoLuong());
        holder.tvgiamenu.setText(dichvu.getDonGia());
        holder.tvPrice.setText(dichvu.getThanhTien());
    }

    @Override
    public int getItemCount() {
        if ((lsdichvu != null)) {
            return lsdichvu.size();
        }
        return 0;
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder {
        TextView tvtenmenu, tvgiamenu, tvsoluongmenu, tvPrice;
        public LinearLayout linearLayout;

        public MenuViewHolder(@NonNull View itemView) {

            super(itemView);
            tvtenmenu = itemView.findViewById(R.id.tv_tenmenu);
            tvgiamenu = itemView.findViewById(R.id.tv_giamenu);
            tvsoluongmenu = itemView.findViewById(R.id.tv_soluongmenu);
            tvPrice = itemView.findViewById(R.id.tv_Price);
            linearLayout = itemView.findViewById(R.id.lnl_itemmenu);
        }
    }


    public void removeItem(int index) {
        lsdichvu.remove(index);
        notifyItemRemoved(index);
    }
}
