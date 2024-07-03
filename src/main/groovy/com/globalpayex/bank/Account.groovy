package com.globalpayex.bank

class Account {
    String accNo
    String accType
    BigDecimal balance

    BigDecimal withdraw(double amt) {
        this.balance -= amt
    }

    BigDecimal deposit(double amt) {
        this.balance += amt
    }
}
