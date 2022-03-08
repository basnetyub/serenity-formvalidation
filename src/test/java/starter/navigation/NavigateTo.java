package starter.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import starter.calculate.CalculateForm;

public class NavigateTo {

    public static Performable theCalculatePage() {
        return Task.where("{0} opens the Calculate page",
                Open.url("https://app-test.getyourlawyer.ch/test/qa"),
                Click.on(CalculateForm.CLICK_ME_BUTTON),
                Click.on(CalculateForm.NOW_CLICK_ME_BUTTON));
    }
}
