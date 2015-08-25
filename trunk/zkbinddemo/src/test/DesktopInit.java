package test;
import org.zkoss.zk.au.AuRequest;
import org.zkoss.zk.au.AuService;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Desktop;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Page;

public class DesktopInit implements org.zkoss.zk.ui.util.DesktopInit {
        
        public void init(final Desktop desktop, Object request) throws Exception {
                desktop.addListener(new AuService() {

                        public boolean service(AuRequest request, boolean everError) {
                                final String cmd = request.getCommand();
                                if (cmd.equals("onZTLService")) {
                                        String zscript = (String) request.getData().get("");
                                        Component cmp = Executions.createComponentsDirectly(
                                                        zscript, "zul", null, null);
                                        if (cmp != null)
                                                cmp.setPage((Page) desktop.getPages().iterator().next());
                                        return true;
                                } else return false;
                        }
                });
        }

}