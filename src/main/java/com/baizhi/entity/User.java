package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private Integer id;

    private String phone;

    private String password;

    private String salt;

    private String sign;

    private String headPic;

    private String name;

    private String dharma;

    private Integer sex;

    private String provicnce;

    private String city;

    private Integer status;

    private Date regDate;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign == null ? null : sign.trim();
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic == null ? null : headPic.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDharma() {
        return dharma;
    }

    public void setDharma(String dharma) {
        this.dharma = dharma == null ? null : dharma.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getProvicnce() {
        return provicnce;
    }

    public void setProvicnce(String provicnce) {
        this.provicnce = provicnce == null ? null : provicnce.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        User other = (User) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getSalt() == null ? other.getSalt() == null : this.getSalt().equals(other.getSalt()))
            && (this.getSign() == null ? other.getSign() == null : this.getSign().equals(other.getSign()))
            && (this.getHeadPic() == null ? other.getHeadPic() == null : this.getHeadPic().equals(other.getHeadPic()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getDharma() == null ? other.getDharma() == null : this.getDharma().equals(other.getDharma()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getProvicnce() == null ? other.getProvicnce() == null : this.getProvicnce().equals(other.getProvicnce()))
            && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRegDate() == null ? other.getRegDate() == null : this.getRegDate().equals(other.getRegDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getSalt() == null) ? 0 : getSalt().hashCode());
        result = prime * result + ((getSign() == null) ? 0 : getSign().hashCode());
        result = prime * result + ((getHeadPic() == null) ? 0 : getHeadPic().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getDharma() == null) ? 0 : getDharma().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getProvicnce() == null) ? 0 : getProvicnce().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRegDate() == null) ? 0 : getRegDate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", phone=").append(phone);
        sb.append(", password=").append(password);
        sb.append(", salt=").append(salt);
        sb.append(", sign=").append(sign);
        sb.append(", headPic=").append(headPic);
        sb.append(", name=").append(name);
        sb.append(", dharma=").append(dharma);
        sb.append(", sex=").append(sex);
        sb.append(", provicnce=").append(provicnce);
        sb.append(", city=").append(city);
        sb.append(", status=").append(status);
        sb.append(", regDate=").append(regDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}