数据交换格式与SpringIOC底层实现
一、课程目标
XML和JSON
 Java反射机制
手写SpringIOC
二、什么是数据交换格式
客户端与服务器常用数据交换格式xml、json、html
三、数据交换格式用场景
移动端(安卓、IOS)通讯方式采用http协议+JSON格式 走restful风格。
很多互联网项目都采用Http协议+JSON
因为xml比较重WebService服务采用http+xml格式 银行项目使用比较多
同学们可以思考下？移动端和PC端服务器是接口是怎么设计的？
画图演示
四、数据交换格式

4.1JSON简单使用
4.1.1.什么是JSON
JSON(JavaScript Object Notation)是一种轻量级的数据交换格式，相比于xml这种数据交换格式来说，因为解析xml比较的复杂，而且需要编写大段的代码，所以客户端和服务器的数据交换格式往往通过JSON来进行交换。
样例:
{
    "sites": [
        {
            "name": "蚂蚁课堂",
            "url": "www.itmayiedu.com"
        },
        {
            "name": "每特教育",
            "url": "http://meiteedu.com/"
        }
    ]
}
JSON：JavaScript 对象表示法（JavaScript Object Notation）。
JSON的形式是用大括号“{}”包围起来的项目列表，每一个项目间用逗号（,）分隔，而项目就是用冒号（:）分隔的属性名和属性值。这是典型的字典表示形式，也再次表明javascript里的对象就是字典结构。不管多么复杂的对象，都可以用一句JSON代码来创建并赋值。在JSON中，名称 / 值对包括字段名称（在双引号中），后面写一个冒号，然后是值
4.1.2.JSON格式的分类
JSON有两种结构
json简单说就是javascript中的对象和数组，所以这两种结构就是对象和数组两种结构，通过这两种结构可以表示各种复杂的结构
1、对象：对象在js中表示为“{}”括起来的内容，数据结构为 {key：value,key：value,...}的键值对的结构，在面向对象的语言中，key为对象的属性，value为对应的属性值，所以很容易理解，取值方法为 对象.key 获取属性值，这个属性值的类型可以是 数字、字符串、数组、对象几种。
2、数组：数组在js中是中括号“[]”括起来的内容，数据结构为 ["java","javascript","vb",...]，取值方式和所有语言中一样，使用索引获取，字段值的类型可以是 数字、字符串、数组、对象几种。
经过对象、数组2种结构就可以组合成复杂的数据结构了。
4.1.3.常用JSON解析框架
fastjson(阿里)、gson(谷歌)、jackson(SpringMVC自带)
4.1.4.使用fastjson解析json
添加jar fastjson-1.1.43 或引入maven依赖
<dependency>
<groupId>com.alibaba</groupId>
<artifactId>fastjson</artifactId>
<version>1.1.43</version>
</dependency>
4.1.5.使用fastjson api
public static final Object parse(String text); // 把JSON文本parse为JSONObject或者JSONArray 
public static final JSONObject parseObject(String text)； // 把JSON文本parse成JSONObject    
public static final <T> T parseObject(String text, Class<T> clazz); // 把JSON文本parse为JavaBean 
public static final JSONArray parseArray(String text); // 把JSON文本parse成JSONArray 
public static final <T> List<T> parseArray(String text, Class<T> clazz); //把JSON文本parse成JavaBean集合 
public static final String toJSONString(Object object); // 将JavaBean序列化为JSON文本 
public static final String toJSONString(Object object, boolean prettyFormat); // 将JavaBean序列化为带格式的JSON文本 
public static final Object toJSON(Object javaObject); 将JavaBean转换为JSONObject或者JSONArray。
4.1.6.解析json
	static String jsonStr = "{\"sites\":[{\"name\":\"蚂蚁课堂\",\"url\":\"www.itmayiedu.com\"},{\"name\":\"每特教育\",\"url\":\"http://meiteedu.com/\"}]}";

	public static void main(String[] args) {
		JSONObject jsonObject = new JSONObject();
		// 将json字符串转为jsonbject
		JSONObject jsonStrObject = jsonObject.parseObject(jsonStr);
		JSONArray jsonArray = jsonStrObject.getJSONArray("sites");
		for (Object object : jsonArray) {
			JSONObject stObject = (JSONObject) object;
			String name = stObject.getString("name");
			String url = stObject.getString("url");
			System.out.println(name + "---" + url);
		}
	}

4.1.6.组装json
JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		JSONObject stObject = new JSONObject();
		stObject.put("name", "蚂蚁课堂");
		stObject.put("url", "http://www.itmayiedu.com");
		jsonArray.add(stObject);
		jsonObject.put("sites", jsonArray);
		System.out.println(jsonObject.toJSONString());


