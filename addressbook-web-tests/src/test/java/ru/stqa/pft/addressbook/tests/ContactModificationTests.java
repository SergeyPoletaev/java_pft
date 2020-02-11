package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.Set;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition() {
    if(app.contact().all().size() == 0) {
      app.contact().create(new ContactData().whisFirstname("Игнат").whisLastname("Васин"));
    }
  }

  @Test
  public  void testContactModification() {
    Set<ContactData> before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .whisId(modifiedContact.getId())
            .whisFirstname("Игнат").whisLastname("Васин").whisMiddlename("Котёночек").whisNickname("hobart").whisTitle("1-2-3")
            .whisCompany("ООО Элекит").whisAddress("Пересвет, ул.Ленина д.5").whisHome("+74994031017").whisMobile("+79035540414")
            .whisWork("+74994031057").whisFax("+74994569878").whisEmail("123@test.ru").whisEmail2("456@test.ru")
            .whisEmail3("789@test.ru").whisHomepage("http:/220-test.ru");
    app.contact().modify(contact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(before, after);
  }
}
