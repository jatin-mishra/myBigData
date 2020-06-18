import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.*;

public class deleteDir{
	public static void main(String[] args) throws Exception{

		if(args.length != 1){
			System.err.println("Usage: deleteDir <path>");
			System.exit(0);
		}

		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(conf);

		fs.delete(new Path(args[0]),true);
	}
}
