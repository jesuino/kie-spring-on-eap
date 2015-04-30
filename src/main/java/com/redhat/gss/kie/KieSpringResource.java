package com.redhat.gss.kie;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.kie.api.definition.KiePackage;
import org.kie.api.runtime.KieSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Path("/")
public class KieSpringResource {

	@GET
	public void test() {
		System.out.println("Starting...");
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"com/redhat/gss/kie/kmodule-spring.xml");
		KieSession kieSession = (KieSession) ctx.getBean("kieSession");
		kieSession.fireAllRules();
		kieSession.dispose();

	}

}
