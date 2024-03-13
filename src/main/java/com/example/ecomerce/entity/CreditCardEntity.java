package com.example.ecomerce.entity;

import com.example.ecomerce.enums.CreditCardStatus;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "creditcard")
public class CreditCardEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String cardNumber;

    @Column(nullable = false)
    private int expMonth;

    @Column(nullable = false)
    private int expYear;

    @Column(length = 4, nullable = false)
    private int cvcCode;

    @Column
    private double balance;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private CreditCardStatus status;

    @OneToMany(mappedBy = "creditCard", cascade = CascadeType.ALL )
    private List<PaymentEntity> payment;

    public CreditCardEntity() {
        // TODO Auto-generated constructor stub
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getExpMonth() {
        return expMonth;
    }

    public void setExpMonth(int expMonth) {
        this.expMonth = expMonth;
    }

    public int getExpYear() {
        return expYear;
    }

    public void setExpYear(int expYear) {
        this.expYear = expYear;
    }

    public int getCvcCode() {
        return cvcCode;
    }

    public void setCvcCode(int cvcCode) {
        this.cvcCode = cvcCode;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public CreditCardStatus getStatus() {
        return status;
    }

    public void setStatus(CreditCardStatus status) {
        this.status = status;
    }

    public List<PaymentEntity> getPayment() {
        return payment;
    }

    public void setPayment(List<PaymentEntity> payment) {
        this.payment = payment;
    }


}
