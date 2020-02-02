package com.compete.zook_app;

import java.util.ArrayList;
import java.util.List;

import org.apache.zookeeper.ZooKeeper;

public class testZkConnection {

		private static ZooKeeper zk;
		
		private static zkConnector zkc;
	
		public static List<String> znodeList = new ArrayList<String>();
		
		public static void main(String[] args) throws Exception {
			zkc = new zkConnector();
			zk = zkc.connect("localhost");
			
			znodeList = zk.getChildren("/", true);
			
			for(String znode : znodeList) {
				System.out.println(znode);
			}
			
			zkc.close();
		}
	
}
