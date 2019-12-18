package in.inzenjer.sheduledAuditing;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class FailureAuditing implements ServletContextListener {

    private ScheduledExecutorService scheduler;
    @Override
    public void contextInitialized(ServletContextEvent event) {
      scheduler = Executors.newSingleThreadScheduledExecutor();
      scheduler.scheduleAtFixedRate(new deleteMOnthlyRecords(), 0, 90, TimeUnit.SECONDS);
     // scheduler.scheduleAtFixedRate(new checkingCorruption(), 0, 30, TimeUnit.SECONDS);
     //
    }
    @Override
    public void contextDestroyed(ServletContextEvent event) {
        scheduler.shutdownNow();
    }

}