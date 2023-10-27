package org.example.manager;

import org.example.dto.Terminal;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Gère les différents terminaux
 */
public class TerminalManager {
    //Dictionnaire des terminaux avec le nom en clé
    Map<String, Terminal> terminals;

    TerminalManager(){
        terminals = new HashMap<>();
    }

    /**
     * Ajoute des terminaux à partir d'une liste
     * @param terminaux liste de terminaux
     */
    public void addTerminals(Set<String> terminaux){
        for (String s: terminaux){
            terminals.put(s, new Terminal(s));
        }
    }

    /**
     * @param x Nombre de conteneurs à ajouter
     * @param terminal Le terminal sur lequel l'opération s'effectue
     */
    public void addFrom(int x, String terminal){
        terminals.get(terminal).addContainer(x);
    }

    /**
     *
     * @param x Nombre de conteneurs à supprimer
     * @param terminal Le terminal sur lequel l'opération s'effectue
     */
    public void removeFrom(int x, String terminal){
        terminals.get(terminal).removeContainer(x);
    }

    public void displayStats(){
        for (Map.Entry<String, Terminal> entry : terminals.entrySet()) {
            Terminal value = entry.getValue();
            System.out.println("Terminal: " + value + " possède: " + value.getQuantity() + " conteneurs.");
        }
    }
}
