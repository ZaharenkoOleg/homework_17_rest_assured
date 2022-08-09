package config;
import org.aeonbits.owner.Config;
@Config.Sources({"classpath:auth.properties"})
public interface CredentialsConfig extends Config{
    @Key("Email")
    String email();

    @Key("Password")
    String password();


}
