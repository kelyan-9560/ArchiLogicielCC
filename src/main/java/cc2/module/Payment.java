package cc2.module;

import cc2.use_cases.tradesman.domain.TradesMan;

public final class Payment {

    public void payement (TradesMan tradesMan){
        System.out.println("Paiment par " + tradesMan);
    }
}
