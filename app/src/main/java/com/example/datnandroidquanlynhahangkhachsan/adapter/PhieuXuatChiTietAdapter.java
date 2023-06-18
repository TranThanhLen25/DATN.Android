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

import com.example.datnandroidquanlynhahangkhachsan.databinding.ItemPhieuxuatchitietBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.LoaiPhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.PhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanPhongChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.PhieuXuatChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieuxuat.PhieuTraPhongActivity;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieuxuat.PhieuXuatActivity;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieuxuat.PhieuXuatChiTietActivity;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PhieuXuatChiTietAdapter extends RecyclerView.Adapter<PhieuXuatChiTietAdapter.PhieuXuatChiTietViewHolder> {
    private List<PhieuXuatChiTietDTO> lsPhieuXuatChiTiet;
    private List<PhieuNhanPhongChiTietDTO> lsPhieuNhanChiTiet;
    private List<PhongDTO> lsPhong;

    private List<LoaiPhongDTO> lsLoaiPhong;
    private int phong;

    private int loaiphongid;
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
    private long songay;

    private double tongMenu = 0.0d;

    private int tongCuoi = 0;

    private double tongAll = 0.0d;

    private double tongTienTT = 0.0d;

    private double tongThanhTien;
    private long tongDay;


    public PhieuXuatChiTietAdapter(List<PhieuNhanPhongChiTietDTO> lsPhieuNhanChiTiet) {
        this.lsPhieuNhanChiTiet = lsPhieuNhanChiTiet;

    }

    public PhieuXuatChiTietAdapter(PhieuXuatActivity phieuXuatActivity) {

    }

    public void setData(Context context, List<PhieuXuatChiTietDTO> lsPhieuXuatChiTiet, List<PhieuNhanPhongChiTietDTO> lsPhieuNhanChiTiet,
                        List<PhongDTO> lsPhong, List<LoaiPhongDTO> lsLoaiPhong) {

        this.lsPhieuXuatChiTiet = lsPhieuXuatChiTiet;
        this.lsPhieuNhanChiTiet = lsPhieuNhanChiTiet;
        this.lsPhong = lsPhong;
        this.lsLoaiPhong = lsLoaiPhong;
        this.context = context;

        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public PhieuXuatChiTietViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        phieuXuatChiTietBinding = ItemPhieuxuatchitietBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PhieuXuatChiTietViewHolder(phieuXuatChiTietBinding);
    }


    @Override
    public void onBindViewHolder(@NonNull PhieuXuatChiTietViewHolder holder, int position) {
        PhieuNhanPhongChiTietDTO pn = lsPhieuNhanChiTiet.get(position);
        if (pn == null) {
            return;
        }
        phong = pn.getPhongId();
        ///set trạng thai
        if (pn.getTrangThai() == 1) {
            holder.phieuXuatChiTietBinding.tvTrangthai.setText("Đã trả phòng");
            holder.phieuXuatChiTietBinding.tvTrangthai.setTextColor(Color.BLUE);
        } else if (pn.getTrangThai() == 4) {
            holder.phieuXuatChiTietBinding.tvTrangthai.setText("Đang sử dụng");
            holder.phieuXuatChiTietBinding.tvTrangthai.setTextColor(Color.RED);
        } else {
            holder.phieuXuatChiTietBinding.tvTrangthai.setText("Đã thanh toán");
            holder.phieuXuatChiTietBinding.tvTrangthai.setTextColor(Color.GREEN);
        }

        for (int i = 0; i < lsPhong.size(); i++) {
            if (lsPhong.get(i).getPhongId() == phong) {
                /// lây số phòng
                holder.phieuXuatChiTietBinding.tvSo.setText(String.valueOf(lsPhong.get(i).getSoPhong()));
                loaiphongid = lsPhong.get(i).getLoaiPhongId();

            }
        }
        DecimalFormat decimalFormat = new DecimalFormat("#,##0");
        ////lấy ngày nhận và trả
        NGAYNHAN = pn.getThoiGianNhanPhong();
        NGAYTRA = pn.getThoiGianTraPhong();
        /// format ngày và chuyển thành String

        // lấy ngày hiện tại
        Date date = Calendar.getInstance().getTime();

        // Định dạng ngày hiển thị ra
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String today = formatter.format(date);

        Nhan = format.format(NGAYNHAN);
        if(pn.getTrangThai()==4)
        {
            Tra = format.format(date);
        }
        else {
            Tra = format.format(NGAYTRA);
        }

        /// chuyển kiểu qua LOcalDate để đếm
        vao = LocalDate.parse(Nhan, fm);
        ra = LocalDate.parse(Tra, fm);
        ////đếm ngày thuê
        if (ra.toEpochDay() - vao.toEpochDay()==0)
        {
            songay=1;
        }
        else
        {
            songay = ra.toEpochDay() - vao.toEpochDay();
        }

        holder.phieuXuatChiTietBinding.tvSongay.setText(String.valueOf(songay));

        //// tính tiền tổng ngày ở
        for (int i = 0; i < lsLoaiPhong.size(); i++) {
            if (lsLoaiPhong.get(i).getLoaiPhongId() == loaiphongid) {
                tongDay = songay * Long.valueOf(lsLoaiPhong.get(i).getDonGia());
            }
        }
        int tem = 0;
        for (int i = 0; i < lsPhieuXuatChiTiet.size(); i++) {
            ////tong các phiếu xuất chi tiết
            if (lsPhieuXuatChiTiet.get(i).getPhieuNhanPhongChiTietId()
                    == pn.getPhieuNhanPhongChiTietId()) {
                tongMenu = tongMenu + (lsPhieuXuatChiTiet.get(i).getThanhTien());
            }
            tem++;
        }

        SharedPreferences sharedPreferences = context.getSharedPreferences("GET_PHONGID", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (tem == lsPhieuXuatChiTiet.size()) {
            tongAll = tongMenu + Double.valueOf(tongDay);
            holder.phieuXuatChiTietBinding.tvTongtien.setText(String.valueOf(decimalFormat.format(tongAll)));
            tongMenu = 0;
        }




        phieuXuatChiTietBinding.itemPhieuxuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editor.putLong("PNPCT", pn.getPhieuNhanPhongChiTietId());
                for (int i = 0; i < lsPhong.size(); i++) {
                    if (lsPhong.get(i).getPhongId() == pn.getPhongId()) {
                        loaiphongid = lsPhong.get(i).getLoaiPhongId();
                        editor.putInt("SOPHONG", lsPhong.get(i).getSoPhong());
                    }
                }
                for (int i = 0; i < lsLoaiPhong.size(); i++) {
                    if (lsLoaiPhong.get(i).getLoaiPhongId() == loaiphongid) {
                        editor.putInt("GIA", lsLoaiPhong.get(i).getDonGia());
                    }
                }
                editor.putInt("PHONGID", pn.getPhongId());
                editor.putLong("SONGAY",songay);
                editor.putString("NGAYVAO",formatter.format(pn.getThoiGianNhanPhong()));

                if(pn.getThoiGianTraPhong()!=null)
                {
                    editor.putString("NGAYRA",formatter.format(pn.getThoiGianTraPhong()));
                }


                editor.commit();

                if (pn.getTrangThai() == 4) {
                    Intent intent = new Intent(context, PhieuTraPhongActivity.class);
                    context.startActivity(intent);
                } else {
                    Intent intent = new Intent(context, PhieuXuatChiTietActivity.class);
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

    class PhieuXuatChiTietViewHolder extends RecyclerView.ViewHolder {
        private ItemPhieuxuatchitietBinding phieuXuatChiTietBinding;

        public PhieuXuatChiTietViewHolder(@NonNull ItemPhieuxuatchitietBinding phieuXuatChiTietBinding) {
            super(phieuXuatChiTietBinding.getRoot());
            this.phieuXuatChiTietBinding = phieuXuatChiTietBinding;
        }

    }

}
