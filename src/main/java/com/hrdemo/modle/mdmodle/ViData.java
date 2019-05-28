package com.hrdemo.modle.mdmodle;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import sun.awt.SunHints;

/**
 * Created by OTOT on 2019/5/27.
 */
@Document(collection = "alldata")
public class ViData {
    @Id
    private int id;
    private double yali;
    private double dianl;
    private double zhenk;
    private double diany;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getYali() {
        return yali;
    }

    public void setYali(double yali) {
        this.yali = yali;
    }

    public double getDianl() {
        return dianl;
    }

    public void setDianl(double dianl) {
        this.dianl = dianl;
    }

    public double getZhenk() {
        return zhenk;
    }

    public void setZhenk(double zhenk) {
        this.zhenk = zhenk;
    }

    public double getDiany() {
        return diany;
    }

    public void setDiany(double diany) {
        this.diany = diany;
    }
}
