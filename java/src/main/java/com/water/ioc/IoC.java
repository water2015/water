package com.water.ioc;

import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class IoC {
	public static void main(String[] args) {
		BeanFactory beanFactory = new BeanFactory();
		beanFactory.init("/config.xml");

		UserBean userBean = (UserBean) beanFactory.getBean("userBean");
		System.out.println("userName=" + userBean.getUserName());
		System.out.println("password=" + userBean.getPassword());
	}
}

class BeanFactory {
	private Map<String, Object> beanMap = new HashMap<String, Object>();

	@SuppressWarnings("rawtypes")
	public void init(String fileName) {
		try {
			SAXReader reader = new SAXReader();
			String realPathString = new File("").getCanonicalPath();
			Document document = reader.read(new File(realPathString + "/src/main/java/com/water/ioc/") + fileName);
			Element root = document.getRootElement();
			Element foo;
			for (Iterator i = root.elementIterator("bean"); i.hasNext();) {
				foo = (Element) i.next();
				Attribute id = foo.attribute("id");
				Attribute cls = foo.attribute("class");
				Class bean = Class.forName(cls.getText());

				java.beans.BeanInfo info = java.beans.Introspector.getBeanInfo(bean);
				java.beans.PropertyDescriptor pd[] = info.getPropertyDescriptors();

				Method mSet = null;
				Object obj = bean.newInstance();
				for (Iterator ite = foo.elementIterator("property"); ite.hasNext();) {
					Element foo2 = (Element) ite.next();
					Attribute name = foo2.attribute("name");
					String value = null;
					for (Iterator ite1 = foo2.elementIterator("value"); ite1.hasNext();) {
						Element node = (Element) ite1.next();
						value = node.getText();
						break;
					}
					for (int k = 0; k < pd.length; k++) {
						if (pd[k].getName().equalsIgnoreCase(name.getText())) {
							mSet = pd[k].getWriteMethod();
							mSet.invoke(obj, value);
						}
					}
				}

				beanMap.put(id.getText(), obj);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public Object getBean(String beanName) {
		Object obj = beanMap.get(beanName);
		return obj;
	}
}

class UserBean {
	private String userName;
	private String password;

	public String getPassword() {
		return password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
