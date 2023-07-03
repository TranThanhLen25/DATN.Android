package com.example.datnandroidquanlynhahangkhachsan.adapter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.R;
import com.example.datnandroidquanlynhahangkhachsan.databinding.ItemHanghoaDichvuBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.HangHoaDTO;
import com.example.datnandroidquanlynhahangkhachsan.tempData.tempData;
import com.example.datnandroidquanlynhahangkhachsan.ui.Menu.HangHoaContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.Menu.HangHoaPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.Menu.fragment_menu_dichvu;
import com.example.datnandroidquanlynhahangkhachsan.ui.Menu.fragment_menu_douong;
import com.example.datnandroidquanlynhahangkhachsan.ui.Menu.fragment_menu_goimon;
import com.example.datnandroidquanlynhahangkhachsan.utils.AppUtils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

public class HangHoaAdapter extends RecyclerView.Adapter<HangHoaAdapter.HangHoaViewHolder> implements HangHoaContract.View {
    private List<HangHoaDTO> lsHangHoa;
    private Context context;
    private AppUtils appUtils;
    private HangHoaDTO hangHoaDTO;
    private HangHoaPresenter hangHoaPresenter=new HangHoaPresenter(this);

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
        if (HangHoa.getNhomHangHoa().equals("Gọi món")) {
            holder.itemHanghoaDichvuBinding.imgItemdichvu.setImageResource(R.drawable.ic_goimon);
        } else {
            if (HangHoa.getNhomHangHoa().equals("Đồ uống")) {
                holder.itemHanghoaDichvuBinding.imgItemdichvu.setImageResource(R.drawable.ic_douong);
            } else {
                holder.itemHanghoaDichvuBinding.imgItemdichvu.setImageResource(R.drawable.ic_laundry_machine);
            }
        }
        holder.itemHanghoaDichvuBinding.ctlItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (tempData.CheckChucNang == true) {
                    ColorDrawable viewColor = (ColorDrawable) holder.itemHanghoaDichvuBinding.ctlItem.getBackground();
                    int colorId = viewColor.getColor();
                    if (colorId == -1) {
                        tempData.lsDichVu.add(HangHoa.getHangHoaId());
                        //Toast.makeText(view.getContext(), "thêm", Toast.LENGTH_LONG).show();
                        holder.itemHanghoaDichvuBinding.ctlItem.setBackgroundColor(-12412);
                    } else {
                        for (int i = 0; i < tempData.lsDichVu.size(); i++) {
                            if (tempData.lsDichVu.get(i) == HangHoa.getHangHoaId()) {
                                tempData.lsDichVu.remove(i);
                                //Toast.makeText(view.getContext(), "xóa", Toast.LENGTH_LONG).show();
                            }
                        }
                        holder.itemHanghoaDichvuBinding.ctlItem.setBackgroundColor(-1);
                    }
                } else {
                    hangHoaDTO=HangHoa;
                    //DiaLogHuyDatPhong();
                }
            }

        });
    }
    public void removeItem(int index) {
        lsHangHoa.remove(index);
        notifyItemRemoved(index);
        //notifyDataSetChanged();
    }

    private void DiaLogHuyDatPhong() {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_ngung_kinh_doanh);
        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }
        TextView btnYes = dialog.findViewById(R.id.btn_yes);
        TextView btnNo = dialog.findViewById(R.id.btn_no);
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hangHoaDTO.setTrangThai("Ngừng kinh doanh");
                hangHoaPresenter.capNhatHangHoa(hangHoaDTO);
                dialog.dismiss();
            }
        });
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog.dismiss();


            }
        });


        dialog.show();


    }

    @Override
    public int getItemCount() {
        if ((lsHangHoa != null)) {
            return lsHangHoa.size();
        }
        return 0;
    }

    @Override
    public void onLayDanhSachHangHoaSuccess(List<HangHoaDTO> list) {

    }

    @Override
    public void onLayDanhSachHangHoaError(String error) {

    }

    @Override
    public void onThemHangHoaSuccess() {

    }

    @Override
    public void onThemHangHoaError(String error) {

    }

    @Override
    public void onXoaHangHoaSuccess() {

    }

    @Override
    public void onXoaHangHoaError(String error) {

    }

    @Override
    public void onCapNhatHangHoaSuccess() {

    }

    @Override
    public void onCapNhatHangHoaError(String error) {

    }

    class HangHoaViewHolder extends RecyclerView.ViewHolder {

        private ItemHanghoaDichvuBinding itemHanghoaDichvuBinding;

        public HangHoaViewHolder(@NonNull ItemHanghoaDichvuBinding itemHanghoaDichvuBinding) {

            super(itemHanghoaDichvuBinding.getRoot());
            this.itemHanghoaDichvuBinding = itemHanghoaDichvuBinding;
        }
    }
}
