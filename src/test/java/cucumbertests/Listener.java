package cucumbertests;

import com.aventstack.extentreports.ExtentReports;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.EventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.TestCaseFinished;
import io.cucumber.plugin.event.TestCaseStarted;
import io.cucumber.plugin.event.TestStepFinished;
import org.softpost.CucumberContext;
import org.softpost.Singleton;

public class Listener implements ConcurrentEventListener {

    public Listener(){

    }

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestCaseFinished.class, this::ScenarioFinished);
        publisher.registerHandlerFor(TestStepFinished.class, this::StepFinished);

    }

    // This event is triggered when Test Case is started
    // here we create the scenario node
    private void ScenarioFinished(TestCaseFinished event) {
//        String featureName = event.getTestCase().getUri().toString();
//        System.out.println("MyError :) " + event.getResult().getError());
//       //context.getTest().info(event.getResult().getError());
//
//        if (event.getResult().getError()!=null)
//        {
//            Singleton.getInstance().setError(event.getResult().getError().toString());
//            System.out.println( "Singleton error " + Singleton.getInstance().getError());
//        }
    };

    private void StepFinished(TestStepFinished event) {
        String featureName = event.getTestCase().getUri().toString();
        System.out.println("MyError :) " + event.getResult().getError());
        //context.getTest().info(event.getResult().getError());

        if (event.getResult().getError()!=null)
        {
            Singleton.getInstance().setError(event.getResult().getError().toString());
            System.out.println( "Singleton error " + Singleton.getInstance().getError());
        }
    };
}
