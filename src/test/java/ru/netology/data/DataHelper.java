package ru.netology.data;

import lombok.*;


public class DataHelper {

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    @Value
    public static class VerificationCode {
        private String code;
    }

    public static VerificationCode getVerificationCode(AuthInfo authInfo) {
        return new VerificationCode("12345");
    }

    @Value
    public static class Card {
        private String number;

        public static Card getFirstCardInfo() {
            return new Card("5559 0000 0000 0001");
        }

        public static Card getSecondCardInfo() {
            return new Card("5559 0000 0000 0002");
        }

        public static Card getWrongCardInfo() {
            return new Card("5559 0000 0000 0003");
        }

        public static int cardBalanceAfterSendMoney(int balance, int amount) {
            int total = balance - amount;
            return total;
        }

        public static int cardBalanceAfterGetMoney(int balance, int amount) {
            int total = balance + amount;
            return total;
        }
    }
}
