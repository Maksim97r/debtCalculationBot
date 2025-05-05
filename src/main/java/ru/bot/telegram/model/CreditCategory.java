package ru.bot.telegram.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "credit_category",
        uniqueConstraints = {
        @UniqueConstraint(columnNames = "credit_name")})
public class CreditCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "credit_name")
    private String creditName;

    @Column(name = "debt")
    private BigDecimal debt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditCategory category = (CreditCategory) o;
        return Objects.equals(creditName, category.creditName) && Objects.equals(debt, category.debt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creditName, debt);
    }

    @Override
    public String toString() {
        return creditName + " = " + debt.toString();
    }
}