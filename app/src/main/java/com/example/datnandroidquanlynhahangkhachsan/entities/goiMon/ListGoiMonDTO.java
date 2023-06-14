package com.example.datnandroidquanlynhahangkhachsan.entities.goiMon;

import java.util.List;

public class ListGoiMonDTO {
    private List<GoiMonDTO> goiMonDTOsCapNhat;


    public ListGoiMonDTO(List<GoiMonDTO> goiMonDTOsCapNhat) {
        this.goiMonDTOsCapNhat = goiMonDTOsCapNhat;
    }

    public ListGoiMonDTO() {
    }

    public List<GoiMonDTO> getGoiMonDTOsCapNhat() {
        return goiMonDTOsCapNhat;
    }

    public void setGoiMonDTOsCapNhat(List<GoiMonDTO> goiMonDTOsCapNhat) {
        this.goiMonDTOsCapNhat = goiMonDTOsCapNhat;
    }
}
