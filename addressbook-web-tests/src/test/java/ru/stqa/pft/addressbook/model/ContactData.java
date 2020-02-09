package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private int  id;
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String nickname;
  private final String title;
  private final String company;
  private final String address;
  private final String home;
  private final String mobile;
  private final String work;
  private final String fax;
  private final String email;
  private final String email2;
  private final String email3;
  private final String homepage;

  public ContactData(String firstname, String middlename, String lastname, String nickname, String title, String company, String address, String home, String mobile, String work, String fax, String email, String email2, String email3, String homepage) {
    this.id = Integer.MAX_VALUE;
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nickname = nickname;
    this.title = title;
    this.company = company;
    this.address = address;
    this.home = home;
    this.mobile = mobile;
    this.work = work;
    this.fax = fax;
    this.email = email;
    this.email2 = email2;
    this.email3 = email3;
    this.homepage = homepage;
  }

  public ContactData(int id, String firstname, String middlename, String lastname, String nickname, String title, String company, String address, String home, String mobile, String work, String fax, String email, String email2, String email3, String homepage) {
    this.id = id;
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nickname = nickname;
    this.title = title;
    this.company = company;
    this.address = address;
    this.home = home;
    this.mobile = mobile;
    this.work = work;
    this.fax = fax;
    this.email = email;
    this.email2 = email2;
    this.email3 = email3;
    this.homepage = homepage;
  }

  public void setId(int id) {
    this.id = id;
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
