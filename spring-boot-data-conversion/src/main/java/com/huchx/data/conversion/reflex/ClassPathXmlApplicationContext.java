package com.huchx.data.conversion.reflex;

import com.huchx.data.conversion.reflex.entity.User;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.List;

public class ClassPathXmlApplicationContext {
    private String xmlPath;

    /**
     * @param xmlPath spring xml 配置路径
     */
    public ClassPathXmlApplicationContext(String xmlPath) {
        this.xmlPath = xmlPath;
    }

    public Object getBean(String beanId) throws Exception {

        // 解析xml器
        SAXReader saxReader = new SAXReader();
        Document read = null;
        try {
            // 从项目根目录路径下 读取
            read = saxReader.read(this.getClass().getClassLoader().getResourceAsStream(xmlPath));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (read == null) {
            return null;
        }
        // 获取根节点资源
        Element root = read.getRootElement();
        List<Element> elements = root.elements();
        if (elements.size() <= 0) {
            return null;
        }
        Object oj = null;
        for (Element element : elements) {
            String id = element.attributeValue("id");
            if (StringUtils.isEmpty(id)) {
                return null;
            }
            if (!id.equals(beanId)) {
                continue;
                // throw new Exception("使用beanId:" + beanId + ",未找到该bean");
            }
            // 获取实体bean class地址
            String beanClass = element.attributeValue("class");
            // 使用反射实例化bean
            Class<?> forNameClass = Class.forName(beanClass);
            oj = forNameClass.newInstance();
            // 获取子类对象
            List<Element> attributes = element.elements();
            if (attributes.size() <= 0) {
                return null;
            }
            for (Element et : attributes) {
                // 使用反射技术为方法赋值
                String name = et.attributeValue("name");
                String value = et.attributeValue("value");
                Field field = forNameClass.getDeclaredField(name);
                field.setAccessible(true);
                field.set(oj, value);

            }

        }
        return oj;
        // 1.使用beanId查找配置文件中的bean。
        // 2.获取对应bean中的classpath配置
        // 3.使用java反射机制实体化对象
    }
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        User bean = (User) applicationContext.getBean("user2");
        System.out.println("使用反射获取bean" + bean.getName() + "---" + bean.getSex());
        System.exit(0);
    }

}