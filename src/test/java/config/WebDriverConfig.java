package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:properties/${host}.properties")

public interface WebDriverConfig extends Config {
    @Key("remoteUrl")
    String getRemoteUrl();

    @Key("baseUrl")
    @DefaultValue("http://demowebshop.tricentis.com")
    String getBaseUrl();

    @Key("browser")
    @DefaultValue("chrome")
    String getBrowser();

    @Key("browserVersion")
    @DefaultValue("100.0")
    String getBrowserVersion();

}

