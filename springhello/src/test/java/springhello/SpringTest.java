package springhello;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class SpringTest {

	@Test
	void test() {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");	// a differenza del singleton, in prototype si genera l'instanza del bean solo quando viene chiamato
																								//perche è a generazione LAZY. Anche in singleton è possibile, ma verrà generato solo una volta
		System.out.println("ctx: " + ctx);
		User u = ctx.getBean(User.class);
		System.out.println("getBean per classe: " + u);
		
		User u1 = ctx.getBean("u1", User.class);
		System.out.println("getBean per nome/id: " + u1);
		
		User u1bis = ctx.getBean("u1", User.class);
		System.out.println("getBean per nome/id: " + u1);
		
		Map<String, User> res = ctx.getBeansOfType(User.class);
		for(User user: res.values()) {
			System.out.println(user);
		}
	}

}
