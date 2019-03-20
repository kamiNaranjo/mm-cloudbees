import org.quality.gates.jenkins.plugin.*;
import jenkins.model.Jenkins;

def name = "name2"
def url  = "http://url.com"
def aut  = "holiholiholi"

println "Configurando plugin Quality-Gates"
qualityGate = Jenkins.instance.getExtensionList(org.quality.gates.jenkins.plugin.GlobalConfig .class)[0];
GlobalConfigDataForSonarInstance config = new GlobalConfigDataForSonarInstance(name, url, aut, 10000)
List<GlobalConfigDataForSonarInstance> configList = []
configList.add(config)
qualityGate.setGlobalConfigDataForSonarInstances(configList)
qualityGate.save()
