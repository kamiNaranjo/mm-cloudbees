import jenkins.model.Jenkins;
import com.splunk.splunkjenkins.SplunkJenkinsInstallation;

host = ""
port = ""
token = ""
useSSL = ""

SplunkJenkinsInstallation config = new SplunkJenkinsInstallation(false);
config.host = host;
config.port = port;
config.token = token;
config.useSSL = useSSL;
config.metaDataConfig = metaDataConfig;
config.enabled = true;
config.updateCache();
