package org.backend.shopping.domains;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * The persistent class for the authority database table.
 *
 */
/*@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor*/
@Entity
@Table(name="authority")
@NamedQuery(name="Authority.findAll", query="SELECT e FROM Authority e")
public class Authority  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="authority_id")
    private BigDecimal id;

    @Column(name="authority_name")
    private String name;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
