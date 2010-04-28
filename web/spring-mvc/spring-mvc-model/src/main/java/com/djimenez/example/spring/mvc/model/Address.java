package com.djimenez.example.spring.mvc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableProperty;

import com.djimenez.example.spring.mvc.constants.JpaConstants;

/**
 * This class is used to represent an address with address, city, province and
 * postal-code information.
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
@Embeddable
@Searchable(root = false)
public class Address extends BaseObject implements Serializable {

  private static final int CODE = 29;
  private static final long serialVersionUID = 3617859655330969141L;
  private String address;
  private String city;
  private String province;
  private String country;
  private String postalCode;

  /**
   * Overridden equals method for object comparison. Compares based on hashCode.
   * 
   * @param o
   *          Object to compare
   * @return true/false based on hashCode
   */
  @Override
  public final boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Address)) {
      return false;
    }

    final Address address1 = (Address) o;

    return this.hashCode() == address1.hashCode();
  }

  @Column(length = JpaConstants.DESCRIPTION_LENGTH)
  @SearchableProperty
  public final String getAddress() {
    return address;
  }

  @Column(length = JpaConstants.NAME_LONG_LENGTH)
  @SearchableProperty
  public final String getCity() {
    return city;
  }

  @Column(length = JpaConstants.NAME_LONG_LENGTH)
  @SearchableProperty
  public final String getCountry() {
    return country;
  }

  @Column(name = "postal_code", length = JpaConstants.NAME_LENGTH)
  @SearchableProperty
  public final String getPostalCode() {
    return postalCode;
  }

  @Column(length = JpaConstants.NAME_LONG_LENGTH)
  @SearchableProperty
  public final String getProvince() {
    return province;
  }

  /**
   * Overridden hashCode method - compares on address, city, province, country
   * and postal code.
   * 
   * @return hashCode
   */
  @Override
  public final int hashCode() {
    int result;
    result = (address != null ? address.hashCode() : 0);
    result = CODE * result + (city != null ? city.hashCode() : 0);
    result = CODE * result + (province != null ? province.hashCode() : 0);
    result = CODE * result + (country != null ? country.hashCode() : 0);
    result = CODE * result + (postalCode != null ? postalCode.hashCode() : 0);
    return result;
  }

  public final void setAddress(final String address) {
    this.address = address;
  }

  public final void setCity(final String city) {
    this.city = city;
  }

  public final void setCountry(final String country) {
    this.country = country;
  }

  public final void setPostalCode(final String postalCode) {
    this.postalCode = postalCode;
  }

  public final void setProvince(final String province) {
    this.province = province;
  }

  /**
   * Returns a multi-line String with key=value pairs.
   * 
   * @return a String representation of this class.
   */
  @Override
  public final String toString() {
    return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append(
      "country", this.country).append("address", this.address).append(
      "province", this.province).append("postalCode", this.postalCode).append(
      "city", this.city).toString();
  }
}
