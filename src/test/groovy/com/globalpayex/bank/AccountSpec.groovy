package com.globalpayex.bank

import spock.lang.Specification

class AccountSpec extends Specification {
    def "Withdraw"() {
        given:
        def account = new Account(accNo: 'ABC123',accType: 'Savings', balance: 10000)

        when:
        def actual = account.withdraw(6000)

        then:
        actual == 4000
//        account.balance == 4000
//        account.accType == 'Savings'
//        account.accNo == 'ABC123'

//        with(account) {
//            balance == 4000
//            accType == 'Savings'
//            accNo == 'ABC123'
//        }

        verifyAll(account) {
            balance == 4000
            accType == 'Savings'
            accNo == 'ABC123'
        }
    }

    def "Deposit"() {
        given:
        def account = new Account(accNo: 'ABC123',accType: 'Savings', balance: 10000)

        when:
        def actual = account.deposit(6000)

        then:
        actual == 16000

//        verifyAll(account) {
//            balance == 16000
//            accType == 'Savings'
//            accNo == 'ABC123'
//        }
        verify(account,16000,'Savings','ABC123')
    }

    void verify(Account account, pbalance, paccType, paccNumber) {
        assert account.accNo == paccNumber
        assert account.accType == paccType
        assert account.balance == pbalance
    }
}
