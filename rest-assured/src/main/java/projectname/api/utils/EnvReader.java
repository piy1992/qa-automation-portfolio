package projectname.api.utils;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvReader {

    String rootDir = System.getProperty("user.dir");
    String envPath = rootDir+"/env";

    public Dotenv loaDotenv (String environment){
        return Dotenv.configure()
        .directory(envPath)
        .filename(".env." + environment)
        .load(); 
    }
    
}
