package com.compete.zook_app;

import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooKeeper;

public class zkConnector {
	
	private ZooKeeper zoo;
	private CountDownLatch countSignal = new CountDownLatch(1);
	
	public ZooKeeper connect(String host) throws Exception{
		zoo = new ZooKeeper(host,5000,new Watcher() {
			
			public void process(WatchedEvent event) {
				if(event.getState() == KeeperState.SyncConnected) {
					countSignal.countDown();
				}
			}
			
		});
		countSignal.await();
		return zoo;
	}
	
	public void close() throws Exception{
		zoo.close();
	}
	
}
