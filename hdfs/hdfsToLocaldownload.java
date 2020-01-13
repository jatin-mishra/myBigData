package packageName;

import someModules;

public class DownloadUsingJavaApi{
	public static void main(String[] args) throws Exception{
		String localPath = "/home/jatin/dirname/file.txt";
		
		String uri = "hdfs://localhost:9000/dirname";
		
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(URI.create(uri),conf);
		fs.copyToLocalFile(new Path(uri),new Path(localPath));
	}
}