package org.example.events;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Classe abstraite qui représente un évenement général
 */
public abstract class Event {
    protected String id;

    /**
     * Cette fonction représente l'action qui sera réalisée par un évenement
     */
    public abstract void run();
}
