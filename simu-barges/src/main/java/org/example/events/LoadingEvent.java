package org.example.events;

import org.example.manager.TerminalManager;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Evenement de chargement / départ d'un terminal
 */
public class LoadingEvent extends Event {
    private int amount;
    private String terminal;
    private static final AtomicInteger atom = new AtomicInteger();
    private TerminalManager terminalManager;

    public LoadingEvent(int amount, String terminal, TerminalManager terminalManager){
        this.id = "\033[3m" + "loading-" + atom.getAndIncrement() + "\033[0m";
        this.amount = amount;
        this.terminal = terminal;
        this.terminalManager = terminalManager;
    }

    /**
     * Lorsque l'on déclenche l'évenement, on enlève une certaine quantité de conteneurs sur le
     * terminal associé
     */
    @Override
    public void run() {
        System.out.println(id + " : " + "Chargement de " + "conteneurs depuis le terminal: " + terminal);
        terminalManager.removeFrom(amount, terminal);
    }
}
