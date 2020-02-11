package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private int  id = Integer.MAX_VALUE;
  private  String firstname;
  private  String middlename;
  private  String lastname;
  private  String nickname;
  private  String title;
  private  String company;
  private  String address;
  private  String home;
  private  String mobile;
  private  String work;
  private  String fax;
  private  String email;
  private  String email2;
  private  String email3;
  private  String homepage;

  public ContactData whisId(int id) {
    this.id = id;
    return this;
  }

  public ContactData whisFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public ContactData whisMiddlename(String middlename) {
    this.middlename = middlename;
    return this;
  }

  public ContactData whisLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactData whisNickname(String nickname) {
    this.nickname = nickname;
    return this;
  }

  public ContactData whisTitle(String title) {
    this.title = title;
    return this;
  }

  public ContactData whisCompany(String company) {
    this.company = company;
    return this;
  }

  public ContactData whisAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData whisHome(String home) {
    this.home = home;
    return this;
  }

  public ContactData whisMobile(String mobile) {
    this.mobile = mobile;
    return this;
  }

  public ContactData whisWork(String work) {
    this.work = work;
    return this;
  }

  public ContactData whisFax(String fax) {
    this.fax = fax;
    return this;
  }

  public ContactData whisEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactData whisEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public ContactData whisEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public ContactData whisHomepage(String homepage) {
    this.homepage = homepage;
    return this;
  }

  public int  getId() {
    return id;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNickname() {
    return nickname;
  }

  public String getTitle() {
    return title;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getHome() {
    return home;
  }

  public String getMobile() {
    return mobile;
  }

  public String getWork() {
    return work;
  }

  public String getFax() {
    return fax;
  }

  public String getEmail() {
    return email;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public String getHomepage() {
    return homepage;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(firstname, that.firstname) &&
            Objects.equals(lastname, that.lastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstname, lastname);
  }
}
