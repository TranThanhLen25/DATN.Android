package com.example.datnandroidquanlynhahangkhachsan.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.Fragment_Phong;
import com.example.datnandroidquanlynhahangkhachsan.R;
import com.example.datnandroidquanlynhahangkhachsan.databinding.ItemDanhsachphongBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.LoaiPhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.PhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.ui.PhieuTraPhongActivity;
import com.example.datnandroidquanlynhahangkhachsan.ui.ThemPhieuDoiPhongActivity;
import com.example.datnandroidquanlynhahangkhachsan.ui.ThemPhieuNhanPhongActivity;
import com.example.datnandroidquanlynhahangkhachsan.ui.chitietphong.ChiTietPhongActivity;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieudat.ThemPhieuDatphongActivity;

import java.text.DecimalFormat;
import java.util.List;


public class PhongAdapter extends RecyclerView.Adapter<PhongAdapter.PhongViewHolder> {
    private List<PhongDTO> lsPhong;
    private int so;
    private int gia;
    private String loai;
    private int phongid;
    private int loaiphongid;
    private int trangThai;

    private Context context;
    private List<LoaiPhongDTO> lsLoaiPhong;
    Fragment fragment = null;


    public PhongAdapter(List<PhongDTO> lsPhong) {
        this.lsPhong = lsPhong;
        //  this.lsLoaiPhong=lsLoaiPhong;

    }

    public PhongAdapter(Fragment_Phong fragment_dsPhong) {

    }

    public void setData(List<PhongDTO> lsPhong, Context context, List<LoaiPhongDTO> lsLoaiPhong) {
        this.lsPhong = lsPhong;
        this.context = context;
        this.lsLoaiPhong = lsLoaiPhong;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PhongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        ItemDanhsachphongBinding itemDanhsachphongBinding = ItemDanhsachphongBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);


        return new PhongViewHolder(itemDanhsachphongBinding);
    }


    @Override
    public void onBindViewHolder(@NonNull PhongViewHolder holder, int position) {
        PhongDTO phong = lsPhong.get((position));

        if (phong == null) {
            return;
        }

        ///xét trạng thái phòng theo màu
        if (phong.getTrangThaiId() == 4) {
            holder.itemDanhsachphongBinding.ctlDsphong.setBackgroundResource(R.drawable.bg_color_conguoi);
        } else if (phong.getTrangThaiId() == 3) {
            holder.itemDanhsachphongBinding.ctlDsphong.setBackgroundResource(R.drawable.bg_color_baotri);
        }
//        else if (phong.getTrangThaiId() == 2)
//        {
//            holder.itemDanhsachphongBinding.ctlDsphong.setBackgroundResource(R.drawable.bg_color_dat);
//        }
        else {
            holder.itemDanhsachphongBinding.ctlDsphong.setBackgroundResource(R.drawable.bg_item);
        }

        holder.itemDanhsachphongBinding.tvSophong.setText(String.valueOf(phong.getSoPhong()));
////lấy thông tin loại phòng theo loaiphongID
        for (int i = 0; i < lsLoaiPhong.size(); i++) {
            if (phong.getLoaiPhongId() == lsLoaiPhong.get(i).getLoaiPhongId()) {

                DecimalFormat decimalFormat = new DecimalFormat("#,##0");

                String formattedNumber = decimalFormat.format(lsLoaiPhong.get(i).getDonGia());

                holder.itemDanhsachphongBinding.tvGiatien.setText(formattedNumber);

                holder.itemDanhsachphongBinding.tvLoaiphong.setText(lsLoaiPhong.get(i).getTenLoaiPhong());
            }
        }


        /// gán thông tin phòng vào biến khi bấm vào phòng
        holder.itemDanhsachphongBinding.itemDsphong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /// gán thông tin phòng khi chọn phòng
                for (int i = 0; i < lsLoaiPhong.size(); i++) {
                    if (phong.getLoaiPhongId() == lsLoaiPhong.get(i).getLoaiPhongId()) {
                        so = phong.getSoPhong();
                        gia = lsLoaiPhong.get(i).getDonGia();
                        loai = lsLoaiPhong.get(i).getTenLoaiPhong().toString();
                        phongid=phong.getPhongId();
                        loaiphongid=lsLoaiPhong.get(i).getLoaiPhongId();
                        trangThai=phong.getTrangThaiId();
                    }

                }
                openDialog();
            }
        });


    }

    @Override
    public int getItemCount() {
        if ((lsPhong != null)) {
            return lsPhong.size();

        }
        return 0;
    }


    class PhongViewHolder extends RecyclerView.ViewHolder {

        private ItemDanhsachphongBinding itemDanhsachphongBinding;


        public PhongViewHolder(@NonNull ItemDanhsachphongBinding dsPhong) {


            super(dsPhong.getRoot());
            this.itemDanhsachphongBinding = dsPhong;


        }
    }


    /// tạo dialog chức năng
    private void openDialog() {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.fragment_dialog);
        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }
        window.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        TextView nhanphong = dialog.findViewById(R.id.tv_dia_nhanphong);
        TextView datphong = dialog.findViewById(R.id.tv_dia_datphong);
        TextView traphong = dialog.findViewById(R.id.tv_dia_traphong);
        TextView chitiet = dialog.findViewById(R.id.tv_dia_chitietphong);
        TextView doiphong = dialog.findViewById(R.id.tv_dia_doiphong);
        TextView baotri = dialog.findViewById(R.id.tv_dia_baotri);
        View vTraPhong=dialog.findViewById(R.id.view_traphong);
        View vDoiPhong=dialog.findViewById(R.id.vDoiPhong);
        ///nếu phòng ch cos người thì tắt chức năng trả và đổi
        if(trangThai!=4)
        {
            traphong.setVisibility(View.GONE);
            vTraPhong.setVisibility(View.GONE);
            doiphong.setVisibility(View.GONE);
            vDoiPhong.setVisibility(View.GONE);

        }
        // sự kiện khi nhấn vào text trong dialog
        nhanphong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(dialog.getContext(), ThemPhieuNhanPhongActivity.class);
                context.startActivity(intent);

                dialog.dismiss();

            }
        });
        datphong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(dialog.getContext(), ThemPhieuDatphongActivity.class);
                context.startActivity(intent);

                dialog.dismiss();

            }
        });
        chitiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(dialog.getContext(), ChiTietPhongActivity.class);
                context.startActivity(intent);

                //// lưu lại thông tin phòng cần xem chi tiết
                SharedPreferences sharedPreferences = context.getSharedPreferences("PHONG", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("SOPHONG", so);
                editor.putInt("GIA", gia);
                editor.putString("LOAIPHONG", loai);
                editor.putInt("PHONGID", phongid);
                editor.putInt("LOAIPHONGID", loaiphongid);
                editor.commit();

                dialog.dismiss();

            }
        });


        traphong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (trangThai == 4) {
                    Intent intent = new Intent(dialog.getContext(), PhieuTraPhongActivity.class);
                    context.startActivity(intent);
                    SharedPreferences sharedPreferences = context.getSharedPreferences("GET _PHONGID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("PHONGID", phongid);
                    editor.commit();
                    dialog.dismiss();
                }
                else {
                    dialog.dismiss();

                }
            }


        });


        doiphong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(dialog.getContext(), ThemPhieuDoiPhongActivity.class);
                context.startActivity(intent);

                dialog.dismiss();

            }
        });
        baotri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                dialog.dismiss();

            }
        });
        dialog.show();


    }


}

