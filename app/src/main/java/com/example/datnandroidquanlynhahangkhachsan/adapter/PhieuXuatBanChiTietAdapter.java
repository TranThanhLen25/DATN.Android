package com.example.datnandroidquanlynhahangkhachsan.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.databinding.ItemPhieuxuatbanchitietBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.Ban.BanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.Ban.LoaiBanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.HangHoaDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.goiMon.GoiMonDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanBanChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.PhieuXuatChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieuxuat.PhieuXuatBanActivity;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieuxuat.PhieuTraBanActivity;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieuxuat.PhieuXuatBanChiTietActivity;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieuxuat.PhieuXuatChiTietActivity;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class PhieuXuatBanChiTietAdapter extends RecyclerView.Adapter<PhieuXuatBanChiTietAdapter.PhieuXuatBanChiTietViewHolder> {
    private List<PhieuXuatChiTietDTO> lsPhieuXuatChiTiet;
    private List<PhieuNhanBanChiTietDTO> lsPhieuNhanChiTiet;
    private List<BanDTO> lsBan;
    private List<HangHoaDTO> lsHangHoa;
    private List<LoaiBanDTO> lsLoaiBan;
    private List<GoiMonDTO> lsGoiMon;

    private int loaibanid;
    private int tongtien = 0;
    private ItemPhieuxuatbanchitietBinding phieuXuatChiTietBinding;
    private Context context;

    private DateFormat format = new SimpleDateFormat("dd/MM/yyyy");


    public PhieuXuatBanChiTietAdapter(List<PhieuNhanBanChiTietDTO> lsPhieuNhanChiTiet) {
        this.lsPhieuNhanChiTiet = lsPhieuNhanChiTiet;

    }

    public PhieuXuatBanChiTietAdapter(PhieuXuatBanActivity phieuXuatBanActivity) {

    }

    public void setData(Context context, List<LoaiBanDTO> lsLoaiBan, List<GoiMonDTO> lsGoiMon, List<HangHoaDTO> lsHangHoa, List<PhieuXuatChiTietDTO> lsPhieuXuatChiTiet, List<PhieuNhanBanChiTietDTO> lsPhieuNhanChiTiet,
                        List<BanDTO> lsBan) {
        this.lsLoaiBan = lsLoaiBan;
        this.lsGoiMon = lsGoiMon;
        this.lsHangHoa = lsHangHoa;
        this.lsPhieuXuatChiTiet = lsPhieuXuatChiTiet;
        this.lsPhieuNhanChiTiet = lsPhieuNhanChiTiet;
        this.lsBan = lsBan;
        this.context = context;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public PhieuXuatBanChiTietAdapter.PhieuXuatBanChiTietViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        phieuXuatChiTietBinding = ItemPhieuxuatbanchitietBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PhieuXuatBanChiTietAdapter.PhieuXuatBanChiTietViewHolder(phieuXuatChiTietBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PhieuXuatBanChiTietAdapter.PhieuXuatBanChiTietViewHolder holder, int position) {
        PhieuNhanBanChiTietDTO pn = lsPhieuNhanChiTiet.get(position);
        if (pn == null) {
            return;
        }
        ///set trạng thai
        DecimalFormat decimalFormat = new DecimalFormat("#,##0");
        if (pn.getTrangThai() == 2) {
            holder.phieuXuatChiTietBinding.tvTrangthai.setText("Đã thanh toán");
            holder.phieuXuatChiTietBinding.tvTrangthai.setTextColor(Color.GREEN);
            for (int i = 0; i < lsPhieuXuatChiTiet.size(); i++) {

                if (lsPhieuXuatChiTiet.get(i).getPhieuNhanBanChiTietId() == pn.getPhieuDatBanChiTietId()) {
                    tongtien = tongtien + (int) lsPhieuXuatChiTiet.get(i).getThanhTien();
                }
            }
            holder.phieuXuatChiTietBinding.tvTongtien.setText(String.valueOf(decimalFormat.format(tongtien)));
            tongtien = 0;


        }
        if (pn.getTrangThai() == 4) {
            holder.phieuXuatChiTietBinding.tvTrangthai.setText("Đang sử dụng");
            holder.phieuXuatChiTietBinding.tvTrangthai.setTextColor(Color.RED);
            for (int i = 0; i < lsGoiMon.size(); i++) {
                if (lsGoiMon.get(i).getBanId() == pn.getBanId() && lsGoiMon.get(i).getTrangThai().equals("chưa thanh toán")) {
                    for (int a = 0; a < lsHangHoa.size(); a++) {
                        if (lsHangHoa.get(a).getHangHoaId() == lsGoiMon.get(i).getHangHoaId()) {
                            tongtien = tongtien + lsHangHoa.get(a).getDonGia() * lsGoiMon.get(i).getSoLuong();
                        }
                    }
                }
            }
            holder.phieuXuatChiTietBinding.tvTongtien.setText(String.valueOf(decimalFormat.format(tongtien)));
            tongtien = 0;
        }

        for (int i = 0; i < lsBan.size(); i++) {
            if (lsBan.get(i).getBanId() == pn.getBanId()) {
                holder.phieuXuatChiTietBinding.tvSo.setText(lsBan.get(i).getTenBan());
                loaibanid = lsBan.get(i).getLoaiBanId();
            }
        }
        for (int i = 0; i < lsLoaiBan.size(); i++) {
            if (lsLoaiBan.get(i).getLoaiBanId() == loaibanid) {
                holder.phieuXuatChiTietBinding.tvSongay.setText(lsLoaiBan.get(i).getTenLoaiBan());
            }
        }


        phieuXuatChiTietBinding.itemPhieuxuatban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = context.getSharedPreferences("GET_BANID", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putLong("PNBCT", pn.getPhieuDatBanChiTietId());


                for (int i = 0; i < lsBan.size(); i++) {
                    if (lsBan.get(i).getBanId() == pn.getBanId()) {
                        editor.putInt("BANID", lsBan.get(i).getBanId());
                        editor.putString("TENBAN", lsBan.get(i).getTenBan());
                    }

                }
                editor.putLong("PNCT",pn.getPhieuDatBanChiTietId());
                DateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
                editor.commit();


                if (pn.getTrangThai()==4)
                {
                    Intent intent=new Intent(context, PhieuTraBanActivity.class);
                    context.startActivity(intent);
                }
                else
                {
                    Intent intent = new Intent(context, PhieuXuatBanChiTietActivity.class);
                    context.startActivity(intent);
                }



            }
        });


    }

    @Override
    public int getItemCount() {
        if ((lsPhieuNhanChiTiet != null)) {
            return lsPhieuNhanChiTiet.size();
        }
        return 0;
    }

    class PhieuXuatBanChiTietViewHolder extends RecyclerView.ViewHolder {
        private ItemPhieuxuatbanchitietBinding phieuXuatChiTietBinding;

        public PhieuXuatBanChiTietViewHolder(@NonNull ItemPhieuxuatbanchitietBinding phieuXuatChiTietBinding) {
            super(phieuXuatChiTietBinding.getRoot());
            this.phieuXuatChiTietBinding = phieuXuatChiTietBinding;
        }

    }
}
