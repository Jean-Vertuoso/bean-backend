package br.com.bean.infrastructure.entities;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Phone implements Serializable {

    private String areaCode;
    private String number;

    public Phone() {
    }

    public Phone(String areaCode, String number) {
        this.areaCode = areaCode;
        this.number = number;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return Objects.equals(areaCode, phone.areaCode) && Objects.equals(number, phone.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(areaCode, number);
    }
}
