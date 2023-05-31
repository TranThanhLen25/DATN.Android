package com.example.datnandroidquanlynhahangkhachsan.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.databinding.ItemPhieuxuatchitietBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.PhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanPhongChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.PhieuXuatChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieuxuat.PhieuXuatActivity;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class PhieuXuatChiTietAdapter extends RecyclerView.Adapter<PhieuXuatChiTietAdapter.PhieuXuatChiTietViewHolder> {
    private List<PhieuXuatChiTietDTO> lsPhieuXuatChiTiet;

    private List<PhieuNhanPhongChiTietDTO> lsPhieuNhanChiTiet;
    private List<PhongDTO> lsPhong;
    private int phong;

    private Context context;
    DateTimeFormatter fm = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    ///đếm ngày
    LocalDate vao;
    LocalDate ra;
    /// dùng để format đúng định dạng
    private String Nhan;

    private String Tra;
    ///gán ngày trong CSDL vào
    private Date NGAYNHAN;
    private Date NGAYTRA;

    private DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    private ItemPhieuxuatchitietBinding phieuXuatChiTietBinding;
    private Long songay;


    public PhieuXuatChiTietAdapter(List<PhieuXuatChiTietDTO> lsPhieuXuatChiTiet) {
        this.lsPhieuXuatChiTiet = lsPhieuXuatChiTiet;

    }

    public PhieuXuatChiTietAdapter(PhieuXuatActivity phieuXuatActivity) {

    }

    public void setData(Context context, List<PhieuXuatChiTietDTO> lsPhieuXuatChiTiet, List<PhieuNhanPhongChiTietDTO> lsPhieuNhanChiTiet,
                        List<PhongDTO> lsPhong) {
        this.lsPhieuXuatChiTiet = lsPhieuXuatChiTiet;
        this.lsPhieuNhanChiTiet = lsPhieuNhanChiTiet;
        this.lsPhong = lsPhong;
        this.context = context;

        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public PhieuXuatChiTietViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        phieuXuatChiTietBinding = ItemPhieuxuatchitietBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PhieuXuatChiTietViewHolder(phieuXuatChiTietBinding);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull PhieuXuatChiTietViewHolder holder, int position) {
        PhieuXuatChiTietDTO px = lsPhieuXuatChiTiet.get(position);
        if (px == null) {
            return;
        }
        /// tổng tiền
        DecimalFormat decimalFormat = new DecimalFormat("#,##0");
        holder.phieuXuatChiTietBinding.tvTongtien.setText(String.valueOf(decimalFormat.format(px.getThanhTien())));


        for (int i = 0; i < lsPhieuNhanChiTiet.size(); i++) {
            if (px.getPhieuNhanPhongChiTietId() == lsPhieuNhanChiTiet.get(i).getPhieuNhanPhongChiTietId()) {
                phong = lsPhieuNhanChiTiet.get(i).getPhongId();
                ////lấy ngày nhận và trả
                NGAYNHAN = lsPhieuNhanChiTiet.get(i).getThoiGianNhanPhong();
                NGAYTRA = lsPhieuNhanChiTiet.get(i).getThoiGianTraPhong();

                /// format ngày và chuyển thành String
                Nhan = format.format(NGAYNHAN);
                Tra = format.format(NGAYTRA);
                /// chuyển kiểu qua LOcalDate để đếm
                vao = LocalDate.parse(Nhan, fm);
                ra = LocalDate.parse(Tra, fm);
                ////đếm ngày thuê
                songay = ra.toEpochDay() - vao.toEpochDay();
                holder.phieuXuatChiTietBinding.tvSongay.setText(String.valueOf(songay));

                if (lsPhieuNhanChiTiet.get(i).getTrangThai() == 1) {
                    ///set trạng thai

                    holder.phieuXuatChiTietBinding.tvTrangthai.setText("Đã trả phòng");
                    holder.phieuXuatChiTietBinding.tvTrangthai.setTextColor(Color.BLUE);
                }
                else if (lsPhieuNhanChiTiet.get(i).getTrangThai() == 4)
                {
                    holder.phieuXuatChiTietBinding.tvTrangthai.setText("Đang sử dụng");
                    holder.phieuXuatChiTietBinding.tvTrangthai.setTextColor(Color.RED);
                }
                else {
                    holder.phieuXuatChiTietBinding.tvTrangthai.setText("Đã thanh toán");
                    holder.phieuXuatChiTietBinding.tvTrangthai.setTextColor(Color.GREEN);
                }
            }
        }
        for (int i = 0; i < lsPhong.size(); i++) {
            if (lsPhong.get(i).getPhongId() == phong) {
                /// lây số phòng
                holder.phieuXuatChiTietBinding.tvSo.setText(String.valueOf(lsPhong.get(i).getSoPhong()));
            }
        }

    }

    @Override
    public int getItemCount() {
        if ((lsPhieuXuatChiTiet != null)) {
            return lsPhieuXuatChiTiet.size();
        }
        return 0;
    }

    class PhieuXuatChiTietViewHolder extends RecyclerView.ViewHolder {
        private ItemPhieuxuatchitietBinding phieuXuatChiTietBinding;

        public PhieuXuatChiTietViewHolder(@NonNull ItemPhieuxuatchitietBinding phieuXuatChiTietBinding) {
            super(phieuXuatChiTietBinding.getRoot());
            this.phieuXuatChiTietBinding = phieuXuatChiTietBinding;
        }

    }

}
