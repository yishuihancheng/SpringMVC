package edu.scu.cs.tlzhang.redis.serilazation;

import com.alibaba.fastjson.JSONObject;
import edu.scu.cs.tlzhang.entity.Person;
import edu.scu.cs.tlzhang.helper.SpringContextHelper;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JacksonJsonRedisSerializer;
import org.springframework.data.redis.serializer.OxmSerializer;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import javax.xml.bind.Marshaller;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tlzhang on 2016/11/25.
 */
public class SerializationTest {
    private static String jdkSerialization = "test:entity:jdk:person";
    private static String strSerialization = "test:entity:str:person";
    private static String jacksonSerialization = "test:entity:json:person";
    private static String xmlSerialization = "test:entity:xml:person";
    public static void jdkSerization(Person person){
        RedisTemplate redisTemplate = (RedisTemplate)SpringContextHelper.getBean("jdkRedisTemplate");
        BoundValueOperations valueOperations = redisTemplate.boundValueOps(jdkSerialization);
        valueOperations.set(person);
    }

    public static void strSerialization(Person person){
        RedisTemplate redisTemplate = (RedisTemplate)SpringContextHelper.getBean("strRedisTemplate");
        BoundValueOperations valueOperations = redisTemplate.boundValueOps(strSerialization);
        String json = JSONObject.toJSONString(person);
        System.out.println("json..." + json);
        valueOperations.set(json);
    }

    public static void jacksonSerialization(Person person){
        RedisTemplate redisTemplate = (RedisTemplate)SpringContextHelper.getBean("jacksonRedisTemplate");
        redisTemplate.setValueSerializer(new JacksonJsonRedisSerializer<Person>(Person.class));
        BoundValueOperations valueOperations = redisTemplate.boundValueOps(jacksonSerialization);
        valueOperations.set(person);
    }

    public static void xmlSerialization(Person person){
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        Map<String,Object> properties = new HashMap<String, Object>();//创建映射，用于设置Marshaller属性
        properties.put(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);   //放置xml自动缩进属性
        properties.put(Marshaller.JAXB_ENCODING,"utf-8");   //放置xml自动缩进属性
        jaxb2Marshaller.setClassesToBeBound(Person.class);//映射的xml类放入JAXB环境中
        jaxb2Marshaller.setMarshallerProperties(properties);//设置Marshaller属性
        OxmSerializer oxmSerializer = new OxmSerializer(jaxb2Marshaller,jaxb2Marshaller);
        RedisTemplate redisTemplate = (RedisTemplate)SpringContextHelper.getBean("xmlRedisTemplate");
        redisTemplate.setValueSerializer(oxmSerializer);
        BoundValueOperations valueOperations = redisTemplate.boundValueOps(xmlSerialization);
        valueOperations.set(person);
    }
}
