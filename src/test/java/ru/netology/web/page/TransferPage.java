package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TransferPage {
    private SelenideElement transferHead = $(byText("Пополнение карты"));
    private SelenideElement amountInput = $("[data-test-id=amount] input");
    private SelenideElement fromInput = $("[data-test-id=from] input");
    private SelenideElement transferButtun = $("[data-test-id=action-transfer]");
    private SelenideElement errorMassage = $("[data-test-id=error-massage]");

    public TransferPage() {

        transferHead.shouldBe(visible);
    }

    public DashboardPage makeTransfer(String amount, DataHelper.CardInfo firstCardInfo) {
        validTransfer(amount, firstCardInfo);
        return new DashboardPage();
    }

    public void validTransfer(String amount, DataHelper.CardInfo cardInfo) {
        amountInput.setValue(amount);
        fromInput.setValue(cardInfo.getNumber());
        transferButtun.click();
    }
    public void findErrorMassage(String expectedtext){
        errorMassage.shouldHave(exactText(expectedtext), Duration.ofSeconds(15)).shouldBe(visible);

    }

}

