package getyourlawyer.stepdefinitions;

import getyourlawyer.model.CalculationData;
import getyourlawyer.question.CalculationContents;
import getyourlawyer.task.CalculateNumberOfTrees;
import getyourlawyer.task.Navigate;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CalculateStepDefinitions {

    @Given("{actor} is/am on a calculate page")
    public void landsOnCalculatePage(Actor actor) {
        actor.wasAbleTo(Navigate.toTheCalculatePage());
    }

    @When("{actor} enter(s) the required value(s)")
    public void userEntersTheRequiredValues(Actor actor, CalculationData formValues) {
        actor.attemptsTo(CalculateNumberOfTrees.fillsForm(formValues));
    }

    @And("calculate(s) number of tree(s) using {word} method")
    public void calculateNumberOfTrees(String method) {
        theActorInTheSpotlight().attemptsTo(CalculateNumberOfTrees.usingMethod(method));
        theActorInTheSpotlight().attemptsTo(CalculateNumberOfTrees.calculate());
    }

    @And("calculate(s) number of tree(s)")
    public void calculateNumberOfTrees() {
        theActorInTheSpotlight().attemptsTo(CalculateNumberOfTrees.calculate());
    }

    @Then("{actor} should see the result {string}")
    public void userShouldSeeTheResultResult(Actor actor, String result) {
        actor.wasAbleTo(
                Ensure.that(CalculationContents.resultDisplayed()).isEqualTo(result)
        );
    }

    @Then("{actor} should get {string} message")
    public void userShouldGetMessage(Actor actor, String validationErrorMessage) {
        actor.attemptsTo(
                Ensure.that(CalculationContents.validationMessages()).containsOnly(validationErrorMessage)
        );
    }
}
