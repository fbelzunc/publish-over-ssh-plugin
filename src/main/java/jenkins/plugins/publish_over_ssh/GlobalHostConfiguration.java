package jenkins.plugins.publish_over_ssh;

import hudson.Extension;
import jenkins.model.GlobalConfiguration;
import jenkins.plugins.publish_over_ssh.descriptor.BapSshPublisherPluginDescriptor;
import net.sf.json.JSONObject;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.StaplerRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Felix on 27/04/15.
 */

@Extension
public class GlobalHostConfiguration extends GlobalConfiguration {

    private List<BapSshHostConfiguration> hostConfiguration = new ArrayList<BapSshHostConfiguration>();
    private BapSshCommonConfiguration commonConfig;

    public List<BapSshHostConfiguration> getHostConfiguration() {
        return hostConfiguration;
    }

    public void setHostConfiguration(List<BapSshHostConfiguration> hostConfiguration) {
        this.hostConfiguration = hostConfiguration;
        save();
    }

    public BapSshCommonConfiguration getCommonConfig() {
        return commonConfig;
    }

    public void setCommonConfig(BapSshCommonConfiguration commonConfig) {
        this.commonConfig = commonConfig;
        save();
    }

    public GlobalHostConfiguration() {
        load();
    }

    @Override
    public boolean configure(StaplerRequest req, JSONObject json) throws FormException {
        req.bindJSON(this, json);
        return true;
    }

    public static GlobalHostConfiguration get() {
        return GlobalConfiguration.all().get(GlobalHostConfiguration.class);
    }

}
