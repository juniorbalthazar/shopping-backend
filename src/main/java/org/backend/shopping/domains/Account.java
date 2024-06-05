package org.backend.shopping.domains;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the account database table.
 *
 */
//@Data
/*@Builder
@NoArgsConstructor
@AllArgsConstructor*/
@Entity
@Table(name="account")
@NamedQuery(name="Account.findAll", query="SELECT e FROM Account e")
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="account_id")
    private BigDecimal id;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="is_active")
    private boolean active;

    @ManyToOne
    @JoinColumn(name="authority_id")
    private Authority authority;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Costumers costumer;

    @Temporal(TemporalType.DATE)
    @Column(name="created_by")
    private BigDecimal createdBy;


    @Column(name="created_date")
    private Date createdDate;

    @Temporal(TemporalType.DATE)
    @Column(name="update_by")
    private BigDecimal updatedBy;


    @Column(name="update_date")
    private Date updatedDate;


    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }

    public Costumers getCostumer() {
        return costumer;
    }

    public void setCostumer(Costumers costumer) {
        this.costumer = costumer;
    }

    public BigDecimal getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(BigDecimal createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public BigDecimal getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(BigDecimal updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}
