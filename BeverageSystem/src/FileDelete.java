import java.io.File;

public class FileDelete {
	public static void main(String[] args) {
		File folder = new File("M:\\Ration\\" + "1");
		File files[] = folder.listFiles();
		for (File f : files) {
			if(!f.getName().equals("head.ser")){
				System.out.println("file path="+f.getAbsolutePath());
				File deletefile=new File(f.getAbsolutePath()+".ser");
				System.out.println("delete "+deletefile.getName());
				if(f.delete()) 
		        { 
		            System.out.println("File deleted successfully"); 
		        } 
		        else
		        { 
		            System.out.println("Failed to delete the file"); 
		        } 
			}
		}
		
		
		/*File f = new File("E:\\Ration\\1\\t_1.ser");
		if(f.delete()){
			System.out.println("deleted");
		}else{
			System.out.println("not deleted");
		}*/
	}

}
