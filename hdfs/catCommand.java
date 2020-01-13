package com.hdfs_java.api;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import java.io.InputStream;


public class Hado opFileSystemcat{

	public static void main(String[] args){

		String uri = "hdfs://localhost:9000/fileName.txt";
		Configuration conf = new configuration();
	
		FileSystem filesystem = FileSystem.get(URI.create(uri),conf);
		InputStream in = null;
		in = fs.open(new Path(uri));

		try{
			IOUtils.copyBytes(in,System.out,4096,false);
		}finally{
			IOUtils.closeStream(in);
		}
	}
}