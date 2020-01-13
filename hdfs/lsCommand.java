package com.hdfs_java_api;

import java.io.*;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;


public class ListUsingJavaApi{

	public static void main(String[] args){
		String uri = "hdfs://localhost:9000/";
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(URI.create(uri),conf);
		FileStatus fstatus[] = fs.listStatus(new Path(uri));

		for(FileStatus filestatus : fstatus){
			System.out.println(filestatus.getPath().getName());
		}
	}
}