4.2XML简单使用
4.2.1什么是XML？
它是可扩展标记语言（Extensible Markup Language，简称XML），是一种标记语言。
XML 全称为可扩展的标记语言。主要用于描述数据和用作配置文件。
XML 文档在逻辑上主要由一下 5 个部分组成：
XML 声明：指明所用 XML 的版本、文档的编码、文档的独立性信息
文档类型声明：指出 XML 文档所用的 DTD
元素：由开始标签、元素内容和结束标签构成
注释：以结束，用于对文档中的内容起一个说明作用
处理指令：通过处理指令来通知其他应用程序来处理非 XML 格式的数据，格式为
　　XML 文档的根元素被称为文档元素，它和在其外部出现的处理指令、注释等作为文档实体的子节点，根元素本身和其内部的子元素也是一棵树。
4.2.2 XML样例？
<?xml version="1.0" encoding="UTF-8"?>  
<students>  
    <student1 id="001">  
        <微信公众号>@残缺的孤独</微信公众号>  
        <学号>20140101</学号>  
        <地址>北京海淀区</地址>  
        <座右铭>要么强大，要么听话</座右铭>  
    </student1>  
    <student2 id="002">  
        <新浪微博>@残缺的孤独</新浪微博>  
        <学号>20140102</学号>  
        <地址>北京朝阳区</地址>  
        <座右铭>在哭泣中学会坚强</座右铭>  
    </student2>  
</students>  
<?xml version="1.0" encoding="UTF-8"?>作用
xml文件头部要写的话，说明了xml的版本和编码，utf-8一般是网络传输用的编码
4.2.3XML解析方式？
Dom4j、Sax、Pull

4.2.3Dom4j与Sax区别
 dom4j不适合大文件的解析，因为它是一下子将文件加载到内存中，所以有可能出现内存溢出，sax是基于事件来对xml进行解析的，所以他可以解析大文件的xml，也正是因为如此，所以dom4j可以对xml进行灵活的增删改查和导航，而sax没有这么强的灵活性，所以sax经常是用来解析大型xml文件，而要对xml文件进行一些灵活（crud）操作就用dom4j。
4.2.4 使用dom4j解析xml
解析XML过程是通过获取Document对象，然后继续获取各个节点以及属性等操作，因此获取Document对象是第一步，大体说来，有三种方式：
1.自己创建Document对象
Document document = DocumentHelper.createDocument();
Element root = document.addElement("students");
其中students是根节点，可以继续添加其他节点等操作。
2.自己创建Document对象
// 创建SAXReader对象
SAXReader reader = new SAXReader();
// 读取文件 转换成Document
Document document = reader.read(new File("XXXX.xml"));
3.读取XML文本内容获取Document对象
String xmlStr = "<students>......</students>";
Document document = DocumentHelper.parseText(xmlStr);
4.2.5 解析xml代码
Xml配置:
<?xml version="1.0" encoding="UTF-8"?>
<students>
	<student1 id="001">
		<微信公众号>@残缺的孤独</微信公众号>
		<学号>20140101</学号>
		<地址>北京海淀区</地址>
		<座右铭>要么强大，要么听话</座右铭>
	</student1>
	<student2 id="002">
		<新浪微博>@残缺的孤独</新浪微博>
		<学号>20140102</学号>
		<地址>北京朝阳区</地址>
		<座右铭>在哭泣中学会坚强</座右铭>
	</student2>
</students>  
Java代码
public static void main(String[] args) throws DocumentException {
		SAXReader saxReader = new SAXReader();
		Document read = saxReader.read(new File("E://work//spring-ioc//src//main//resources//stu.xml"));
		// 获取根节点
		Element rootElement = read.getRootElement();
		getNodes(rootElement);

	}

	static public void getNodes(Element rootElement) {
		System.out.println("当前节点名称:" + rootElement.getName());
		// 获取属性ID
		List<Attribute> attributes = rootElement.attributes();
		for (Attribute attribute : attributes) {
			System.out.println("属性:" + attribute.getName() + "---" + attribute.getText());
		}
		if (!rootElement.getTextTrim().equals("")) {
			System.out.println(rootElement.getName() + "--" + rootElement.getText());
		}
		// 使用迭代器遍历
		Iterator<Element> elementIterator = rootElement.elementIterator();
		while (elementIterator.hasNext()) {
			Element next = elementIterator.next();
			getNodes(next);
		}

	}


注意:
 this.getClass().getClassLoader().getResourceAsStream(xmlPath) 获取当前项目路径xmlfsfs
