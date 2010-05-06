package com.djimenez.castor.example.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import junit.framework.TestCase;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;

import com.djimenez.castor.example.Person;
import com.djimenez.util.file.FileUtil;

public class XmlPersonTest extends TestCase {

  public void testCreatePerson() throws MarshalException, ValidationException,
    IOException {
    // -- create a person to work with
    final Person person =
      new Person("Bob Harris", "123 Foo Street", "222-222-2222",
        "bob@harris.org", "(123) 123-1234", "(123) 123-1234");

    // -- marshal the person object out as a <person>
    final FileWriter file = new FileWriter("target/bob_person.xml");
    Marshaller.marshal(person, file);
    file.close();

    final Person personRetrieved =
      (Person) Unmarshaller.unmarshal(Person.class, new FileReader(
        "target/bob_person.xml"));

    assertEquals(person, personRetrieved);

  }

  public void testModifyPerson() throws MarshalException, ValidationException,
    IOException {

    FileUtil.delete("target/person.xml");

    FileUtil.copy("src/main/resources/common/person-data.xml",
      "target/person.xml");

    final Person person =
      (Person) Unmarshaller.unmarshal(Person.class, new FileReader(
        "target/person.xml"));
    // -- change the name
    person.setName("David Beckham");

    // -- marshal the changed person back to disk
    final FileWriter file = new FileWriter("target/personModified.xml");
    Marshaller.marshal(person, file);
    file.close();
  }

  public void testReadPerson() throws MarshalException, ValidationException,
    FileNotFoundException {

    final Person person =
      (Person) Unmarshaller.unmarshal(Person.class, new FileReader(
        "src/main/resources/common/person-data.xml"));

    System.out.println("Person Attributes");
    System.out.println("-----------------");
    System.out.println("Name: " + person.getName());
    System.out.println("Address: " + person.getAddress());
    System.out.println("SSN: " + person.getSsn());
    System.out.println("Email: " + person.getEmail());
    System.out.println("Home Phone: " + person.getHomePhone());
    System.out.println("Work Phone: " + person.getWorkPhone());
  }
}
