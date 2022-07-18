package com.example.testspringboot.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;

@Entity
@Table(name = "SUBSCRIPTION")
public class Subscription {

  @Column(name = "MOBILENUMBER", length = 50)
  private String mobileNumber ;

  @Column(name = "CUSTOMERNUMBER", length = 50 )
  private String customerNumber;

  @Id
  @Column(name = "ACCOUNTNUMBER", length = 50 , nullable = false)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCOUNT_SEQUENCE")
  @SequenceGenerator(name = "ACCOUNT_SEQUENCE", initialValue = 300)
  private int accountNumber;

  @Column(name = "PRODUCTID", length = 50)
  private String productId;

  @Column(name = "PRODUCTNAME", length = 50)
  private String productName;

  @Column(name = "ORDERCREATIONDATE", columnDefinition = "TIMESTAMP", precision = 9)
  @JsonFormat(pattern = "yyyy-MM-dd-HH.mm.ss", shape = JsonFormat.Shape.STRING)
  private String creationDate;

  public int getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(int accountNumber) {
    this.accountNumber = accountNumber;
  }

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public String getMobileNumber() {
    return mobileNumber;
  }

  public void setMobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  public String getCustomerNumber() {
    return customerNumber;
  }

  public void setCustomerNumber(String customerNumber) {
    this.customerNumber = customerNumber;
  }

  public String getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(String creationDate) {
    this.creationDate = creationDate;
  }

}
