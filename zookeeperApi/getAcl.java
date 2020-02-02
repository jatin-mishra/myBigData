package com.compete.zook_app;

import java.util.ArrayList;
import java.util.List;

import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.ACL;

public class getACL {
	private static zkConnector zkc;
	private static ZooKeeper zk;
	
	public static void main(String[] args) throws Exception{
		String path = "/znode";
		zkc = new zkConnector();
		zk = zkc.connect("localhost");
		
		List<ACL> lsAcl = new ArrayList<ACL>();
		lsAcl = zk.getACL(path, zk.exists(path, true));
		for(ACL acl : lsAcl) {
			System.out.print(acl.toString());
		}
	}
}
