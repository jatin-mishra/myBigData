package com.hdfs_java_api;

import java.io.IOException;

public class UploadDownloadUsingJavaApi{

	public static void main(String[] args){
		
		String localPath = "/home/jatin/dirname/filename.txt";
		String uri = "hdfs://localhost:9000/mydemodir";

		Configuration conf = new Configuration();
		FileSystem filesystem = FileSystem.get(URI.create(uri),conf);

		filesystem.copyFromLocalPath(new Path(localPath),new Path(uri));
	
	}
}