package com.compete.zook_app;

import org.apache.zookeeper.ZooKeeper;

public class readZnode {
	private static ZooKeeper zkpr;
	private static zkConnector zkcnctr;
	private static ZooKeeper zncnctr;
	
	public static byte[] read(String path) throws Exception{
		return zkpr.getData(path, true, zkpr.exists(path, true));
	}
	
	public static void main(String[] args) throws Exception {
		zkcnctr = new zkConnector();
		zkpr = zkcnctr.connect("localhost");
		
		byte[] data = read("/sampleZnode");
		for(byte bt : data) {
			System.out.print((char)bt);
		}
		
		zncnctr.close();
	}
	
}
