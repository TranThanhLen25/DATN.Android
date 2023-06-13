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
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.Fragment_danhSachBan;
import com.example.datnandroidquanlynhahangkhachsan.R;
import com.example.datnandroidquanlynhahangkhachsan.activityThemPhieuNhanBan;
import com.example.datnandroidquanlynhahangkhachsan.activity_ChiTietBan;
import com.example.datnandroidquanlynhahangkhachsan.activity_them_phieu_dat_ban;

import com.example.datnandroidquanlynhahangkhachsan.databinding.ItemDanhsachphongBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.Ban.BanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.Ban.LoaiBanDTO;



import java.util.List;

public class BanAdapter extends RecyclerView.Adapter<BanAdapter.BanViewHolder> {
    private List<BanDTO> lsBan;
    private List<LoaiBanDTO> lsLoaiBan;
    private Context context;

    private int loaibanid;
    private int banid;
    private String tenban;
    private int songuoi;
    private String tenloaiban;

    private int trangThai;


    public BanAdapter(List<BanDTO> lsBan) {
        this.lsBan = lsBan;
    }

    public BanAdapter(Fragment_danhSachBan fragment_danhSachBan) {

    }

    public void setData(List<BanDTO> lsBan, List<LoaiBanDTO> lsLoaiBan, Context context) {
        this.lsBan = lsBan;
        this.lsLoaiBan = lsLoaiBan;
        this.context = context;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BanAdapter.BanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //hiện dialog

      ItemDanhsachphongBinding   dsBanBinding = ItemDanhsachphongBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);


        return new BanViewHolder(dsBanBinding);
    }


    @Override
    public void onBindViewHolder(@NonNull BanAdapter.BanViewHolder holder, int position) {
        BanDTO banDTO = lsBan.get((position));
        if (banDTO == null) {
            return;
        }
        trangThai = banDTO.getTrangThaiId();
        if (banDTO.getTrangThaiId() == 4) {
            holder.dsBanBinding.ctlDsphong.setBackgroundResource(R.drawable.bg_color_conguoi);
        } else if (banDTO.getTrangThaiId() == 3) {
            holder.dsBanBinding.ctlDsphong.setBackgroundResource(R.drawable.bg_color_baotri);
        } else {
            holder.dsBanBinding.ctlDsphong.setBackgroundResource(R.drawable.bg_item);
        }


        for (int i = 0; i < lsLoaiBan.size(); i++) {
            if (lsLoaiBan.get(i).getLoaiBanId() == banDTO.getLoaiBanId()) {
                holder.dsBanBinding.tvLoaiphong.setText(lsLoaiBan.get(i).getTenLoaiBan());
                holder.dsBanBinding.tvGiatien.setText(String.valueOf(lsLoaiBan.get(i).getSoNguoiToiDa()));
                songuoi=lsLoaiBan.get(i).getSoNguoiToiDa();
                tenloaiban=lsLoaiBan.get(i).getTenLoaiBan();
            }
        }
        holder.dsBanBinding.tvSophong.setText(banDTO.getTenBan());

        loaibanid = banDTO.getLoaiBanId();
        banid = banDTO.getBanId();
        tenban=banDTO.getTenBan();
       holder.dsBanBinding.itemDsphong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });


    }

    @Override
    public int getItemCount() {
        if ((lsBan != null)) {
            return lsBan.size();
        }
        return 0;
    }

    class BanViewHolder extends RecyclerView.ViewHolder {

        private ItemDanhsachphongBinding dsBanBinding;

        public BanViewHolder(@NonNull ItemDanhsachphongBinding dsBanBinding) {


            super(dsBanBinding.getRoot());
            this.dsBanBinding = dsBanBinding;


        }
    }

    private void openDialog() {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_chucnang_ban);
        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }
        window.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        TextView nhanban = dialog.findViewById(R.id.tv_dia_nhanban);
        TextView datban = dialog.findViewById(R.id.tv_dia_datban);
        TextView traban = dialog.findViewById(R.id.tv_dia_traban);
        TextView chitiet = dialog.findViewById(R.id.tv_dia_chitietban);
        TextView doiban = dialog.findViewById(R.id.tv_dia_doiban);
        TextView baotri = dialog.findViewById(R.id.tv_dia_baotriban);
        View vTraban = dialog.findViewById(R.id.view_traban);
        View vDoiban = dialog.findViewById(R.id.vDoiban);

        ///nếu phòng ch có người thì tắt chức năng trả và đổi
        if (trangThai != 4) {
            traban.setVisibility(View.GONE);
            vTraban.setVisibility(View.GONE);
            doiban.setVisibility(View.GONE);
            vDoiban.setVisibility(View.GONE);

        } else
//// nếu phòng đã có người thì không được chjọn nhận phòng
        {
            nhanban.setVisibility(View.GONE);
        }
        // sự kiện khi nhấn vào text trong dialog
        nhanban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(dialog.getContext(), activityThemPhieuNhanBan.class);
                context.startActivity(intent);

                dialog.dismiss();

            }
        });
        datban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(dialog.getContext(), activity_them_phieu_dat_ban.class);
                context.startActivity(intent);

                dialog.dismiss();

            }
        });
        chitiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(dialog.getContext(), activity_ChiTietBan.class);
                context.startActivity(intent);

                //// lưu lại thông tin phòng cần xem chi tiết
                SharedPreferences sharedPreferences = context.getSharedPreferences("CHITIETBAN", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("LOAIBANID", loaibanid);
                editor.putInt("BANID",banid );
                editor.putString("TENBAN",tenban );
                editor.putInt("SONGUOI", songuoi);
                editor.putString("TENLOAIBAN",tenloaiban );
                editor.commit();
                dialog.dismiss();

            }
        });


        traban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (trangThai == 4) {
//                    Intent intent = new Intent(dialog.getContext(), PhieuTrabanActivity.class);
//                    context.startActivity(intent);
//                    SharedPreferences sharedPreferences = context.getSharedPreferences("GET_BANID", Context.MODE_PRIVATE);
//                    SharedPreferences.Editor editor = sharedPreferences.edit();
//                    editor.putInt("banID", banid);
//                    editor.putInt("SOban", so);
//                    editor.putInt("GIA", gia);
//                    editor.putLong("PNID", phieunhanid);
//                    editor.putLong("KHID", khachhangid);
//                    editor.putString("TEN", ten);
//                    editor.putString("CCCD", cccd);
//                    editor.putString("SDT", sdt);
//                    editor.putInt("NGUOIDUNG", nguoidungid);
//                    editor.putLong("PNCT", pnct);
//                    editor.commit();
//                    dialog.dismiss();
                } else {
                    dialog.dismiss();

                }
            }


        });


        doiban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(dialog.getContext(), ThemPhieuDoibanActivity.class);
//                context.startActivity(intent);

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
