package rocks.zipcode.atm;

import javafx.scene.Node;
import javafx.scene.control.*;
import rocks.zipcode.atm.bank.Bank;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.FlowPane;

/**
 * @author ZipCodeWilmington
 */
public class CashMachineApp extends Application {

    private TextField field = new TextField();
    private TextField fieldForAmounts = new TextField();
    private CashMachine cashMachine = new CashMachine(new Bank());
    Label label1 = new Label("Account ID");
    Label label2 = new Label("Account Name");
    Label label3 = new Label("Account Email Address");
    Label label4 = new Label("Account Balance");
    Label labelLogin = new Label("Login below with your ZipCloudBank Account ID.");
    Label labelForAmounts = new Label(("Please enter the amount you would like to withdraw or deposit below."));
    TextField newTextField = new TextField();
    TextField newTextField1 = new TextField();
    TextField newTextField2 = new TextField();
    TextField newTextField3 = new TextField();




    private Parent createContent() {
        VBox vbox = new VBox(10);
        vbox.setPrefSize(600, 650);

        TextArea areaInfo = new TextArea();
        areaInfo.setText("Please enter your ZipCloudBank Account ID to proceed.");

        //Disabling buttons till login
        Button btnDeposit = new Button("Deposit");
        btnDeposit.setDisable(true);
        Button btnWithdraw = new Button("Withdraw");
        btnWithdraw.setDisable(true);
        Button btnExit = new Button("Exit");
        btnExit.setDisable(true);
        labelForAmounts.setDisable(true);
        fieldForAmounts.setDisable(true);
        label1.setDisable(true);
        newTextField.setDisable(true);
        label2.setDisable(true);
        newTextField1.setDisable(true);
        label3.setDisable(true);
        newTextField2.setDisable(true);
        label4.setDisable(true);
        newTextField3.setDisable(true);

        Button btnSubmit = new Button("Login");
        btnSubmit.setOnAction(e -> {
            int id = Integer.parseInt(field.getText());
            cashMachine.login(id);
            btnDeposit.setDisable(false);
            btnWithdraw.setDisable(false);
            btnExit.setDisable(false);
            labelForAmounts.setDisable(false);
            fieldForAmounts.setDisable(false);
            label1.setDisable(false);
            newTextField.setDisable(false);
            label2.setDisable(false);
            newTextField1.setDisable(false);
            label3.setDisable(false);
            newTextField2.setDisable(false);
            label4.setDisable(false);
            newTextField3.setDisable(false);
            newTextField.setText(cashMachine.displayAccountID());
            newTextField1.setText(cashMachine.displayAccountName());
            newTextField2.setText(cashMachine.displayEmail());
            newTextField3.setText(""+cashMachine.displayBalance());
            areaInfo.setText(cashMachine.toString());


        });

        //Button btnDeposit = new Button("Deposit");
        btnDeposit.setOnAction(e -> {
            //changed field.getText to fieldForAmounts.getText();
            Double amount = Double.parseDouble(fieldForAmounts.getText());
            cashMachine.deposit(amount);

            areaInfo.setText(cashMachine.toString());
            newTextField3.setText(""+cashMachine.displayBalance());
        });

        //Button btnWithdraw = new Button("Withdraw");
        btnWithdraw.setOnAction(e -> {
            //changed field.getText() to fieldForAmounts.getText();
            Double amount = Double.parseDouble(fieldForAmounts.getText());
            cashMachine.withdraw(amount);

            areaInfo.setText(cashMachine.toString() + "\n"+ cashMachine.displayBalanceMessage());
            newTextField3.setText(""+cashMachine.displayBalance());

        });

        //Button btnExit = new Button("Exit");
        btnExit.setOnAction(e -> {
            cashMachine.exit();

            areaInfo.setText(cashMachine.toString());
            newTextField.setText("");
            newTextField1.setText("");
            newTextField2.setText("");
            newTextField3.setText("");
            fieldForAmounts.setText("");
            labelForAmounts.setDisable(true);
            fieldForAmounts.setDisable(true);
            label1.setDisable(true);
            newTextField.setDisable(true);
            label2.setDisable(true);
            newTextField1.setDisable(true);
            label3.setDisable(true);
            newTextField2.setDisable(true);
            label4.setDisable(true);
            newTextField3.setDisable(true);

        });

        FlowPane flowpane = new FlowPane();

        flowpane.getChildren().add(btnSubmit);
        flowpane.getChildren().add(btnDeposit);
        flowpane.getChildren().add(btnWithdraw);
        flowpane.getChildren().add(btnExit);
        flowpane.getChildren().add(labelLogin);
        flowpane.getChildren().add(label1);
        flowpane.getChildren().add(newTextField);
        flowpane.getChildren().add(label2);
        flowpane.getChildren().add(newTextField1);
        flowpane.getChildren().add(label3);
        flowpane.getChildren().add(newTextField2);
        flowpane.getChildren().add(label4);
        flowpane.getChildren().add(newTextField3);
        flowpane.getChildren().add(labelForAmounts);
        flowpane.getChildren().add(fieldForAmounts);

        vbox.getChildren().addAll(labelLogin, field, flowpane, labelForAmounts, fieldForAmounts,areaInfo, label1,newTextField,label2, newTextField1,
                label3, newTextField2, label4, newTextField3);


        return vbox;
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("WELCOME TO ZipCloudBank!");

        stage.setScene(new Scene(createContent()));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
