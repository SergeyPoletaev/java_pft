package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition() {
    if(app.db().contacts().size() == 0) {
      app.contact().create(new ContactData().withFirstname("Игнат").withLastname("Васин")
             /*.withPhoto(new File("src/test/resources/stru.png")).withGroup("test 0")*/);
    }
  }

  @Test
  public  void testContactModification() {
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId())
            .withFirstname("Игнат").withLastname("Васин").withMiddlename("Котёночек")
            .withNickname("hobart").withTitle("1-2-3")
            .withCompany("ООО Элекит").withAddress("Пересвет, ул.Ленина д.5").withHome("+74994031017").withMobile("+79035540414")
            .withWork("+74994031057").withFax("+74994569878").withEmail("123@test.ru").withEmail2("456@test.ru")
            .withEmail3("789@test.ru").withHomepage("http:/220-test.ru").withPhoto(new File("src/test/resources/stru.png"));
    app.contact().modify(contact);
    Contacts after = app.db().contacts();
    assertEquals(after.size(), before.size());
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    verifyContactListInUi();
  }
}
