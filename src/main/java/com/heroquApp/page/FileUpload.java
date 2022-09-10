

public class FileUpload {
	public FileUpload(int a,int b) {
		int c=a+b;
		System.out.println("sum+"+c);
	}
   public FileUpload() {
	   this(10,20);
   }
   public static void main(String[] args) {
	   FileUpload file=new FileUpload();
}
}
