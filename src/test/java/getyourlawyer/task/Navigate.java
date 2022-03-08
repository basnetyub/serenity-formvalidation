package getyourlawyer.task;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import getyourlawyer.userinterface.CalculateForm;

public class Navigate {

    public static Performable toTheCalculatePage() {
        return Task.where("{0} opens the CalculateNumberOfTrees page",
                Open.browserOn().thePageNamed("pages.homepage"),
                Click.on(CalculateForm.CLICK_ME_BUTTON),
                Click.on(CalculateForm.NOW_CLICK_ME_BUTTON));
    }
}
