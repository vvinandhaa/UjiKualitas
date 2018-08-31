package com.example.asus.ujikualitas;

import java.sql.Date;

/**
 * Created by ASUS on 14/08/2018.
 */

public class Result {

    String id;
    String no_trs;
    String tgl_trs;
    String obyek;
    String rekanan;
    String ket;
    String cr_at;
    String cr_by;
    String versi;
    String lokasi;



    public String getid() { return id; }
    public String getno_trs() { return no_trs; }
    public String gettgl_trs() {
        return tgl_trs;
    }
    public String getobyek() { return obyek; }

    public String getrekanan() {return rekanan;}

    public String getket() {
        return ket;
    }
    public String getcr_at() { return cr_at; }

    public String getcr_by() {return cr_by;}
    public String getversi() {return versi;}

    public String getlokasi() {
        return lokasi;
    }

    //settt

    public void setid(String id) { this.id = id ; }
    public void setno_trs(String no_trs) { this.no_trs = no_trs ; }
    public void settgl_trs(String tgl_trs) {
        this.tgl_trs = tgl_trs ;
    }
    public void setobyek(String obyek) { this.obyek = obyek ; }

    public void setrekanan(String rekanan) {this.rekanan = rekanan ;}

    public void setket(String ket) {
        this.ket = ket;
    }
    public void setcr_at(String cr_at) { this.cr_at = cr_at ; }

    public void setcr_by(String cr_by) {this.cr_by = cr_by;}
    public void setversi(String versi) {this.versi = versi;}

    public void setlokasi(String lokasi) {
        this.lokasi = lokasi;
    }


}