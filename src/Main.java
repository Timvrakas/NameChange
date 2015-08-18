import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Main {
public static final class OS
	    {

	        public static final OS linux;
	        public static final OS solaris;
	        public static final OS windows;
	        public static final OS macos;
	        public static final OS unknown;
	        public int id;
	        //private static final OS $VALUES[];

	     

	        static 
	        {
	            linux = new OS("linux", 0);
	            solaris = new OS("solaris", 1);
	            windows = new OS("windows", 2);
	            macos = new OS("macos", 3);
	            unknown = new OS("unknown", 4);
	            /*$VALUES = (new OS[] {
	                linux, solaris, windows, macos, unknown
	            });*/
	        }

	        public OS(String s, int i)
	        {
	            id = i;
	        }
	    }

public static void main(String[] args) throws IOException{
	@SuppressWarnings("unused")
	GUI gui = new GUI();
}

public static void setNewUser(String from, String to){
			String user_home = System.getProperty("user.home", ".");
			        File file = null;
			        String name = new String("minecraft");
			        String appdata = System.getenv("APPDATA");
			        		switch(getPlatform().id){
			        		case 0: // null
			        		case 1: // Linux
			        			file = new File(user_home, "."+name);
			        		break;
			        		case 2: // PC
			        			if(appdata != null){
			        				file = new File(appdata, "."+name);
			        				System.out.println("APPDATA");
			        			}else{
			        				System.out.println("APPDATA is NULL (using user.home)");
			        				file = new File(user_home, '.'+name);
			        			}
			        		break;
			        		case 3: // Mac
								file = new File(user_home,"Library/Application Support/"+name);
							break;
			        		default: // Other
			        			file = new File(user_home, name);
			        		break;
			        		}
			        		if(!file.isDirectory()){
			        			throw new RuntimeException("The Minecraft Working Dir Does Not Exist: " + file);
			        		}
			        		file = new File(file,"launcher_profiles.json");
			        		if(!file.isFile()){
			        			throw new RuntimeException("The Minecraft Config File Does Not Exist: " + file);
			        		}
			        		Path path = Paths.get(file.toString());
			        		Charset charset = StandardCharsets.UTF_8;
			        		String content;
							try {
							content = new String(Files.readAllBytes(path), charset);
			        		content = content.replaceAll(from, to);
			        		Files.write(path, content.getBytes(charset));
							} catch (IOException e) {
								throw new RuntimeException("Could not read (or write) to config file");
							}
			    
	}

public static OS getPlatform()
    {
        String s = System.getProperty("os.name").toLowerCase();
        if(s.contains("win"))
        {
            return OS.windows;
        }
        if(s.contains("mac"))
        {
            return OS.macos;
        }
        if(s.contains("solaris"))
        {
            return OS.solaris;
        }
        if(s.contains("sunos"))
        {
            return OS.solaris;
        }
        if(s.contains("linux"))
        {
            return OS.linux;
        }
        if(s.contains("unix"))
        {
            return OS.linux;
        } else
        {
            return OS.unknown;
        }
    }

}
