package edu.scu.cs.tlzhang.redis.serilazation;

import edu.scu.cs.tlzhang.entity.Person;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring_context.xml", "classpath:spring_redis.xml"})
public class SerializationTestTest extends TestCase {

    @Test
    public void testJdkSerization() throws Exception {
        Person person = new Person();
        person.setId("1");
        person.setName("jdk");
        person.setAge(18);
        SerializationTest.jdkSerization(person);
    }

    @Test
    public void testStrSerialization() throws Exception {
        Person person = new Person();
        person.setId("2");
        person.setName("string");
        person.setAge(18);
        SerializationTest.strSerialization(person);
    }

    @Test
    public void testJacksonSerialization() throws Exception {
        Person person = new Person();
        person.setAge(19);
        person.setId("3");
        person.setName("jackson");
        SerializationTest.jacksonSerialization(person);
    }

    @Test
    public void testXmlSerialization() throws Exception {
        Person person = new Person();
        person.setAge(20);
        person.setId("4");
        person.setName("xml");
        SerializationTest.xmlSerialization(person);
    }
}