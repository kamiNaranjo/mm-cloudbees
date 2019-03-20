import org.rundeck.api.RundeckClient;
import jenkins.model.Jenkins;

def name = "name2"
def url  = "http://url.com"
def aut  = "holiholi"
def api  = 12

rundeck = Jenkins.instance.getExtensionList(org.jenkinsci.plugins.rundeck.RundeckNotifier.RundeckDescriptor.class)[0];
println "Configurando plugin Rundeck"
RundeckClient rundeckClient = RundeckClient.builder()
								.url(url)
								.token(aut)
								.version(api).build();
								
rundeck.addRundeckInstance(name,rundeckClient)		
rundeck.save()
