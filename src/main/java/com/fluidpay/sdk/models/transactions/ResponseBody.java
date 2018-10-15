package com.fluidpay.sdk.models.transactions;

public class ResponseBody {
    private CardResponseBody card;
    private TerminalResponseBody terminal;
    private AchResponseBody ach;

    public CardResponseBody getCard() {
        return card;
    }

    public TerminalResponseBody getTerminal() {
        return terminal;
    }

    public AchResponseBody getAch() {
        return ach;
    }
}
