package ru.netology.service;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

class SelenideTest {
    String str = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));


    @Test
    void shouldSubmitFormSuccessfully() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $("[data-test-id=city] input").setValue("Москва");
        $("[data-test-id=date] input").setValue(str);
        $("[data-test-id=name] input").setValue("Романов Кирилл");
        $("[data-test-id=phone] input").setValue("+79134204422");
        $("[data-test-id=agreement]").click();
        $$("button").find(exactText("Забронировать")).click();
        $("[data-test-id=notification]").should(appear, Duration.ofSeconds(15));
        $("[data-test-id=date] input").setValue(str);


    }

}
