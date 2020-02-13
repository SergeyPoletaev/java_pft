package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactEmailTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition() {
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstname("Игнат").withLastname("Васин")
              .withEmail("100@fg.com").withEmail2("200@as.hj").withEmail3("300@ty.fh"));
    }
  }

    @Test
    public void testContactEmails () {
      app.goTo().gotoHomePage();
      ContactData contact = app.contact().all().iterator().next();
      ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
      assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
    }


    private String mergeEmails (ContactData contact){
      return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
              .stream().filter((s) -> !s.equals(""))
              .map(ContactEmailTests::cleaned)
              .collect(Collectors.joining("\n"));
    }

    public static String cleaned (String email){
      return email.replaceAll("\\s", "").replaceAll("[-()]", "");
    }
}