package com.lyon_yan.module.wxpay.core;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;

/**
 * XML数据工厂
 * 
 * @author Lyon
 *
 */
public class XMLFactory {
	public static String getXMLFromeMap(Object object) {
		try {
			// 解决XStream对出现双下划线的bug
			XStream xStreamForRequestPostData = new XStream(new DomDriver(
					"UTF-8", new XmlFriendlyNameCoder("-_", "_")));
			// 将要提交给API的数据对象转换成XML格式数据Post给API
			String xml= xStreamForRequestPostData.toXML(object);
			return xml;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Map<String, Object> getMapFromXML(String xmlString) {
		try {
			// 这里用Dom的方式解析回包的最主要目的是防止API新增回包字段
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			InputStream is = Util.getStringStream(xmlString);
			org.w3c.dom.Document document = builder.parse(is);

			// 获取到document里面的全部结点
			NodeList allNodes = document.getFirstChild().getChildNodes();
			Node node;
			Map<String, Object> map = new HashMap<String, Object>();
			int i = 0;
			while (i < allNodes.getLength()) {
				node = allNodes.item(i);
				if (node instanceof Element) {
					map.put(node.getNodeName(), node.getTextContent());
				}
				i++;
			}
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
