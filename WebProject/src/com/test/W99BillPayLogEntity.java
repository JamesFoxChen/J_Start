package com.test;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2015/5/6.
 */
@Entity
@Table(name = "W99billPayLog", schema = "dbo", catalog = "JWIFI")
public class W99BillPayLogEntity {
    private int id;
    private String provinceCity;
    private String bankName;
    private String kaiHuHang;
    private String creditName;
    private String bankCardNumber;
    private BigDecimal amount;
    private String description;
    private String orderId;
    private String sign;
    private String dealId;
    private int status;
    private Timestamp updateTime;
    private Timestamp createTime;
    private int isHandle;
    private int billType;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ProvinceCity")
    public String getProvinceCity() {
        return provinceCity;
    }

    public void setProvinceCity(String provinceCity) {
        this.provinceCity = provinceCity;
    }

    @Basic
    @Column(name = "BankName")
    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Basic
    @Column(name = "KaiHuHang")
    public String getKaiHuHang() {
        return kaiHuHang;
    }

    public void setKaiHuHang(String kaiHuHang) {
        this.kaiHuHang = kaiHuHang;
    }

    @Basic
    @Column(name = "CreditName")
    public String getCreditName() {
        return creditName;
    }

    public void setCreditName(String creditName) {
        this.creditName = creditName;
    }

    @Basic
    @Column(name = "BankCardNumber")
    public String getBankCardNumber() {
        return bankCardNumber;
    }

    public void setBankCardNumber(String bankCardNumber) {
        this.bankCardNumber = bankCardNumber;
    }

    @Basic
    @Column(name = "Amount")
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "OrderID")
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "Sign")
    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Basic
    @Column(name = "DealID")
    public String getDealId() {
        return dealId;
    }

    public void setDealId(String dealId) {
        this.dealId = dealId;
    }

    @Basic
    @Column(name = "Status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Basic
    @Column(name = "UpdateTime")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "CreateTime")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "IsHandle")
    public int getIsHandle() {
        return isHandle;
    }

    public void setIsHandle(int isHandle) {
        this.isHandle = isHandle;
    }

    @Basic
    @Column(name = "BillType")
    public int getBillType() {
        return billType;
    }

    public void setBillType(int billType) {
        this.billType = billType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        W99BillPayLogEntity that = (W99BillPayLogEntity) o;

        if (id != that.id) return false;
        if (status != that.status) return false;
        if (isHandle != that.isHandle) return false;
        if (billType != that.billType) return false;
        if (provinceCity != null ? !provinceCity.equals(that.provinceCity) : that.provinceCity != null) return false;
        if (bankName != null ? !bankName.equals(that.bankName) : that.bankName != null) return false;
        if (kaiHuHang != null ? !kaiHuHang.equals(that.kaiHuHang) : that.kaiHuHang != null) return false;
        if (creditName != null ? !creditName.equals(that.creditName) : that.creditName != null) return false;
        if (bankCardNumber != null ? !bankCardNumber.equals(that.bankCardNumber) : that.bankCardNumber != null)
            return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;
        if (sign != null ? !sign.equals(that.sign) : that.sign != null) return false;
        if (dealId != null ? !dealId.equals(that.dealId) : that.dealId != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (provinceCity != null ? provinceCity.hashCode() : 0);
        result = 31 * result + (bankName != null ? bankName.hashCode() : 0);
        result = 31 * result + (kaiHuHang != null ? kaiHuHang.hashCode() : 0);
        result = 31 * result + (creditName != null ? creditName.hashCode() : 0);
        result = 31 * result + (bankCardNumber != null ? bankCardNumber.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        result = 31 * result + (sign != null ? sign.hashCode() : 0);
        result = 31 * result + (dealId != null ? dealId.hashCode() : 0);
        result = 31 * result + status;
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + isHandle;
        result = 31 * result + billType;
        return result;
    }
}
