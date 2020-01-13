package com.hdfs_java_api;

import java.io.*;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class makeDirectory throws Exception{

	public static void main(String[] args){
		String uri = "hdfs://localhost:9000/myDemoDir";
		Configuration conf =  new Configuration();

		FileSystem fs = new FileSystem(URI.create(uri),conf);

		boolean yesorno = fs.mkdirs(new Path(uri));

		System.out.println("Status of given directory is : " + yesorno);

	}
}