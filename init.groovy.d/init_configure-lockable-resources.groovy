import jenkins.model.Jenkins
import org.jenkins.plugins.lockableresources.LockableResource
import org.jenkins.plugins.lockableresources.LockableResourcesManager
import org.yaml.snakeyaml.Yaml
import org.yaml.snakeyaml.constructor.SafeConstructor

Jenkins jenkins = Jenkins.getInstance()
try {
    configText = new File("/usr/share/jenkins/ref/config/lockable_resources.yml").text
} catch (FileNotFoundException e) {
    println 'File not found'
    jenkins.doSafeExit(null)
    System.exit(1)
}
Yaml yaml = new Yaml(new SafeConstructor())
Map lockable_resources = yaml.load(configText)

List resources = []
for (item in lockable_resources.RESOURCES) {
resources << new LockableResource(item.NAME?:'', item.DESCRIPTION?:'', item.LABELS?:'', item.RESERVED_BY?:'')

}

if(resources) {
    Jenkins j = Jenkins.instance
    LockableResourcesManager resourceManager = j.getExtensionList(LockableResourcesManager.class)[0]
    if(resourceManager.resources != resources) {
        resourceManager.resources = resources
        resourceManager.save()
        println "Configured lockable resources: ${resources*.name.join(', ')}"
    }
    else {
        println 'Nothing changed.  Lockable resources already configured.'
    }
}
