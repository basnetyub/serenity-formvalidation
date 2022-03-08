package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import starter.CalculationData;
import starter.calculate.CalculateForm;
import starter.calculate.CalculateNumberOfTree;
import starter.navigation.NavigateTo;

import java.time.Duration;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CalculateStepDefinitions {

    @Given("{actor} is/am on a calculate page")
    public void landsOnCalculatePage(Actor actor) {
        actor.wasAbleTo(NavigateTo.theCalculatePage());
    }

    @When("{actor} enter(s) the required value(s)")
    public void userEntersTheRequiredValues(Actor actor, CalculationData formValues) {
        actor.attemptsTo(CalculateNumberOfTree.usingDefaultMethod(formValues));
    }

    @And("calculate(s) number of tree(s) using {word} method")
    public void calculateNumberOfTrees(String method) {
        theActorInTheSpotlight().attemptsTo(CalculateNumberOfTree.selectMethod(method));
        theActorInTheSpotlight().attemptsTo(CalculateNumberOfTree.calculate());
    }

    @And("calculate(s) number of tree(s)")
    public void calculateNumberOfTrees() {
        theActorInTheSpotlight().attemptsTo(CalculateNumberOfTree.calculate());
    }

    @Then("{actor} should see the result {string}")
    public void userShouldSeeTheResultResult(Actor actor, String result) {
        actor.wasAbleTo(
                Ensure.that(CalculateForm.RESULT_LABEL.waitingForNoMoreThan(Duration.ofSeconds(5))).isEnabled(),
                Ensure.that(CalculateForm.RESULT_LABEL).hasTrimmedTextContent(result)
        );
    }

    @Then("{actor} should get {string} message")
    public void userShouldGetMessage(Actor actor, String validationErrorMessage) {
        actor.attemptsTo(
                Ensure.that(CalculateForm.VALIDATION_MESSAGES).textContentValues().containsExactly(validationErrorMessage)
        );
    }
}
