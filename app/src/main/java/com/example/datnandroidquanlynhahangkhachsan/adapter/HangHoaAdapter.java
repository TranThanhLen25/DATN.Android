package com.example.datnandroidquanlynhahangkhachsan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.R;
import com.example.datnandroidquanlynhahangkhachsan.entities.HangHoaDTO;
import com.example.datnandroidquanlynhahangkhachsan.ui.fragmentMenu.fragment_menu_dichvu;
import com.example.datnandroidquanlynhahangkhachsan.ui.fragmentMenu.fragment_menu_douong;
import com.example.datnandroidquanlynhahangkhachsan.ui.fragmentMenu.fragment_menu_goimon;

import java.util.List;

public class HangHoaAdapter extends RecyclerView.Adapter<HangHoaAdapter.HangHoaViewHolder> {
    private List<HangHoaDTO> lsHangHoa;
    private Context context;

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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hanghoa_dichvu, parent, false);
        return new HangHoaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HangHoaViewHolder holder, int position) {
        HangHoaDTO HangHoa = lsHangHoa.get((position));
        if (HangHoa == null) {
            return;
        }
        holder.tvtenHangHoa.setText(HangHoa.getTenHangHoa());
        holder.tvdongiahanghoaHangHoa.setText(String.valueOf(HangHoa.getDonGia()));
    }

    @Override
    public int getItemCount() {
        if ((lsHangHoa != null)) {
            return lsHangHoa.size();
        }
        return 0;
    }

    class HangHoaViewHolder extends RecyclerView.ViewHolder {
        private TextView tvtenHangHoa, tvdongiahanghoaHangHoa;

        public HangHoaViewHolder(@NonNull View itemView) {

            super(itemView);
            tvtenHangHoa = itemView.findViewById(R.id.tv_tendichvu);
            tvdongiahanghoaHangHoa = itemView.findViewById(R.id.tv_dongia_hanghoa_dichvu);
        }
    }
}
