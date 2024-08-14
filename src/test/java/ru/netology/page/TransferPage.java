package ru.netology.page;

import ru.netology.data.DataHelper;

import com.codeborne.selenide.SelenideElement;


import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class TransferPage {
    private SelenideElement sumField = $("[data-test-id='amount'] input");
    private SelenideElement fromField = $("[data-test-id='from'] input");
    private SelenideElement cardField = $("[data-test-id='to'] input");
    private SelenideElement sendButton = $("[data-test-id='action-transfer']");
    private SelenideElement cancelButton = $("[data-test-id='action-cancel']");
    private SelenideElement errorOne = $("[data-test-id='error-notification'] .notification__content");

    public void transfer(DataHelper.Card card, int amount) {
        sumField.setValue(String.valueOf(amount));
        fromField.setValue(card.getNumber());
        sendButton.click();
    }

    public void showAlertMessage(String text) {
        errorOne.shouldHave(exactText(text)).shouldBe(visible, Duration.ofSeconds(4));
    }
}
