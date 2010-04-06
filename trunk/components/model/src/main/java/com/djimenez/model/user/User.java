package com.djimenez.model.user;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by IntelliJ IDEA. User: mjimenez Date: 01-ago-2007 Time: 10:28:04
 */

@Entity
@Table(name = "users")
public class User {

  protected Long id;

  protected String name;

  protected String description;

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

  /*
   * (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final User other = (User) obj;
    if (active != other.active) {
      return false;
    }
    if (activeDate == null) {
      if (other.activeDate != null) {
        return false;
      }
    }
    else
      if (!activeDate.equals(other.activeDate)) {
        return false;
      }
    if (address == null) {
      if (other.address != null) {
        return false;
      }
    }
    else
      if (!address.equals(other.address)) {
        return false;
      }
    if (bornDate == null) {
      if (other.bornDate != null) {
        return false;
      }
    }
    else
      if (!bornDate.equals(other.bornDate)) {
        return false;
      }
    if (email == null) {
      if (other.email != null) {
        return false;
      }
    }
    else
      if (!email.equals(other.email)) {
        return false;
      }
    if (firstSurname == null) {
      if (other.firstSurname != null) {
        return false;
      }
    }
    else
      if (!firstSurname.equals(other.firstSurname)) {
        return false;
      }
    if (id != other.id) {
      return false;
    }
    if (nacionality == null) {
      if (other.nacionality != null) {
        return false;
      }
    }
    else
      if (!nacionality.equals(other.nacionality)) {
        return false;
      }
    if (name == null) {
      if (other.name != null) {
        return false;
      }
    }
    else
      if (!name.equals(other.name)) {
        return false;
      }
    if (nif == null) {
      if (other.nif != null) {
        return false;
      }
    }
    else
      if (!nif.equals(other.nif)) {
        return false;
      }
    if (password == null) {
      if (other.password != null) {
        return false;
      }
    }
    else
      if (!password.equals(other.password)) {
        return false;
      }
    if (postalCode == null) {
      if (other.postalCode != null) {
        return false;
      }
    }
    else
      if (!postalCode.equals(other.postalCode)) {
        return false;
      }
    if (secondSurname == null) {
      if (other.secondSurname != null) {
        return false;
      }
    }
    else
      if (!secondSurname.equals(other.secondSurname)) {
        return false;
      }
    if (telephoneNumber == null) {
      if (other.telephoneNumber != null) {
        return false;
      }
    }
    else
      if (!telephoneNumber.equals(other.telephoneNumber)) {
        return false;
      }
    if (userName == null) {
      if (other.userName != null) {
        return false;
      }
    }
    else
      if (!userName.equals(other.userName)) {
        return false;
      }
    return true;
  }

  /**
   * @return the date
   */
  @Column
  public Date getActiveDate() {
    return activeDate;
  }

  /**
   * @return the address
   */
  public String getAddress() {
    return address;
  }

  /**
   * @return the fechaNac
   */
  @Column
  public Date getBornDate() {
    return bornDate;
  }

  @Column(length = 150)
  public String getDescription() {
    return description;
  }

  /**
   * @return the email
   */
  @Column
  public String getEmail() {
    return email;
  }

