package com.compete.zook_app;

import org.apache.zookeeper.ZooKeeper;

public class updateZnode {
	private static zkConnector zkc;
	private static ZooKeeper zk;
	
	public static void update(String path,byte[] data) throws Exception{
		zk.setData(path, data, zk.exists(path, true).getVersion() );
	}
	
	public static void main(String[] args) throws Exception{
		String path = "/sampleZnode";
		byte[] data = "this is data0".getBytes();
		
		zk = zkc.connect("localhost");
		
		update(path,data);
		System.out.println("changed");
	}
}
