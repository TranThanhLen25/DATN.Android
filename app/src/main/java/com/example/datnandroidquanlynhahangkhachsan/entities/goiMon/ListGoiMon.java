package com.example.datnandroidquanlynhahangkhachsan.entities.goiMon;

import java.util.List;

public class ListGoiMon {
    private List<GoiMonDTO> goiMonDTOsCapNhat;


    public ListGoiMon(List<GoiMonDTO> goiMonDTOsCapNhat) {
        this.goiMonDTOsCapNhat = goiMonDTOsCapNhat;
    }

    public ListGoiMon() {
    }

    public List<GoiMonDTO> getGoiMonDTOsCapNhat() {
        return goiMonDTOsCapNhat;
    }

    public void setGoiMonDTOsCapNhat(List<GoiMonDTO> goiMonDTOsCapNhat) {
        this.goiMonDTOsCapNhat = goiMonDTOsCapNhat;
    }
}
