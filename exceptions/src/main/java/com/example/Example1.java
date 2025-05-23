package com.example;


class AccountBalanceException extends Throwable {
    double currentBalance;
    String message;

    //...
    public AccountBalanceException(double currentBalance, String message) {
        this.currentBalance = currentBalance;
        this.message = message;
    }
}

//----------------------------------------------
// Service Module ( business Logic ) ( team-1 )
//----------------------------------------------

class TransferService {
    public void transfer(double amount, String from, String to) throws AccountBalanceException {
        //...
        // Load 'from' & 'to' account details from database
        double fromAccountBalance = 1000.00;
        // check
        if (amount > fromAccountBalance) {
            throw new AccountBalanceException(fromAccountBalance, "No enough funds");
        }
    }
}

//----------------------------------------------
// Web-Module ( request & response logic ) ( team-2 )
//----------------------------------------------

class TransferController {

    TransferService transferService = new TransferService();

    public void handleTransferRequest(/*HttpRequest request*/) {
        //..

        try {
            // extract input params from request..

            double amount = 2000.00;
            String fromAccount = "from@oksbi";
            String toAccount = "to@oksbi";
            transferService.transfer(amount, fromAccount, toAccount);

            // Prepare success response
            System.out.println("Transfer success");
        } catch (AccountBalanceException e) {
            //
            // Provide user-friendy message ( via Http Response )
            // log.. for future fix
            // execute - plan-b
            // partialy handle & re-throw
            // clean any resources ( file } db-connection ) beaing used
            System.out.println("Transfer Failed");
            System.out.println("Ex-" + e.currentBalance + " , " + e.message);

        }

    }

}


public class Example1 {

    public static void main(String[] args) {
        TransferController transferController = new TransferController();
        transferController.handleTransferRequest(/**http-request**/);
    }

}