4.2 XML与JSON区别
Xml是重量级数据交换格式，占宽带比较大。
JSON是轻量级交换格式，xml占宽带小。
所有很多互联网公司都会使用json作为数据交换格式
很多银行项目，大多数还是在使用xml。
五、Java反射机制
5.1 什么是Java反射
就是正在运行，动态获取这个类的所有信息。
5.2 反射机制的作用
  1，反编译：.class-->.java
   2．通过反射机制访问java对象的属性，方法，构造方法等；
5.3 反射机制的应用场景
Jdbc 加载驱动-----
Spring ioc
框架 
5.4反射机制获取类有三种方法
	//第一种方式：  
		Classc1 = Class.forName("Employee");  
		//第二种方式：  
		//java中每个类型都有class 属性.  
		Classc2 = Employee.class;  
		   
		//第三种方式：  
		//java语言中任何一个java对象都有getClass 方法  
		Employeee = new Employee();  
		Classc3 = e.getClass(); //c3是运行时类 (e的运行时类是Employee)  	


5.5反射创建对象的方式
	Class<?> forName = Class.forName("com.itmayiedu.entity.User");
		// 创建此Class 对象所表示的类的一个新实例 调用了User的无参数构造方法.
		Object newInstance = forName.newInstance();
实例化有参构造函数
		Class<?> forName = Class.forName("com.itmayiedu.entity.User");
		Constructor<?> constructor = forName.getConstructor(String.class, String.class);
		User newInstance = (User) constructor.newInstance("123", "123");

5.6 反射创建api
方法名称	作用
getDeclaredMethods []	获取该类的所有方法
getReturnType()	获取该类的返回值
getParameterTypes()	获取传入参数
getDeclaredFields()	获取该类的所有字段
setAccessible	允许访问私有成员
5.7 使用反射为类私有属性赋值
// 获取当前类class地址
		Class<?> forName = Class.forName("com.itmayiedu.entity.User");
		// 使用反射实例化对象 无参数构造函数
		Object newInstance = forName.newInstance();
		// 获取当前类的 userId字段
		Field declaredField = forName.getDeclaredField("userId");
		// 允许操作私有成员
		declaredField.setAccessible(true);
		// 设置值
		declaredField.set(newInstance, "123");
		User user = (User) newInstance;
		System.out.println(user.getUserId());



六、手写SpringIOC框架
6.1什么是SpringIOC
什么是SpringIOC，就是把每一个bean(实体类)与bean(实体了)之间的关系交给第三方容器进行管理。

Xml配置:
<beans>
	<bean id="user1" class="com.itmayiedu.entity.UserEntity">
		<property name="userId" value="0001"></property>
		<property name="userName" value="余胜军"></property>
	</bean>
	<bean id="user2" class="com.itmayiedu.entity.UserEntity">
		<property name="userId" value="0002"></property>
		<property name="userName" value="张三"></property>
	</bean>
</beans>

Java代码:
//1.读取springxml配置
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		//2.获取bean对象
		TestService testService = (TestService) classPathXmlApplicationContext.getBean("testService");
		System.out.println(testService.test());


6.2什么是SpringIOC底层实现原理
1.读取bean的XML配置文件
2.使用beanId查找bean配置，并获取配置文件中class地址。
3.使用Java反射技术实例化对象
4.获取属性配置，使用反射技术进行赋值。
详细步骤
  
1.利用传入的参数获取xml文件的流,并且利用dom4j解析成Document对象
2.对于Document对象获取根元素对象<beans>后对下面的<bean>标签进行遍历,判断是否有符合的id.
3.如果找到对应的id,相当于找到了一个Element元素,开始创建对象,先获取class属性,根据属性值利用反射建立对象.
4.遍历<bean>标签下的property标签,并对属性赋值.注意,需要单独处理int,float类型的属性.因为在xml配置中这些属性都是以字符串的形式来配置的,因此需要额外处理.
5.如果属性property标签有ref属性,说明某个属性的值是一个对象,那么根据id(ref属性的值)去获取ref对应的对象,再给属性赋值.
6.返回建立的对象,如果没有对应的id,或者<beans>下没有子标签都会返回null
6.3建立实体类
public class User {

	private String userId;
	private String userName;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
6.4 使用反射技术完成Java代码
import java.lang.reflect.Field;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.itmayiedu.entity.User;

/**
 * 
 * @classDesc: 功能描述:(读取Spring配置文件)
 * @author: 余胜军
 * @createTime: 2017年8月25日 上午1:27:55
 * @version: v1.0
 * @copyright:上海每特教育科技有限公司
 */
public class ClassPathXmlApplicationContext {
	private String xmlPath;

	/**
	 * 
	 * @param xmlPath
	 *            spring xml 配置路径
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
		System.out.println("使用反射获取bean" + bean.getUserId() + "---" + bean.getUserName());

	}
}





