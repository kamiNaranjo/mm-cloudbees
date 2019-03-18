import org.rundeck.api.RundeckClient;

def name = "name2"
def url  = "http://url.com"
def aut  = "holiholi"
def api  = 12

rundeck = Jenkins.instance.getExtensionList(org.jenkinsci.plugins.rundeck.RundeckNotifier.RundeckDescriptor.class)[0];

RundeckClient rundeckClient = RundeckClient.builder()
								.url(url)
								.token(aut)
								.version(api).build();
								
rundeck.addRundeckInstance(name,rundeckClient)		