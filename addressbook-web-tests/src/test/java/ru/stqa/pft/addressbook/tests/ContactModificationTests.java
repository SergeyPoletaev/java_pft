package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @Test
  public  void testContactModification() {
    if(! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Василий", null, "Петров", "hobart", "1-2-3", "ООО Элекит", "Пересвет, ул.Ленина д.5", "+74994031017", "+79035540414", "+74994031057", "+74994569878", "123@test.ru", "456@test.ru", "789@test.ru", "http:/220-test.ru"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();

    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().selectEditContact(before.size() - 1);
    ContactData contact = new ContactData(before.get(before.size() - 1).getId(),"Вася", null, "Абакумов", "hobart", "1-2-3", "ООО Элекит", "Пересвет, ул.Ленина д.5", "+74994031017", "+79035540414", "+74994031057", "+74994569878", "123@test.ru", "456@test.ru", "789@test.ru", "http:/220-test.ru");
    app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();

    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());
    before.remove(before.size() - 1);
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }
}
