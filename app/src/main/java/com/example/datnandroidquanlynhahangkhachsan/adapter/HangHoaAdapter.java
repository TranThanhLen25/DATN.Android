package com.example.datnandroidquanlynhahangkhachsan.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.R;
import com.example.datnandroidquanlynhahangkhachsan.model.HangHoa;

import java.util.List;

public class HangHoaAdapter extends RecyclerView.Adapter<HangHoaAdapter.HangHoaViewHolder> {
    private List<HangHoa> lsHangHoa;

    public HangHoaAdapter(List<HangHoa> lsHangHoa) {
        this.lsHangHoa = lsHangHoa;
    }

    @NonNull
    @Override
    public HangHoaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hanghoa_dichvu, parent, false);
        return new HangHoaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HangHoaViewHolder holder, int position) {
        HangHoa HangHoa = lsHangHoa.get((position));
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
