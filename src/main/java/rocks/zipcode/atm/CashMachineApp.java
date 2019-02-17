package rocks.zipcode.atm;

import javafx.scene.Node;
import javafx.scene.control.Label;
import rocks.zipcode.atm.bank.Bank;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.FlowPane;

/**
 * @author ZipCodeWilmington
 */
public class CashMachineApp extends Application {

    private TextField field = new TextField();
    private CashMachine cashMachine = new CashMachine(new Bank());
    Label label1 = new Label("Account ID");
    Label label2 = new Label("Account Name");
    Label label3 = new Label("Account Email Address");
    Label label4 = new Label("Account Balance");
    TextField newTextField = new TextField();
    TextField newTextField1 = new TextField();
    TextField newTextField2 = new TextField();
    TextField newTextField3 = new TextField();
    TextField newTextField4 = new TextField();



    private Parent createContent() {
        VBox vbox = new VBox(10);
        vbox.setPrefSize(600, 600);

        TextArea areaInfo = new TextArea();
        areaInfo.setText("Please enter your Account ID above.");

        Button btnSubmit = new Button("Login");
        btnSubmit.setOnAction(e -> {
            int id = Integer.parseInt(field.getText());
            cashMachine.login(id);

            newTextField.setText(cashMachine.displayAccountID());
            newTextField1.setText(cashMachine.displayAccountName());
            newTextField2.setText(cashMachine.displayEmail());
            newTextField3.setText(""+cashMachine.displayBalance());
            areaInfo.setText(cashMachine.toString());

        });

        Button btnDeposit = new Button("Deposit");
        //btnDeposit.setDisable(true);
        btnDeposit.setOnAction(e -> {

            int amount = Integer.parseInt(field.getText());
            cashMachine.deposit(amount);

            areaInfo.setText(cashMachine.toString());
        });

        Button btnWithdraw = new Button("Withdraw");
        btnWithdraw.setOnAction(e -> {
            int amount = Integer.parseInt(field.getText());
            cashMachine.withdraw(amount);

            areaInfo.setText(cashMachine.toString());
        });

        Button btnExit = new Button("Exit");
        btnExit.setOnAction(e -> {
            cashMachine.exit();

            areaInfo.setText(cashMachine.toString());
        });

        FlowPane flowpane = new FlowPane();

        flowpane.getChildren().add(btnSubmit);
        flowpane.getChildren().add(btnDeposit);
        flowpane.getChildren().add(btnWithdraw);
        flowpane.getChildren().add(btnExit);
        flowpane.getChildren().add(label1);
        flowpane.getChildren().add(newTextField);
        flowpane.getChildren().add(label2);
        flowpane.getChildren().add(newTextField1);
        flowpane.getChildren().add(label3);
        flowpane.getChildren().add(newTextField2);
        flowpane.getChildren().add(label4);
        flowpane.getChildren().add(newTextField3);
        vbox.getChildren().addAll(field, flowpane, areaInfo, label1,newTextField,label2, newTextField1,
                label3, newTextField2, label4, newTextField3);


        return vbox;
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(createContent()));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
