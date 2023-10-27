package org.example.events;

import org.example.manager.TerminalManager;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Evenement de déchargement / arrivé sur un terminal
 */
public class UnloadingEvent extends Event{
    private int amount;
    private String terminal;
    private static final AtomicInteger atom = new AtomicInteger();
    private TerminalManager terminalManager;

    public UnloadingEvent(int amount, String terminal, TerminalManager terminalManger){
        this.id = "\033[3m" + "unloading-" + atom.getAndIncrement() + "\033[0m";
        this.amount = amount;
        this.terminal = terminal;
        this.terminalManager = terminalManger;
    }

    /**
     * Lorsque cet évenement est déclenché, on ajoute une certaine quantité de conteneur sur
     * le terminal associé
     */
    @Override
    public void run() {
        System.out.println(id + " : " + "Déchargement de " + "conteneurs depuis le terminal: " + terminal);
        terminalManager.addFrom(amount, terminal);
    }
}
