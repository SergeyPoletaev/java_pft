package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    Set<ContactData> before = app.contact().all();
    ContactData contact = new ContactData()
            .whisFirstname("Зая").whisLastname("Петрухин").whisMiddlename("Котёночек").whisNickname("hobart").whisTitle("1-2-3")
            .whisCompany("ООО Элекит").whisAddress("Пересвет, ул.Ленина д.5").whisHome("+74994031017").whisMobile("+79035540414")
            .whisWork("+74994031057").whisFax("+74994569878").whisEmail("123@test.ru").whisEmail2("456@test.ru")
            .whisEmail3("789@test.ru").whisHomepage("http:/220-test.ru");
    app.contact().create(contact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.whisId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);
  }
}
