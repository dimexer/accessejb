package com.dimexer.ee.accessejb;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.dimexer.ee.myejbs.HelloEJB;

public class App {
	public static void main(String[] args) {
		try {
			Properties jndiProps = new Properties();
			jndiProps.put(Context.INITIAL_CONTEXT_FACTORY,
					"org.jboss.naming.remote.client.InitialContextFactory");
			jndiProps.put(Context.PROVIDER_URL, "remote://127.0.0.1:4447");
			jndiProps.put(Context.SECURITY_PRINCIPAL, "username");
			jndiProps.put(Context.SECURITY_CREDENTIALS, "password");
			jndiProps.put("jboss.naming.client.ejb.context", "true");
			Context ic = new InitialContext(jndiProps);
			HelloEJB he = (HelloEJB) ic
					.lookup("java:/myejbs/HelloEJBImpl!com.dimexer.ee.myejbs.HelloEJB");
			System.out.println(he.sayHello("Dimo"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
