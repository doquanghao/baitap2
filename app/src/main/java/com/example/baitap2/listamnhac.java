package com.example.baitap2;

public class listamnhac {
    String link,tenbaihat,hinhanh,tacgia;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTenbaihat() {
        return tenbaihat;
    }

    public void setTenbaihat(String tenbaihat) {
        this.tenbaihat = tenbaihat;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }

    public listamnhac() {
    }

    public listamnhac(String link, String tenbaihat, String hinhanh, String tacgia) {
        this.link = link;
        this.tenbaihat = tenbaihat;
        this.hinhanh = hinhanh;
        this.tacgia = tacgia;
    }
}
