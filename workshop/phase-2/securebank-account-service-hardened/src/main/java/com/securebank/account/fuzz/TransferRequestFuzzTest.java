
package com.securebank.account.fuzz;

import com.securebank.account.model.TransferRequest;
import edu.berkeley.cs.jqf.fuzz.Fuzz;
import net.jqwik.api.constraints.Positive;

import java.math.BigDecimal;

public class TransferRequestFuzzTest {

    @Fuzz
    public void testFuzzInputs(@Positive long fromId, @Positive long toId, @Positive double amount) {
        TransferRequest request = new TransferRequest(fromId, toId, BigDecimal.valueOf(amount));
        assert request.getAmount().compareTo(BigDecimal.ZERO) > 0;
    }
}
