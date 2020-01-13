package packageName;

import requiredModules;

public class DeleteHdfsFile{

	public static void main(String[] args) throws Exception{
		
		String uri = "hdfs://localhost:9000/dirname/filename";		
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(URI.create(uri),conf);
		fs.delete(new Path(uri),true);
	}

}



