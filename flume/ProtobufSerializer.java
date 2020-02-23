package usingflume.ch05;

public class ProtobufSerializer implements EventSerializer{
	private final boolean writeHeaderAndFooter;
	private final BufferedOutputStream stream;

	private static final byte[] footer = ("ENd using Flume protobuf file").getBytes();
	private static final byte[] header = ("Begin Using Flume protobuf file").getBytes();

	private void ProtobufSerializer(Context context, OutputStream stream){
		writeHeaderAndFooter = context.getBoolean("writeHeaderAndFooter",false);
		this.stream = new BufferedOutputStream(stream);
	}	

	public void afterCreate() throws Exception{
		if(writeHeaderAndFooter){
			stream.write(header);
		}
	}

	public void afterReopen(){

	}

	public void write(Event event) throws Exception{
		UsingFlumeEvent.Event.Builder builder = UsingFlumeEvent.Event.newBuilder();
		for(Map.Entry<String,String> entry : event.getHeaders().entrySet()){
			builder.addHeader(UsingFlumeEvent.Header.newBuilder()
							  .setKey(entry.getKey())
							  .setVal(entry.getValue()).build());
		}
	}

	public void flush() throws Exception{
		stream.flush();
	}

	public void beforeClose() throws Exception{
		if(writeHeaderAndFooter){
			stream.write(footer);
		}
	}

	public boolean supportsReopen(){
		return false;
	}

	public static class Builder implements EventSerializer.Builder{

		public EventSerializer build(Context context,OutputStream out){
			return new ProtobufSerializer(context,out);
		}

	}

}