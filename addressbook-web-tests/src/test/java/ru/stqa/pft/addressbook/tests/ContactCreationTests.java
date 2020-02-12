package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    Contacts before = app.contact().all();
    ContactData contact = new ContactData()
            .withFirstname("Зая").withLastname("Петрухин").withMiddlename("Котёночек").withNickname("hobart").withTitle("1-2-3")
            .withCompany("ООО Элекит").withAddress("Пересвет, ул.Ленина д.5").withHome("+74994031017").withMobile("+79035540414")
            .withWork("+74994031057").withFax("+74994569878").withEmail("123@test.ru").withEmail2("456@test.ru")
            .withEmail3("789@test.ru").withHomepage("http:/220-test.ru");
    app.contact().create(contact);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }
}