  /**
   * @return the firstSurname
   */
  @Column
  public String getFirstSurname() {
    return firstSurname;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long getId() {
    return id;
  }

  /**
   * @return the nacionalidad
   */
  @Column
  public String getNacionality() {
    return nacionality;
  }

  @Column(nullable = false, length = 50, unique = true)
  public String getName() {
    return name;
  }

  /**
   * @return the nif
   */
  @Column
  public String getNif() {
    return nif;
  }

  /**
   * @return the password
   */
  @Column
  public String getPassword() {
    return password;
  }

  /**
   * @return the codigoPostal
   */
  @Column
  public String getPostalCode() {
    return postalCode;
  }

  /**
   * @return the secondSurname
   */
  @Column
  public String getSecondSurname() {
    return secondSurname;
  }

  /**
   * @return the telephoneNumber
   */
  @Column
  public String getTelephoneNumber() {
    return telephoneNumber;
  }

  /**
   * @return the userName
   */
  @Column
  public String getUserName() {
    return userName;
  }

  /*
   * (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (active ? 1231 : 1237);
    result =
      prime * result + ((activeDate == null) ? 0 : activeDate.hashCode());
    result = prime * result + ((address == null) ? 0 : address.hashCode());
    result = prime * result + ((bornDate == null) ? 0 : bornDate.hashCode());
    result = prime * result + ((email == null) ? 0 : email.hashCode());
    result =
      prime * result + ((firstSurname == null) ? 0 : firstSurname.hashCode());
    result = (int) (prime * result + id);
    result =
      prime * result + ((nacionality == null) ? 0 : nacionality.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((nif == null) ? 0 : nif.hashCode());
    result = prime * result + ((password == null) ? 0 : password.hashCode());
    result =
      prime * result + ((postalCode == null) ? 0 : postalCode.hashCode());
    result =
      prime * result + ((secondSurname == null) ? 0 : secondSurname.hashCode());
    result =
      prime * result
        + ((telephoneNumber == null) ? 0 : telephoneNumber.hashCode());
    result = prime * result + ((userName == null) ? 0 : userName.hashCode());
    return result;
  }

  /**
   * @return the active
   */
  public boolean isActive() {
    return active;
  }

  /**
   * @param active
   *          the active to set
   */
  public void setActive(final boolean active) {
    this.active = active;
  }

  /**
   * s
   * 
   * @param date
   *          the date to set
   */
  public void setActiveDate(final Date date) {
    this.activeDate = date;
  }

  /**
   * @param address
   *          the address to set
   */
  public void setAddress(final String address) {
    this.address = address;
  }

  /**
   * @param fechaNac
   *          the fechaNac to set
   */
  public void setBornDate(final Date fechaNac) {
    this.bornDate = fechaNac;
  }

  public void setDescription(final String description) {
    this.description = description;
  }

  /**
   * @param email
   *          the email to set
   */
  public void setEmail(final String email) {
    this.email = email;
  }

  /**
   * @param firstSurname
   *          the firstSurname to set
   */
  public void setFirstSurname(final String firstSurname) {
    this.firstSurname = firstSurname;
  }

  /**
   * @param id
   *          the id to set
   */
  public void setId(final Long id) {
    this.id = id;
  }

  /**
   * @param nacionalidad
   *          the nacionalidad to set
   */
  public void setNacionality(final String nacionalidad) {
    this.nacionality = nacionalidad;
  }

  /**
   * @param name
   *          the name to set
   */
  public void setName(final String name) {
    this.name = name;
  }

  /**
   * @param nif
   *          the nif to set
   */
  public void setNif(final String nif) {
    this.nif = nif;
  }

  /**
   * @param password
   *          the password to set
   */
  public void setPassword(final String password) {
    this.password = password;
  }

  /**
   * @param codigoPostal
   *          the codigoPostal to set
   */
  public void setPostalCode(final String codigoPostal) {
    this.postalCode = codigoPostal;
  }

  /**
   * @param secondSurname
   *          the secondSurname to set
   */
  public void setSecondSurname(final String secondSurname) {
    this.secondSurname = secondSurname;
  }

  /**
   * @param telephoneNumber
   *          the telephoneNumber to set
   */
  public void setTelephoneNumber(final String telephoneNumber) {
    this.telephoneNumber = telephoneNumber;
  }

  /**
   * @param userName
   *          the userName to set
   */
  public void setUserName(final String userName) {
    this.userName = userName;
  }

  /*
   * (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "User [active=" + active + ", activeDate=" + activeDate
      + ", address=" + address + ", bornDate=" + bornDate + ", email=" + email
      + ", firstSurname=" + firstSurname + ", id=" + id + ", nacionality="
      + nacionality + ", name=" + name + ", nif=" + nif + ", password="
      + password + ", postalCode=" + postalCode + ", secondSurname="
      + secondSurname + ", telephoneNumber=" + telephoneNumber + ", userName="
      + userName + "]";
  }

}
