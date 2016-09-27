package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;


public class TestFTP {

	@Test
	public void testFTPClient() throws SocketException, IOException {
		//创建FTPClient对象
		FTPClient ftpClient = new FTPClient();
		ftpClient.connect("192.168.0.104", 21);
		ftpClient.login("gavin", "1989");
		
		FileInputStream fis = new FileInputStream("C:\\aha.jpg");
		ftpClient.changeWorkingDirectory("~/images");
		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
		ftpClient.storeFile("aha.jpg", fis);
		ftpClient.logout();
		
	}

}
