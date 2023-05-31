package com.example.datnandroidquanlynhahangkhachsan.ui.chitietphong;

import androidx.recyclerview.widget.RecyclerView;

public interface ItemTouchHelperListener {
    void itemTouchOnMove(int oldPosition, int newPosition);
    void onSwiped(RecyclerView.ViewHolder viewHolder, int position);//
}
