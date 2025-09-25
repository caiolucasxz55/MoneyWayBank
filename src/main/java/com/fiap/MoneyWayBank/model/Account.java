package com.fiap.MoneyWayBank.model;

import com.fiap.MoneyWayBank.types.AccountType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Positive(message = "{account.number.positive}")
    @NotNull(message = "{account.number.notblank}")
    private int number;

    @NotBlank(message = "{account.agency.notblank}")
    private String agency;

    @NotBlank(message = "{account.name.notblank}")
    private String nameHolder;

    @NotBlank(message = "{account.cpf.notblank}")
    @Size(min = 11, max = 14, message = "{account.cpf.size}")
    private String cpfHolder;

    @PastOrPresent(message = "{account.date.pastOrPresent}")
    @NotNull(message = "{account.date.notnull}")
    private LocalDate openingDate;

    @PositiveOrZero(message = "{account.balance.positiveOrZero}")
    @NotNull(message = "{account.balance.notnull}")
    private BigDecimal balance;

    private boolean active = true; 

    @Enumerated(EnumType.STRING)
    @NotNull(message = "{account.type.notnull}")
    private AccountType type;
}
