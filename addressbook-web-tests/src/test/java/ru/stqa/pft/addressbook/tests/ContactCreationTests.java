package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    List<ContactData> before = app.contact().list();
    ContactData contact = new ContactData()
            .whisFirstname("Игнат").whisLastname("Васин").whisMiddlename("Котёночек").whisNickname("hobart").whisTitle("1-2-3")
            .whisCompany("ООО Элекит").whisAddress("Пересвет, ул.Ленина д.5").whisHome("+74994031017").whisMobile("+79035540414")
            .whisWork("+74994031057").whisFax("+74994569878").whisEmail("123@test.ru").whisEmail2("456@test.ru")
            .whisEmail3("789@test.ru").whisHomepage("http:/220-test.ru");
    app.contact().create(contact);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
