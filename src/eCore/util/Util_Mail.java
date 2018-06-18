package eCore.util;

import java.net.InetAddress;
import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Util_Mail {
	private String host;
	private String port;
	private String starttlsEnable;
	private String auth;
	private String username;
	private String password;
	private Session session;

	public Util_Mail(String host, String port, String starttlsEnable, String auth, String username, String password) {
		this.host = host;
		this.port = port;
		this.starttlsEnable = starttlsEnable;
		this.auth = auth;
		this.username = username;
		this.password = password;
		createSession();
	}

	public void createSession() {
		final String usr = username;
		final String pwd = password;

		Properties props = new Properties();
		props.put("mail.smtp.auth", this.auth);
		props.put("mail.smtp.starttls.enable", this.starttlsEnable);
		props.put("mail.smtp.host", this.host);
		props.put("mail.smtp.port", this.port);

		this.session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(usr, pwd);
			}
		});
	}

	public boolean sendEmails(String recipientEmails_To, String subject, String content) {
		try {
			Message msg = new MimeMessage(this.session);
			msg.setFrom(new InternetAddress(username));
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmails_To, false));
			msg.setHeader("X-Mailer", "LOTONtechEmail");
			msg.setSentDate(new Date());
			msg.setSubject(subject);

			MimeMultipart multipart = new MimeMultipart("related");
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(content, "text/html;charset=\"utf-8\"");
			multipart.addBodyPart(messageBodyPart);

			msg.setContent(multipart);
			msg.saveChanges();

			Transport.send(msg);
			System.out.println("Message sent OK.");
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean sendEmails(String recipientEmails_To, String recipientEmails_CC, String recipientEmails_BCC,
			String subject, String content) {
		try {
			Message msg = new MimeMessage(this.session);
			msg.setFrom(new InternetAddress(username));
			if (recipientEmails_To != null)
				msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmails_To, false));
			if (recipientEmails_CC != null)
				msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(recipientEmails_CC, false));
			if (recipientEmails_BCC != null)
				msg.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(recipientEmails_BCC, false));
			msg.setHeader("X-Mailer", "LOTONtechEmail");
			msg.setSentDate(new Date());
			msg.setSubject(subject);

			MimeMultipart multipart = new MimeMultipart("related");
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(content, "text/html;charset=\"utf-8\"");
			multipart.addBodyPart(messageBodyPart);

			msg.setContent(multipart);
			msg.saveChanges();

			Transport.send(msg);
			System.out.println("Message sent OK.");
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public static void main(String[] args) {
		String content = "<!DOCTYPE html><html><head><style>table {   font-family: arial, sans-serif;  border-collapse: collapse;   width: 100%;}td, th {    border: 1px solid #dddddd;    text-align: left;    padding: 8px;}tr:nth-child(even) {    background-color: #dddddd;}</style></head><body><h2>HTML Table</h2><table>  <tr>    <th>Company</th>    <th>Contact</th>    <th>Country</th>  </tr>  <tr>    <td>Alfreds Futterkiste</td>    <td>Maria Anders</td>    <td>Germany</td>  </tr>  <tr>    <td>Centro comercial Moctezuma</td>    <td>Francisco Chang</td>    <td>Mexico</td>  </tr>  <tr>    <td>Ernst Handel</td>    <td>Roland Mendel</td>    <td>Austria</td>  </tr>  <tr>    <td>Island Trading</td>    <td>Helen Bennett</td>    <td>UK</td>  </tr>  <tr>    <td>Laughing Bacchus Winecellars</td>    <td>Yoshi Tannamuri</td>    <td>Canada</td>  </tr>  <tr>    <td>Magazzini Alimentari Riuniti</td>    <td>Giovanni Rovelli</td>    <td>Italy</td>  </tr></table></body></html>";
		Util_Mail u = new Util_Mail("smtp.gmail.com", "587", "true", "true", "vanthu.utc2", "giaothongvantai");

		String re = "tungit07@gmail.com,lntung@utc2.edu.vn,lenhattung@gmail.com";
		try {
			InternetAddress[] arr = InternetAddress.parse(re);
			for (InternetAddress internetAddress : arr) {
				System.out.println(internetAddress.toString());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		u.sendEmails(null, null, re, "Thong bao tam dung vi stress qua stress", content);
	}

}
