/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.odontosoftbackend.models;

import java.util.Date;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author CARLOGON
 *
 */
@Document
public class Patient {

    private String id;
    private String fullname;
    private String ci;
    private String marital_status;
    private Date birthday;
    private int age;
    private String gender;
    private String profession;
    private String address;
    private String phone;

    public Patient(String id, String fullname, String ci, String marital_status, Date birthday, int age, String gender, String profession, String address, String phone) {
        this.id = id;
        this.fullname = fullname;
        this.ci = ci;
        this.marital_status = marital_status;
        this.birthday = birthday;
        this.age = age;
        this.gender = gender;
        this.profession = profession;
        this.address = address;
        this.phone = phone;
    }

    public Patient() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getMarital_status() {
        return marital_status;
    }

    public void setMarital_status(String marital_status) {
        this.marital_status = marital_status;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
