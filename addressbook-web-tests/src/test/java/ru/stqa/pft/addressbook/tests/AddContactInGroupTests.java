package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class AddContactInGroupTests extends TestBase {
  private ContactData targetC;
  private GroupData targetG;


  @BeforeMethod
  public void ensurePrecondition() {
    // наличия хотябы одного контакта
    if (app.db().contacts().size() == 0) {
      app.contact().create(new ContactData().withFirstname("Игнат").withLastname("Васин"));
    }
    // проверка наличия хотябы одной группы
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1"));
    }
    // проверка что существуют контакты, которые можно добавить в группу
    Contacts contactsSet = app.db().contacts();
    Groups groupsSet = app.db().groups();
    for (ContactData contact : contactsSet) {
      for (GroupData group : groupsSet) {
        if (!contact.getGroups().contains(group)) {
          targetC = contact;
          targetG = group;
          return;
        }
      }
    }
    if (targetC == null && targetG == null) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test10"));
    }
  }


  @Test
  public void testAddContactInGroup() {
    Groups groups = app.db().groups();
    Contacts contacts = app.db().contacts();
    app.goTo().homePage();
    app.contact().selectContactById(contacts.iterator().next().getId());
    app.contact().addContactInGroup(groups);
  }
}