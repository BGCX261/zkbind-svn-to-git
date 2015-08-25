package org.zkoss.bind.examples.spring.search;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.zkoss.bind.examples.spring.search.domain.Item;
import org.zkoss.bind.examples.spring.search.domain.ItemDao;

/**
 * Application Lifecycle Listener implementation class InitializeListener
 *
 */
public class InitializeListener implements ServletContextListener {

	private ItemDao itemDao ;
    /**
     * Default constructor. 
     */
    public InitializeListener() {
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce) {
    	
    	ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
    	itemDao = (ItemDao)context.getBean("itemDao");
    	if (itemDao!=null){
    		insertRandomData();
    	}
    	
    }
    
    private void insertRandomData(){
    	for (int i=0; i< 500 ; i++){
    		Item item = new Item("item "+new Double(Math.random()*10000).intValue(), null,
    				new Double(Math.random()*100).intValue(), new Double(Math.random()*100).intValue());
    		itemDao.save(item);
    	}
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
    }
	
}
