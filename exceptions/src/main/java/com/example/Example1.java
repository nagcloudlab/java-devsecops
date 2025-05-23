package com.example;

/*
        Throwable
            - Exception
            - Error
        checked vs un-ckecked
 */


class AccountBalanceException extends RuntimeException /*unchecked*/ {
    double currentBalance;
    String message;

    //...
    public AccountBalanceException(double currentBalance, String message) {
        this.currentBalance = currentBalance;
        this.message = message;
    }
}

class OOMError extends Error {
}

class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(String message) {
        super(message);
    }
}

//----------------------------------------------
// Service Module ( business Logic ) ( team-1 )
//----------------------------------------------

class TransferService {
    public void transfer(double amount, String from, String to) /*throws AccountBalanceException*/ {
        //...
        // Load 'from' & 'to' account details from database
        //
        if (from.equals("from@oksbi")) {
            throw new AccountNotFoundException(from + " not found");
        }
        double fromAccountBalance = 1000.00;
        // check
        if (amount > fromAccountBalance) {
            throw new AccountBalanceException(fromAccountBalance, "No enough funds");
        }
    }
}

//----------------------------------------------
// Web-Module ( request & response logic ) ( team-1 )
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
            // clean the resources..
        } catch (AccountNotFoundException e) {
            // Provide user-friendy message ( via Http Response )
            // log.. for future fix
            // execute - plan-b
            // partialy handle & re-throw
            System.out.println("account not found issue");
        } catch (AccountBalanceException e) {
            //..
            System.out.println("account balance issue");
        } catch (Exception e) {
            System.out.println("any other issues");
        } finally {
            // // clean the resources..
        }

    }

}


public class Example1 {

    public static void main(String[] args) {
        TransferController transferController = new TransferController();
        transferController.handleTransferRequest(/**http-request**/);
    }

}
