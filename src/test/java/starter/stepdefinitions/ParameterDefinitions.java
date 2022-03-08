package starter.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.ParameterType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import starter.CalculationData;

import java.util.Map;

public class ParameterDefinitions {

    @ParameterType(".*")
    public Actor actor(String actorName) {
        return OnStage.theActorCalled(actorName);
    }

    @DataTableType
    public CalculationData calculationData(Map<String, String> entry) {
        System.out.println("entry" + entry.get("Tree Type"));
        return new CalculationData(entry.get("Number Of Seed"),
                entry.get("Name"),
                entry.get("Time"),
                CalculationData.TreeType.getTreeType(entry.get("Tree Type")));
    }

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }
}
