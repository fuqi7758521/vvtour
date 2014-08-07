package com.vvtour.shop.utils;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

import com.vvtour.shop.Constant;
import com.vvtour.shop.entity.Email;


public class EmailUtil {

	public static void sendEmail(Email mail) throws Exception{
		Properties props = new Properties();  
        // 开启debug调试  
//        props.setProperty("mail.debug", "true");  
        // 发送服务器需要身份验证  
        props.setProperty("mail.smtp.auth", "true");  
        // 设置邮件服务器主机名  
        props.setProperty("mail.host", PropUtil.get("email.send.server"));  
        // 发送邮件协议名称  
        props.setProperty("mail.transport.protocol", "smtp");  
          
        // 设置环境信息  
        Session session = Session.getInstance(props);  
          
        // 创建邮件对象  
        Message msg = new MimeMessage(session);  
        msg.setSubject(mail.getTitle());  
        // 设置邮件内容  
        msg.setText(mail.getContent());  
        // 设置发件人  
        msg.setFrom(new InternetAddress(mail.getFrom()));  
          
        Transport transport = session.getTransport();  
        // 连接邮件服务器  
        transport.connect(PropUtil.get("email.send.username"), PropUtil.get("email.send.password"));  
        // 发送邮件  
        transport.sendMessage(msg, new Address[] {new InternetAddress(mail.getTo())});  
        // 关闭连接  
        transport.close(); 
	}
}
