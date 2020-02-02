package com.compete.zook_app;

import org.apache.zookeeper.ZooKeeper;

public class authenticatedZnode {
	
	private static ZooKeeper zk;
	private static zkConnector zkc;
	
	public static void main(String[] args) throws Exception {
		String path = "/znodeName";
		String user = "username";
		String password = "passwd";
		
		zkc = new zkConnector();
		zk = zkc.connect("localhost");
		zk.addAuthInfo("digest",( user + ":" + password).getBytes() );
		byte[] data = zk.getData(path, true, zk.exists(path, true));
		for(byte bt:data) {
			System.out.print((char)bt);
		}
		
	}
}
