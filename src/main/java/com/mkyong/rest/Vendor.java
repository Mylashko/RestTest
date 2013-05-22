package com.mkyong.rest;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name="Vendor")
public class Vendor {


    @Id @GeneratedValue

    private int vendorId;

    private String vendorname;
    private String vendorcountry;
    private String vendorcity;
    private String vendoradress;
    private String vendorphone;

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorname() {
        return vendorname;
    }

    public void setVendorname(String vendorname) {
        this.vendorname = vendorname;
    }

    public String getVendorcountry() {
        return vendorcountry;
    }

    public void setVendorcountry(String vendorcountry) {
        this.vendorcountry = vendorcountry;
    }

    public String getVendorcity() {
        return vendorcity;
    }

    public void setVendorcity(String vendorcity) {
        this.vendorcity = vendorcity;
    }

    public String getVendoradress() {
        return vendoradress;
    }

    public void setVendoradress(String vendoradress) {
        this.vendoradress = vendoradress;
    }

    public String getVendorphone() {
        return vendorphone;
    }

    public void setVendorphone(String vendorphone) {
        this.vendorphone = vendorphone;
    }
}
