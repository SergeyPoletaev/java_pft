package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public  void testContactModification() {
    if(! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Василий", "Вася", "Петров", "hobart", "1-2-3", "ООО Элекит", "Пересвет, ул.Ленина д.5", "+74994031017", "+79035540414", "+74994031057", "+74994569878", "123@test.ru", "456@test.ru", "789@test.ru", "http:/220-test.ru"));
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().selectEditContact();
    app.getContactHelper().fillContactForm(new ContactData("Василий", "Вася", "Петров", "hobart", "1-2-3", "ООО Элекит", "Пересвет, ул.Ленина д.5", "+74994031017", "+79035540414", "+74994031057", "+74994569878", "123@test.ru", "456@test.ru", "789@test.ru", "http:/220-test.ru"));
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
  }
}
