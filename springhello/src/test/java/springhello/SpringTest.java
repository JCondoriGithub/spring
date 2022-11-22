package springhello;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

class SpringTest {

	@Test
	void test() {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		FileSystemXmlApplicationContext ctx2 = new FileSystemXmlApplicationContext(new String[] {"file:/home/josue/Scrivania/spring/testContext/beans.xml"}, ctx);	// si dichiara che questo container deriva da "ctx"

		User u1 = ctx2.getBean("u1", User.class);
		System.out.println("u1: " + u1);
		
		User u2 = ctx2.getBean("u2", User.class);
		System.out.println("u2: " + u2);
		
		ctx.close();
	}
}
