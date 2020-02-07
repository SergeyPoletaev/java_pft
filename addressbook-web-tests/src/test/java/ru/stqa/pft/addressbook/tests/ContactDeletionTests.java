package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() {
    if(! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Василий", "Вася", "Петров", "hobart", "1-2-3", "ООО Элекит", "Пересвет, ул.Ленина д.5", "+74994031017", "+79035540414", "+74994031057", "+74994569878", "123@test.ru", "456@test.ru", "789@test.ru", "http:/220-test.ru"));
    }
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().selectContact(before - 1);
    app.getContactHelper().deleteSelectedGroups();
    app.getContactHelper().assertTrueDeleteSelectedGroups();
    app.getContactHelper().returnToHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before - 1);
  }
}
