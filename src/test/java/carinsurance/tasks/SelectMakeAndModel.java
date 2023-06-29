package carinsurance.tasks;

import carinsurance.model.MakeAndModel;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.questions.CurrentVisibility;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.ui.RadioButton;
import net.serenitybdd.screenplay.ui.Select;

public class SelectMakeAndModel {
    public static Performable of(MakeAndModel makeAndModel) {
        return Task.where("{0} picks a make and model",
                actor -> {
                    boolean isUsingRadioButtons = actor.asksFor(Visibility.of(RadioButton.withLabel("Ford")));

                    //Select make and model using dropdowns or radio buttons
                    if (isUsingRadioButtons) {
                        actor.attemptsTo(
                                JavaScriptClick.on(RadioButton.withLabel(makeAndModel.make())),
                                JavaScriptClick.on(RadioButton.withLabel(makeAndModel.model()))
                        );
                    } else {
                        actor.attemptsTo(
                                Select.option(makeAndModel.make()).from("#makeId"),
                                Select.option(makeAndModel.model()).from("#modelId")
                        );
                    }
                }
        );
    }
}
