package com.djimenez.model.user;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.djimenez.model.constants.JpaConstants;

/**
 * Created by IntelliJ IDEA. User: mjimenez Date: 01-ago-2007 Time: 10:28:04
 */

@Entity
@Table(name = "users")
public class User {

  private Long id;

  private String name;

  private String description;

  private Date activeDate;

  private String userName;

  private String password;

  private String nif;

  private boolean active;

  private String firstSurname;

  private String secondSurname;

  private String address;

  private String email;

  private String telephoneNumber;

  private String postalCode;

  private String nacionality;

  private Date bornDate;

  /**
   * @return the date
   */
  @Column
  public final Date getActiveDate() {
    return activeDate;
  }

  /**
   * @return the address
   */
  public final String getAddress() {
    return address;
  }

  /**
   * @return the fechaNac
   */
  @Column
  public final Date getBornDate() {
    return bornDate;
  }

  @Column(length = JpaConstants.LENGTH_DESCRIPTION)
  public final String getDescription() {
    return description;
  }

  /**
   * @return the email
   */
  @Column
  public final String getEmail() {
    return email;
  }

  /**
   * @return the firstSurname
   */
  @Column
  public final String getFirstSurname() {
    return firstSurname;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public final Long getId() {
    return id;
  }

  /**
   * @return the nacionalidad
   */
  @Column
  public final String getNacionality() {
    return nacionality;
  }

  @Column(nullable = false, length = JpaConstants.DEFAULT_LENGTH, unique = true)
  public final String getName() {
    return name;
  }

  /**
   * @return the nif
   */
  @Column
  public final String getNif() {
    return nif;
  }

  /**
   * @return the password
   */
  @Column
  public final String getPassword() {
    return password;
  }

  /**
   * @return the codigoPostal
   */
  @Column
  public final String getPostalCode() {
    return postalCode;
  }

  /**
   * @return the secondSurname
   */
  @Column
  public final String getSecondSurname() {
    return secondSurname;
  }

  /**
   * @return the telephoneNumber
   */
  @Column
  public final String getTelephoneNumber() {
    return telephoneNumber;
  }

  /**
   * @return the userName
   */
  @Column
  public final String getUserName() {
    return userName;
  }

  /**
   * @return the active
   */
  public final boolean isActive() {
    return active;
  }

  /**
   * @param active
   *          the active to set
   */
  public final void setActive(final boolean active) {
    this.active = active;
  }

  /**
   * s
   * 
   * @param date
   *          the date to set
   */
  public final void setActiveDate(final Date date) {
    this.activeDate = date;
  }

  /**
   * @param address
   *          the address to set
   */
  public final void setAddress(final String address) {
    this.address = address;
  }

  /**
   * @param fechaNac
   *          the fechaNac to set
   */
  public final void setBornDate(final Date fechaNac) {
    this.bornDate = fechaNac;
  }

  public final void setDescription(final String description) {
    this.description = description;
  }

  /**
   * @param email
   *          the email to set
   */
  public final void setEmail(final String email) {
    this.email = email;
  }

  /**
   * @param firstSurname
   *          the firstSurname to set
   */
  public final void setFirstSurname(final String firstSurname) {
    this.firstSurname = firstSurname;
  }

  /**
   * @param id
   *          the id to set
   */
  public final void setId(final Long id) {
    this.id = id;
  }

  /**
   * @param nacionalidad
   *          the nacionalidad to set
   */
  public final void setNacionality(final String nacionalidad) {
    this.nacionality = nacionalidad;
  }

  /**
   * @param name
   *          the name to set
   */
  public final void setName(final String name) {
    this.name = name;
  }

  /**
   * @param nif
   *          the nif to set
   */
  public final void setNif(final String nif) {
    this.nif = nif;
  }

  /**
   * @param password
   *          the password to set
   */
  public final void setPassword(final String password) {
    this.password = password;
  }

  /**
   * @param codigoPostal
   *          the codigoPostal to set
   */
  public final void setPostalCode(final String codigoPostal) {
    this.postalCode = codigoPostal;
  }

  /**
   * @param secondSurname
   *          the secondSurname to set
   */
  public final void setSecondSurname(final String secondSurname) {
    this.secondSurname = secondSurname;
  }

  /**
   * @param telephoneNumber
   *          the telephoneNumber to set
   */
  public final void setTelephoneNumber(final String telephoneNumber) {
    this.telephoneNumber = telephoneNumber;
  }

  /**
   * @param userName
   *          the userName to set
   */
  public final void setUserName(final String userName) {
    this.userName = userName;
  }

  /*
   * (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public final String toString() {
    return "User [active=" + active + ", activeDate=" + activeDate
      + ", address=" + address + ", bornDate=" + bornDate + ", email=" + email
      + ", firstSurname=" + firstSurname + ", id=" + id + ", nacionality="
      + nacionality + ", name=" + name + ", nif=" + nif + ", password="
      + password + ", postalCode=" + postalCode + ", secondSurname="
      + secondSurname + ", telephoneNumber=" + telephoneNumber + ", userName="
      + userName + "]";
  }

}
