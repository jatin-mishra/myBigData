package com.compete.zook_app;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

public class createZnode {
	
		private static ZooKeeper zk;
		private static zkConnector zkcon;
	
		public static void create(String path,byte[] data) throws Exception{
			zk.create(path, data, Ids.OPEN_ACL_UNSAFE , CreateMode.PERSISTENT );
		}
		
		
		public static void main(String[] args) throws Exception {
			String path = "/sampleznode";
			byte[] data = "sample znode data".getBytes();
			
			zkcon = new zkConnector();
			zk = zkcon.connect("localhost"); 
			
			create(path,data);
		}
}
