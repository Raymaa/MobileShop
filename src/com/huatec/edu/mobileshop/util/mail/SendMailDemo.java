package com.huatec.edu.mobileshop.util.mail;

public class SendMailDemo {
	public static void main(String[] args) {
		// 设置邮件服务器信息
	   MailSenderInfo mailInfo = new MailSenderInfo();
	   mailInfo.setMailServerHost("smtp.163.com");
	   mailInfo.setMailServerPort("25");
	   mailInfo.setValidate(true);
	   // 邮箱用户名
	   mailInfo.setUserName("hs_sygl_cpb@163.com");
	   // 邮箱密码 
	   mailInfo.setPassword("HSsyglcpb123");
	   // 发件人邮箱
	   mailInfo.setFromAddress("hs_sygl_cpb@163.com");
	   // 收件人邮箱
	   mailInfo.setToAddress("xx@qq.com");
	   // 邮件标题
	   mailInfo.setSubject("发送邮件测试");
	   // 邮件内容
	   StringBuffer buffer = new StringBuffer();
	   buffer.append("发送邮件测试");
	   mailInfo.setContent(buffer.toString());
	   // 发送邮件
	   MailSender sms = new MailSender();
	   // 发送文体格式
	   sms.sendTextMail(mailInfo);
	   // 发送html格式
//	   SimpleMailSender.sendHtmlMail(mailInfo);
	   System.out.println("邮件发送完毕");
	}
}
