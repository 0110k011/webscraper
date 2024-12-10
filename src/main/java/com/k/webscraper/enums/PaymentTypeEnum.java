package com.k.webscraper.enums;

public enum PaymentTypeEnum {
    CASH(1),
    CHECK(2),
    CREDIT_CARD(3),
    DEBIT_CARD(4),
    STORE_CREDIT(5),
    FOOD_ALLOWANCE(10),
    MEAL_VOUCHER(11),
    GIFT_CARD(12),
    FUEL_VOUCHER(13),
    BANK_BILL(15),
    BANK_DEPOSIT(16),
    INSTANT_PAYMENT_PIX(17),
    BANK_TRANSFER_DIGITAL_WALLET(18);

    private final int type;

    PaymentTypeEnum(int value) {
        this.type = value;
    }

    public static PaymentTypeEnum fromValue(int value) {
        for (PaymentTypeEnum paymentType : PaymentTypeEnum.values()) {
            if (paymentType.type == value) {
                return paymentType;
            }
        }
        return null;
    }

}
