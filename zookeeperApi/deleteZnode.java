package com.compete.zook_app;

import org.apache.zookeeper.ZooKeeper;

public class deleteZnode {
	private static ZooKeeper zk;
	private static zkConnector zkc;
	
	public static void delete(String path) throws Exception{
		zk.delete(path,zk.exists(path, true).getVersion());
	}
	
	public static void main(String[] args) throws Exception{
		String path = "/znodepath";
		zkc = new zkConnector();
		zk = zkc.connect("localhost");
		delete(path);
		zkc.close();	
	}
}
