package com.example.datnandroidquanlynhahangkhachsan.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.databinding.ItemMenuPhieutraphongBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.DichVu.DichVuDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.HangHoaDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.PhieuXuatChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieuxuat.PhieuTraPhongActivity;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieuxuat.PhieuXuatBanChiTietActivity;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieuxuat.PhieuXuatChiTietActivity;

import java.text.DecimalFormat;
import java.util.List;

public class DanhSachPXCTAdapter extends RecyclerView.Adapter<DanhSachPXCTAdapter.DanhSachPXCTViewHolder> {
    private List<PhieuXuatChiTietDTO> lsPhieuXuatChiTiet;
private List<HangHoaDTO> lsHangHoa;


    private Context context;

    public DanhSachPXCTAdapter(List<PhieuXuatChiTietDTO> lsPhieuXuatChiTiet) {
        this.lsPhieuXuatChiTiet = lsPhieuXuatChiTiet;
    }

    public DanhSachPXCTAdapter(PhieuXuatChiTietActivity phieuXuatChiTietActivity) {
    }

    public DanhSachPXCTAdapter(PhieuXuatBanChiTietActivity phieuXuatBanChiTietActivity) {
    }

    public void setData(List<HangHoaDTO>lsHangHoa, Context context, List<PhieuXuatChiTietDTO> lsPhieuXuatChiTiet) {
        this.lsHangHoa=lsHangHoa;
        this.lsPhieuXuatChiTiet = lsPhieuXuatChiTiet;
        this.context = context;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DanhSachPXCTAdapter.DanhSachPXCTViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemMenuPhieutraphongBinding danhSachPXCTBinding = ItemMenuPhieutraphongBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new DanhSachPXCTAdapter.DanhSachPXCTViewHolder(danhSachPXCTBinding);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull DanhSachPXCTAdapter.DanhSachPXCTViewHolder holder, int position) {
        PhieuXuatChiTietDTO pxct = lsPhieuXuatChiTiet.get(position);
        if (pxct == null) {
            return;
        }
        DecimalFormat decimalFormat = new DecimalFormat("#,##0");
        DecimalFormat fm= new DecimalFormat("#.#");
        holder.danhSachPXCTBinding.tvSoluong.setText(String.valueOf(fm.format(pxct.getSoLuong()) ));
        holder.danhSachPXCTBinding.tvDongiaHanghoaDichvu.setText(String.valueOf(decimalFormat.format(pxct.getDonGia())));
        holder.danhSachPXCTBinding.tvThanhtien.setText(String.valueOf(decimalFormat.format(pxct.getThanhTien())));
        for (int i=0;i<lsHangHoa.size();i++)
        {
            if(lsHangHoa.get(i).getHangHoaId()== pxct.getHangHoaId())
            {
                holder.danhSachPXCTBinding.tvTendichvu.setText(lsHangHoa.get(i).getTenHangHoa());
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

    class DanhSachPXCTViewHolder extends RecyclerView.ViewHolder {
        private ItemMenuPhieutraphongBinding danhSachPXCTBinding;

        public DanhSachPXCTViewHolder(@NonNull ItemMenuPhieutraphongBinding itemView) {

            super(itemView.getRoot());
            this.danhSachPXCTBinding = itemView;
        }
    }
}
