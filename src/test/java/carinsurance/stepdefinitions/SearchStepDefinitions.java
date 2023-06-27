package carinsurance.stepdefinitions;

import carinsurance.model.MakeAndModel;
import carinsurance.model.QuestionAndAnswer;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;

import java.util.List;
import java.util.Map;

public class SearchStepDefinitions {


    @Given("{actor} wants to insure his/her car")
    public void actor_wants_to_insure_his_car(Actor actor) {
        //TODO: Open the https://www.moneysupermarket.com/shop/car-insurance/questionset/your-car page

    }

    @DataTableType
    public MakeAndModel makeAndModel(Map<String,String> makeAndModelData){
        return new MakeAndModel(makeAndModelData.get("Make"), makeAndModelData.get("Model"));
    }

    @When("{actor} finds his/her car by make and model:")
    public void he_finds_his_car_by_make_and_model(Actor actor,MakeAndModel makeAndModel) {
    }

    @DataTableType
    public QuestionAndAnswer questionAndAnswer(Map<String, String> questionAndAnswerFields){
        return new QuestionAndAnswer(questionAndAnswerFields.get("Question"), questionAndAnswerFields.get("Answer"));
    }
    @When("he provides the following additional details:")
    public void he_provides_the_following_additional_details(List<QuestionAndAnswer> questionsAndAnswers) {

    }
    @Then("he should be proposed the following cars:")
    public void he_should_be_proposed_the_following_cars(List<String> proposedCars) {

    }

}
