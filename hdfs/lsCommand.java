
import java.io.*;
import java.net.*;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.FileStatus;

public class listFiles{
	public static void main(String[] args) throws Exception{
		String uri = "hdfs://localhost:9000";
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(URI.create(uri),conf);
		FileStatus[] filestatus = fs.listStatus(new Path("hdfs://localhost:9000/allInputData"));

		for(FileStatus filestat : filestatus){
			System.out.println(filestat.getPath().getName());
		}
	}
}
