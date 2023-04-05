package com.example.datnandroidquanlynhahangkhachsan.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.ui.phieunhan.Fragment_dsPhieuNhanPhong;
import com.example.datnandroidquanlynhahangkhachsan.R;
import com.example.datnandroidquanlynhahangkhachsan.model.PhieuNhan;
import com.example.datnandroidquanlynhahangkhachsan.utils.AppUtils;

import java.util.List;

public class PhieuNhanPhongAdapter extends RecyclerView.Adapter<PhieuNhanPhongAdapter.PhieuNhanPhongViewHolder> {
    private List<PhieuNhan> lsPhieuNhan;
    private AppUtils ac;

    public PhieuNhanPhongAdapter(List<PhieuNhan> lsPhieuNhan) {
        this.lsPhieuNhan = lsPhieuNhan;
    }

    public PhieuNhanPhongAdapter(Fragment_dsPhieuNhanPhong fragment_dsPhieuNhanPhong) {
    }

    @NonNull
    @Override
    public PhieuNhanPhongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_phieunhanphong, parent, false);
        return new PhieuNhanPhongViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull PhieuNhanPhongViewHolder holder, int position) {
        PhieuNhan PhieuNhan = lsPhieuNhan.get((position));
        if (PhieuNhan == null) {
            return;
        }
        holder.tvtenkhachhangphieunhanphongdata.setText(String.valueOf(PhieuNhan.getKhachHangID()));
        holder.tvsdtitemphieunhanphongdata.setText(String.valueOf(PhieuNhan.getGhiChu()));
        holder.tvsochungtuphieunhanphongdata.setText(PhieuNhan.getSoChungTu());
//        SimpleDateFormat day1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//        holder.tvthoigianlapphieuitemphieudatphongdata.setText(String.valueOf(day1.format(PhieuDat.getNgayLap())));
        holder.tvthoigianlapphieuitemphieunhanphongdata.setText(ac.formatDateToString(PhieuNhan.getNgayLap(),"dd/MM/yyyy HH:mm:ss"));
        holder.tvphongitemphieunhanphongdata.setText(String.valueOf(PhieuNhan.getKhachHangID()));
    }

    @Override
    public int getItemCount() {
        if ((lsPhieuNhan != null)) {
            return lsPhieuNhan.size();
        }
        return 0;
    }

    class PhieuNhanPhongViewHolder extends RecyclerView.ViewHolder {
        private TextView tvtenkhachhangphieunhanphongdata,
                tvsochungtuphieunhanphongdata,
                tvsdtitemphieunhanphongdata,
                tvthoigianlapphieuitemphieunhanphongdata,
                tvphongitemphieunhanphongdata;
        public PhieuNhanPhongViewHolder(@NonNull View itemView) {

            super(itemView);
            tvtenkhachhangphieunhanphongdata = itemView.findViewById(R.id.tv_tenkhachhang_phieunhanphong_data);
            tvsochungtuphieunhanphongdata = itemView.findViewById(R.id.tv_sochungtu_phieunhanphong_data);
            tvsdtitemphieunhanphongdata = itemView.findViewById(R.id.tv_sdt_itemphieunhanphong_data);
            tvthoigianlapphieuitemphieunhanphongdata = itemView.findViewById(R.id.tv_thoigianlapphieu_itemphieunhanphong_data);
            tvphongitemphieunhanphongdata = itemView.findViewById(R.id.tv_phong_itemphieunhanphong_data);
        }
    }
}
